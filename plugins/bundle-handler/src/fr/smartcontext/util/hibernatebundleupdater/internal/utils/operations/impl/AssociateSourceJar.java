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
package fr.smartcontext.util.hibernatebundleupdater.internal.utils.operations.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;

import fr.smartcontext.util.hibernatebundleupdater.internal.utils.operations.Operation;
import fr.smartcontext.util.hibernatebundleupdater.internal.visitors.BinJarProcessor;
import fr.smartcontext.util.hibernatebundleupdater.internal.visitors.SourcesJarIndexer;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>.
 *
 */
public class AssociateSourceJar implements Operation {
	
	private String repositoryPath;
	
	public AssociateSourceJar(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.util.hibernatebundleupdater.internal.utils.operations.Operation#run()
	 */
	@Override
	public void run() throws IOException {
		Path sourcesJarDir = Paths.get(repositoryPath + "/sources");
		SourcesJarIndexer finder = new SourcesJarIndexer();
		Files.walkFileTree(sourcesJarDir, finder);
		Path binJarDir = Paths.get(repositoryPath + "/plugins");
		BinJarProcessor processor = new BinJarProcessor(repositoryPath, finder.getJars());
		Files.walkFileTree(binJarDir, processor);
		Collection<String> processedJars = processor.getProcessedJars();
		for (String jarName : processedJars) {
			Path jarPath = Paths.get(repositoryPath, "sources", jarName);
			Path targetPath = Paths.get(repositoryPath, "plugins", jarName);
			Files.move(jarPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
		}
	}

}
