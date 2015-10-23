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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>.
 *
 */
public class BundleEclipsifier {

	private static final String MANIFEST_FILE_PATH = "META-INF/MANIFEST.MF";
	private static final String BUNDLE_NEW_SUFFIX = ".eclipse";
	private static final String BUNDLE_SYMBOLIC_NAME_MANIFEST_ENTRY = "Bundle-SymbolicName";
	private static final String ECLIPSE_BUDDY_POLICY_MANIFEST_ENTRY = "Eclipse-BuddyPolicy";
	private static final String ECLIPSE_BUDDY_POLICY_MANIFEST_VALUE = "registered";

	/**
	 * @param args program arguments. This program expect 2 arguments:
	 * <ul>
	 * 	<li>1: file directory of the bundle to update</li>
	 *  <li>2: file name of the bundle to update</li>
	 * </ul>
	 */
	public static void main(String[] args) {
		if (args.length == 2) {
			System.out.println("Start. Eclipsifying bundle " + args[0] + args[1]);
			String filedir = args[0];
			String filename = args[1];
			File file = new File(filedir + filename);
			try {
				JarFile jarFile = new JarFile(file);
				File newFile = writeNewManifest(jarFile);
			    File tmpJarFile = createUpdatedJar(jarFile, newFile);
				replaceJar(file, tmpJarFile);
		        System.out.println("Done. Bundle updated!");
			} catch (IOException e) {
				System.err.println("An error occurred.");
				e.printStackTrace();
			}
		} else {
			System.err.println("This program expects 2 arguments: the directory and the file name of the bundle to update");
		}
	}

	private static File writeNewManifest(JarFile jarFile) throws IOException {
		System.out.println("Creating the new MANIFEST.");
		File newFile = File.createTempFile("updatedMANIFEST", ".MF");
		Manifest manifest = jarFile.getManifest();
		Manifest newManifest = new Manifest(manifest);
		Attributes mainAttributes = newManifest.getMainAttributes();
		String newBundleName = mainAttributes.getValue(BUNDLE_SYMBOLIC_NAME_MANIFEST_ENTRY) + BUNDLE_NEW_SUFFIX;
		mainAttributes.putValue(BUNDLE_SYMBOLIC_NAME_MANIFEST_ENTRY, newBundleName);
		System.out.println("New bundle name: " + newBundleName);
		mainAttributes.putValue(ECLIPSE_BUDDY_POLICY_MANIFEST_ENTRY, ECLIPSE_BUDDY_POLICY_MANIFEST_VALUE);
		OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(newFile));
		System.out.println("Writing the new MANIFEST file in a temporary file...");
		newManifest.write(outputStream);
		System.out.println("Done.");
		outputStream.close();
		return newFile;
	}

	private static File createUpdatedJar(JarFile jarFile, File newManifest) throws IOException {
		System.out.println("Creating the new jar file.");
	    File tmpJarFile = File.createTempFile("tmp_bundle", ".jar");
		JarOutputStream tempJarOutputStream = new JarOutputStream(new FileOutputStream(tmpJarFile));
		Enumeration<JarEntry> jarEntries = jarFile.entries();
		System.out.println("Copying files...");
		while(jarEntries.hasMoreElements()) {
		    JarEntry entry = jarEntries.nextElement();
		    InputStream entryInputStream;
		    if (MANIFEST_FILE_PATH.equals(entry.getName())) {
		    	System.out.println("Replacing the old MANIFEST by the new one");
		    	entryInputStream = new BufferedInputStream(new FileInputStream(newManifest));
		        JarEntry newEntry = new JarEntry(MANIFEST_FILE_PATH);
		    	tempJarOutputStream.putNextEntry(newEntry);
		    } else {
		    	entryInputStream = jarFile.getInputStream(entry);
		    	tempJarOutputStream.putNextEntry(entry);
		    }
		    byte[] buffer = new byte[1024];
		    int bytesRead = 0;
		    while ((bytesRead = entryInputStream.read(buffer)) != -1) {
		        tempJarOutputStream.write(buffer, 0, bytesRead);
		    }
		}
		tempJarOutputStream.close();
		System.out.println("Done.");
		return tmpJarFile;
	}

	private static void replaceJar(File file, File tmpJarFile) throws IOException {
		System.out.println("Replacing the old jar by the new one.");
		Path path = Paths.get(tmpJarFile.getPath());
		Path targetPath = Paths.get(file.getPath());
		Files.copy(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
	}

}
