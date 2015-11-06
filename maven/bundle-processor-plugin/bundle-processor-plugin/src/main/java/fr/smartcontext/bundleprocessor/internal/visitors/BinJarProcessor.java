/**
 * 
 * OSGi/JEE Sample.
 * Copyright (C) 2014 Goulwen Le Fur
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.smartcontext.bundleprocessor.internal.visitors;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import fr.smartcontext.bundleprocessor.internal.utils.BundleHandler;
import fr.smartcontext.bundleprocessor.internal.utils.ManifestBuilder;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>.
 *
 */
public class BinJarProcessor extends SimpleFileVisitor<Path> {
	
	public static final String JAR_FILE_EXTENSION = "jar";
	private Map<String, Path> sourcesJar;
	private String repositoryDir;
	private Collection<String> processedJars;
	
	public BinJarProcessor(String args, Map<String, Path> sourcesJar) {
		this.repositoryDir = args;
		this.sourcesJar = sourcesJar;
		processedJars = new ArrayList<String>();
	}
	
	/**
	 * @return the processedJars
	 */
	public Collection<String> getProcessedJars() {
		return processedJars;
	}

	/**
	 * {@inheritDoc}
	 * @see java.nio.file.SimpleFileVisitor#visitFile(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		String filename = file.getFileName().toString();
		if (filename.endsWith(JAR_FILE_EXTENSION)) {
			String key = filename.substring(0, filename.length() - (JAR_FILE_EXTENSION.length() + 1));
			Path path = sourcesJar.get(key);
			if (path != null) {
				BundleHandler binJarHandler = new BundleHandler(repositoryDir + "/plugins/" + filename);
				if (binJarHandler.isOSGiBundle()) {
					BundleHandler srcJarHandler = new BundleHandler(repositoryDir + "/sources/" + path.getFileName().toString());
					ManifestBuilder builder = ManifestBuilder.newInstance(srcJarHandler.getManifest());
					for (String header : binJarHandler.getHeaders()) {
						if (header.startsWith("Bundle-")) {
							if ("Bundle-SymbolicName".equals(header)) {
								String headerValue = binJarHandler.getHeader(header);
								builder.addHeader(header, generateNewBundleSymbolicName(headerValue));
							} else if ("Bundle-Name".equals(header)) {
								builder.addHeader(header, "Sources for " + binJarHandler.getHeader(header));								
							} else {
								builder.addHeader(header, binJarHandler.getHeader(header));
							}
						}
					}
					builder.addHeader("Eclipse-SourceBundle", binJarHandler.getHeader("Bundle-SymbolicName") + ";version=\"" + binJarHandler.getHeader("Bundle-Version") + "\";roots:=\".\"");
					srcJarHandler.updateManifest(builder.build());
					processedJars.add(path.getFileName().toString());
				} else {
					System.err.println("Unable to process " + file + ". This jar isn't an OSGi bundle");
				}
			} else {
				System.out.println("No sources for " + file);
			}
		} 
		return CONTINUE;
	}

	private String generateNewBundleSymbolicName(String headerValue) {
		if (headerValue.indexOf(';') < 0) {
			return headerValue + ".source";
		} else {
			String symbolicName = headerValue.substring(0, headerValue.indexOf(';'));
			String directives = headerValue.substring(headerValue.indexOf(';'), headerValue.length());
			return symbolicName + ".source" + directives;
		}
	}

}
