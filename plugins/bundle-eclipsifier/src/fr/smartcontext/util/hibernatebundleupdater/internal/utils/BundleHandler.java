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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Set;
import java.util.jar.Attributes.Name;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/**
 * @author <a href="mailto:goulwen.lefur@gmail.com">Goulwen Le Fur</a>.
 *
 */
public class BundleHandler {

	public static final String MANIFEST_FILE_PATH = "META-INF/MANIFEST.MF";
	public static final String BUNDLE_SYMBOLIC_NAME_HEADER = "Bundle-SymbolicName";
	
	private File sourceFile;
	private JarFile jarFile;
	private Manifest manifest;
	
	public BundleHandler(String jarPath) throws IOException {
		sourceFile = new File(jarPath);
		jarFile = new JarFile(sourceFile);
		manifest = jarFile.getManifest();
	}
	
	public boolean isOSGiBundle() {
		return getHeader(BUNDLE_SYMBOLIC_NAME_HEADER) != null;
	}
	
	public Manifest getManifest() {
		return manifest;
	}

	public String getHeader(String header) {
		return manifest.getMainAttributes().getValue(header);
	}
	
	public Collection<String> getHeaders() {
		Set<Object> keySet = manifest.getMainAttributes().keySet();
		Collection<String> result = new ArrayList<>();
		for (Object key : keySet) {
			result.add(((Name) key).toString());
		}
		return result;
	}
	
	public void updateManifest(Manifest manifest) throws IOException {
		File newFile = writeNewManifest(jarFile, manifest);
	    File tmpJarFile = createUpdatedJar(jarFile, newFile);
		replaceJar(sourceFile, tmpJarFile);
		this.jarFile = new JarFile(sourceFile);
		this.manifest = jarFile.getManifest();
	}
	

	private File writeNewManifest(JarFile jarFile, Manifest newManifest) throws IOException {
		File newFile = File.createTempFile("updatedMANIFEST", ".MF");
		OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(newFile));
		newManifest.write(outputStream);
		outputStream.close();
		return newFile;
	}

	private File createUpdatedJar(JarFile jarFile, File newManifest) throws IOException {
	    File tmpJarFile = File.createTempFile("tmp_bundle", ".jar");
		JarOutputStream tempJarOutputStream = new JarOutputStream(new FileOutputStream(tmpJarFile));
		Enumeration<JarEntry> jarEntries = jarFile.entries();
		while(jarEntries.hasMoreElements()) {
		    JarEntry entry = jarEntries.nextElement();
		    InputStream entryInputStream;
		    if (MANIFEST_FILE_PATH.equals(entry.getName())) {
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
		return tmpJarFile;
	}

	private void replaceJar(File file, File tmpJarFile) throws IOException {
		Path path = Paths.get(tmpJarFile.getPath());
		Path targetPath = Paths.get(file.getPath());
		Files.copy(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
	}
}
