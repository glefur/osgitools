/**
 * OSGi/JEE Sample.
 * 
 * Copyright (C) 2015 Goulwen Le Fur
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
package fr.smartcontext.util.hibernatebundleupdater.internal.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.jar.Manifest;


/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>.
 *
 */
public class ManifestBuilder {

	public static final ManifestBuilder newInstance() {
		return new ManifestBuilder();
	}

	public static final ManifestBuilder newInstance(Manifest srcManifest) {
		return new ManifestBuilder(srcManifest);
	}

	private Map<String, String> headers;
	private Manifest srcManifest;
	
	private ManifestBuilder() {
		headers = new HashMap<String, String>();
	}

	private ManifestBuilder(Manifest srcManifest) {
		this();
		this.srcManifest = srcManifest;
	}

	public ManifestBuilder addHeader(String header, String value) {
		headers.put(header, value);
		return this;
	}
	
	public Manifest build() {
		Manifest result;
		if (srcManifest != null) {
			result = new Manifest(srcManifest);
		} else {
			result = new Manifest();
		}
		for (Entry<String, String> entry : headers.entrySet()) {
			result.getMainAttributes().putValue(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
