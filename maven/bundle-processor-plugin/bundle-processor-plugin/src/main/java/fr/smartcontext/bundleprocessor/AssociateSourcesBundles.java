package fr.smartcontext.bundleprocessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import fr.smartcontext.bundleprocessor.internal.visitors.BinJarProcessor;
import fr.smartcontext.bundleprocessor.internal.visitors.SourcesJarIndexer;

/**
 *
 */
@Mojo(name = "associateSourcesBundles", defaultPhase = LifecyclePhase.POST_INTEGRATION_TEST)
public class AssociateSourcesBundles extends AbstractMojo {


	@Parameter(defaultValue = "${project.build.directory}", property = "repositoryPath", required = true)
	private String repositoryPath;

	public void execute() throws MojoExecutionException {
		getLog().info("Processing repository " + repositoryPath);
		try {
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
		} catch (IOException e) {
			throw new MojoExecutionException("An error occurred", e);
		}
		getLog().info("done.");
	}
}
