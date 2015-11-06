package fr.smartcontext.bundleprocessor;

import java.io.IOException;

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

import fr.smartcontext.bundleprocessor.internal.utils.BundleHandler;
import fr.smartcontext.bundleprocessor.internal.utils.ManifestBuilder;

/**
 *
 */
@Mojo(name = "addEclipseBuddyPolicyToBundle", defaultPhase = LifecyclePhase.INTEGRATION_TEST)
public class AddEclipseBuddyPolicyToBundle extends AbstractMojo {

	private static final String BUNDLE_NEW_SUFFIX = ".eclipse";
	private static final String BUNDLE_SYMBOLIC_NAME_MANIFEST_ENTRY = "Bundle-SymbolicName";
	private static final String ECLIPSE_BUDDY_POLICY_MANIFEST_ENTRY = "Eclipse-BuddyPolicy";
	private static final String ECLIPSE_BUDDY_POLICY_MANIFEST_VALUE = "registered";

	@Parameter(defaultValue = "${project.build.directory}", property = "repositoryPath", required = true)
	private String repositoryPath;

	@Parameter(property = "bundleFilename", required = true)
	private String bundleFilename;

	public void execute() throws MojoExecutionException {
		BundleHandler handler;
		getLog().info("Processing " + bundleFilename + " in repository " + repositoryPath);
		try {
			handler = new BundleHandler(repositoryPath + "/plugins/" + bundleFilename);
			handler.updateManifest(ManifestBuilder.newInstance(handler.getManifest())
					.addHeader(BUNDLE_SYMBOLIC_NAME_MANIFEST_ENTRY, handler.getHeader(BUNDLE_SYMBOLIC_NAME_MANIFEST_ENTRY) + BUNDLE_NEW_SUFFIX)
					.addHeader(ECLIPSE_BUDDY_POLICY_MANIFEST_ENTRY, ECLIPSE_BUDDY_POLICY_MANIFEST_VALUE)
					.build());
		} catch (IOException e) {
			throw new MojoExecutionException("An error occurred", e);
		}
		getLog().info("done.");
	}
}
