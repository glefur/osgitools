/*******************************************************************************
 * Copyright (c) 2015 Goulwen Le Fur.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package fr.smartcontext.osgitools.p2repository.publisher.internal.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class P2Repository {

	private String name;
	private String version;
	private String description;
	private List<Artifact> artifacts;
	
	/**
	 * 
	 */
	public P2Repository() {
		this.artifacts = new ArrayList<>();
	}

	/**
	 * @param name
	 * @param version
	 */
	public P2Repository(String name, String version, String description) {
		this();
		this.name = name;
		this.version = version;
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the artifacts
	 */
	public List<Artifact> getArtifacts() {
		return artifacts;
	}
	
	public void addArtifact(Artifact artifact) {
		artifacts.add(artifact);
	}
	
	public void removeArtifact(Artifact artifact) {
		artifacts.remove(artifact);
	}
	
}
