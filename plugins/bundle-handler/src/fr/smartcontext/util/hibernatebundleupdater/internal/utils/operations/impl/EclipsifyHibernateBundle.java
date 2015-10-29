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

import fr.smartcontext.util.hibernatebundleupdater.internal.utils.BundleHandler;
import fr.smartcontext.util.hibernatebundleupdater.internal.utils.ManifestBuilder;
import fr.smartcontext.util.hibernatebundleupdater.internal.utils.operations.Operation;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>.
 *
 */
public class EclipsifyHibernateBundle implements Operation {

	private static final String BUNDLE_NEW_SUFFIX = ".eclipse";
	private static final String BUNDLE_SYMBOLIC_NAME_MANIFEST_ENTRY = "Bundle-SymbolicName";
	private static final String ECLIPSE_BUDDY_POLICY_MANIFEST_ENTRY = "Eclipse-BuddyPolicy";
	private static final String ECLIPSE_BUDDY_POLICY_MANIFEST_VALUE = "registered";

	private String filedir;
	private String filename;

	public EclipsifyHibernateBundle(String filedir, String filename) {
		this.filedir = filedir;
		this.filename = filename;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.smartcontext.util.hibernatebundleupdater.internal.utils.operations.Operation#run()
	 */
	@Override
	public void run() throws IOException {
		BundleHandler handler = new BundleHandler(filedir + "plugins/" + filename);
		handler.updateManifest(ManifestBuilder.newInstance(handler.getManifest())
				.addHeader(BUNDLE_SYMBOLIC_NAME_MANIFEST_ENTRY, handler.getHeader(BUNDLE_SYMBOLIC_NAME_MANIFEST_ENTRY) + BUNDLE_NEW_SUFFIX)
				.addHeader(ECLIPSE_BUDDY_POLICY_MANIFEST_ENTRY, ECLIPSE_BUDDY_POLICY_MANIFEST_VALUE)
				.build());
	}

}
