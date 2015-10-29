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
package fr.smartcontext.util.hibernatebundleupdater;

import java.io.IOException;

import fr.smartcontext.util.hibernatebundleupdater.internal.utils.operations.Operation;
import fr.smartcontext.util.hibernatebundleupdater.internal.utils.operations.impl.AssociateSourceJar;
import fr.smartcontext.util.hibernatebundleupdater.internal.utils.operations.impl.EclipsifyHibernateBundle;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>.
 *
 */
public class BundleHandlerApplication {


	/**
	 * @param args program arguments. This program expect 2 arguments:
	 * <ul>
	 * 	<li>1: file directory of the bundle to update</li>
	 *  <li>2: file name of the bundle to update</li>
	 * </ul>
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			Operation operation;
			if ("eclipsifyHibernateBundle".equals(args[0])) {
				if (args.length == 3) {
					operation = new EclipsifyHibernateBundle(args[1], args[2]);
				} else {
					System.err.println("Invalid arguments");
					usage();
					return;
				}
			} else if ("associateSourcesJar".equals(args[0])) {
				if (args.length == 2) {
					operation = new AssociateSourceJar(args[1]);				
				} else {
					System.err.println("Invalid arguments");
					usage();
					return;
				}
			} else {
				System.err.println("Unknown command");
				usage();
				return;
			}
			try {
				operation.run();
			} catch (IOException e) {
				System.err.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			System.err.println("Invalid arguments");
			usage();
		}

	}
	
	public static void usage() {
		System.out.println("Bundle Hander Usage:");
		System.out.println("--------------------");
		System.out.println("BundleHander <command> <repository> [options]");
		System.out.println("Available commands are:");
		System.out.println();
		System.out.println("eclipsifyHibernateBundle <repository> <hibernate-bundle>");
		System.out.println();
		System.out.println("Change a standard hibernate bundle to an eclipse-compliant bundle.");
		System.out.println();
		System.out.println("\t<repository>: full path to the repository hosting bundles");		
		System.out.println("\t<hibernate-bundle>: file name of the jar containing the hibernate bundle");		
		System.out.println();
		System.out.println("associateSourcesJar <repository> <hibernate-bundle>");
		System.out.println();
		System.out.println("Convert a set of sources bundles to eclipse-compliant sources bundles.");
		System.out.println();
		System.out.println("\t<repository>: full path to the repository hosting bundles and sources");		
	}
}