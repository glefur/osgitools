/**
 * OSGi/JEE Sample.
 * 
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
package fr.smartcontext.util.hibernatebundleupdater.internal.visitors;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import fr.smartcontext.util.hibernatebundleupdater.internal.utils.BundleHandler;
import fr.smartcontext.util.hibernatebundleupdater.internal.utils.ManifestBuilder;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>.
 *
 */
public class BinJarProcessor extends SimpleFileVisitor<Path> {
	
	public static final String JAR_FILE_EXTENSION = "jar";
	private Map<String, Path> sourcesJar;
	private String binJarDir;
	private Collection<Path> processedJars;
	
	public BinJarProcessor(String args, Map<String, Path> sourcesJar) {
		this.binJarDir = args;
		this.sourcesJar = sourcesJar;
		processedJars = new ArrayList<Path>();
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
				BundleHandler binJarHandler = new BundleHandler(binJarDir + "/plugins/" + filename);
				if (binJarHandler.isOSGiBundle()) {
					BundleHandler srcJarHandler = new BundleHandler(binJarDir + "/sources/" + path.getFileName().toString());
					ManifestBuilder builder = ManifestBuilder.newInstance(srcJarHandler.getManifest());
					for (String header : binJarHandler.getHeaders()) {
						if (header.startsWith("Bundle-")) {
							if ("Bundle-SymbolicName".equals(header)) {
								builder.addHeader(header, binJarHandler.getHeader(header) + "-sources");
							} else if ("Bundle-Name".equals(header)) {
								builder.addHeader(header, "Sources for " + binJarHandler.getHeader(header));								
							} else {
								builder.addHeader(header, binJarHandler.getHeader(header));
							}
						}
					}
					builder.addHeader("Eclipse-SourceBundle", binJarHandler.getHeader("Bundle-SymbolicName") + ";version=\"" + binJarHandler.getHeader("Bundle-Version") + "\";roots:=\".\"");
					srcJarHandler.updateManifest(builder.build());
//					processedJars.add(e)
				} else {
					System.err.println("Unable to process " + file);
				}
			} else {
				System.out.println("No sources for " + file);
			}
		} else {
			System.err.println("Unable to process " + file);
		}
		return CONTINUE;
	}

}
