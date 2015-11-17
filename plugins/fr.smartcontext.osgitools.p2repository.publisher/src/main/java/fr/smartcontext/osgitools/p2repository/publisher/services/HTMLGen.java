/*******************************************************************************
 * Copyright (c) 2015 Goulwen Le Fur.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.smartcontext.osgitools.p2repository.publisher.services;

import fr.smartcontext.osgitools.p2repository.publisher.internal.data.Artifact;
import fr.smartcontext.osgitools.p2repository.publisher.internal.data.P2Repository;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>
 *
 */
public class HTMLGen {
	
	public String repositoryArtifacts(P2Repository repo) {
		StringBuilder builder = 
				new StringBuilder("<table class=\"alt\">\n")
					.append("\t<thead>\n")
					.append("\t\t<tr>\n")
					.append("\t\t\t<th>ID</th><th>Name</th><th>Version</th><th>Description</th>\n")
					.append("\t\t</tr>\n")
					.append("\t</thead>\n")
					.append("\t<tbody>\n");
		
		for (Artifact artifact : repo.getArtifacts()) {
			builder
				.append("\t\t<tr>\n\t\t\t<td>")
					.append(artifact.getId())
				.append("</td><td>")
					.append(artifact.getName())
				.append("</td><td>")
					.append(artifact.getVersion())
				.append("</td><td>");
				String description = artifact.getDescription();
				if (description != null) {
					builder.append(description);
				}
				builder.append("</td>\n\t\t</tr>\n");
			
		}
		builder.append("\t</tbody>\n</table>");
		return builder.toString();
	}

}
