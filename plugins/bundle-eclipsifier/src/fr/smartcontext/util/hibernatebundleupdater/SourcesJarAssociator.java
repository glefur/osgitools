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
package fr.smartcontext.util.hibernatebundleupdater;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import fr.smartcontext.util.hibernatebundleupdater.internal.visitors.BinJarProcessor;
import fr.smartcontext.util.hibernatebundleupdater.internal.visitors.SourcesJarIndexer;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>.
 *
 */
public class SourcesJarAssociator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Path sourcesJarDir = Paths.get(args[0] + "/sources");
			SourcesJarIndexer finder = new SourcesJarIndexer();
			Files.walkFileTree(sourcesJarDir, finder);
			Path binJarDir = Paths.get(args[0] + "/plugins");
			BinJarProcessor processor = new BinJarProcessor(args[0], finder.getJars());
			Files.walkFileTree(binJarDir, processor);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
