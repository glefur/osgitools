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
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>.
 *
 */
public class SourcesJarIndexer extends SimpleFileVisitor<Path> {
	
	public static final String SOURCES_JAR_SUFFIX = "-sources";
	public static final String JAR_FILE_EXTENSION = "jar";
	private static final String SOURCES_JAR_END_FILENAME = SOURCES_JAR_SUFFIX + "." + JAR_FILE_EXTENSION;
	
	private Map<String, Path> jars;

	public SourcesJarIndexer() {
		jars = new HashMap<>();
	}
	
	public Map<String, Path> getJars() {
		return jars;
	}

	/**
	 * {@inheritDoc}
	 * @see java.nio.file.SimpleFileVisitor#visitFile(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		String filename = file.getFileName().toString();
		if (filename.endsWith(SOURCES_JAR_END_FILENAME)) {
			String key = filename.substring(0, filename.length() - SOURCES_JAR_END_FILENAME.length());
			jars.put(key, file);
		} else {
			System.err.println("Unable to process " + file);
		}
		return CONTINUE;
	}

}
