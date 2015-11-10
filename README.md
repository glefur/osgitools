# osgitools

## Overview

This repository hosts a set of tools easing the OSGi development. 

These tools are used to create the p2CoJaL repository so an example of usage of those can be found in the associated github repository: https://github.com/glefur/p2CoJaL .

## Shell scripts

### create-repo-from-maven

This script uses a list of maven dependencies to generate a P2 repository. Here is an example pom.xml file for this:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>fr.smartcontext</groupId>
    <artifactId>repositories.p2.p2CoJaL</artifactId>
    <version>0.9.0-SNAPSHOT</version>

    <parent>
      <groupId>fr.smartcontext</groupId>
      <artifactId>dependencies-downloader</artifactId>
      <relativePath>path/to/osgitools/scripts/pom.xml</relativePath>
      <version>0.9.0-SNAPSHOT</version>
    </parent>

    <dependencies>
      <dependency>
          <groupId>commons-collections</groupId>
          <artifactId>commons-collections</artifactId>
          <version>${commons-collections-version}</version>
      </dependency>
      <!-- another dependency ...-->
    </dependencies>

    <!-- extra build directives -->
 </project>

```

Notice that the pom.xml should use the artifact `fr.smartcontext:dependencies-downloader` as parent pom.

Once this file defined, the shell script can be invoked with the following syntax:

```
./create-repo-from-maven -a /path/to/eclipse [-t /path/to/target/directory] /path/to/src/directory/

```

The *-a* argument define the p2 agent to use. You can either use a standard eclipse installation (since version 3.4) or a tool like p2-admin (https://github.com/mbarbero/p2-admin) for this. The argument should refer to the root directory of the p2 agent.

The optional *-t* argument define the directory where the repository must be created. If this argument is used, the repository will be located at */path/of/the/target/argument/repository* otherwise it will be located at */path/to/the/pomfile/repository*.

Finally, the trailing argument should refer to the directory containing the *pom.xml* file listing the expected bundles.

### create-repo-from-fs
This script builds a P2 repository including bundles (and optionally features) stored in a specific directory of the filesystem. The directory passed to the script should be organized as expect by a p2 agent:

- root-directory
  - plugins
    - bundle1
    - bundle2
    - ...
  - features
    


    - feature1
    - feature2
    - ...
  - category.xml

Note that features and category.xml files is optional. Once the directory organized in this way, the shell script can be invoked with the following syntax:

```
./create-repo-from-fs.sh -a /path/to/eclipse [-t /path/to/target/directory] /path/to/src/directory/
```
The *-a* argument define the p2 agent to use. You can either use a standard eclipse installation (since version 3.4) or a tool like p2-admin (https://github.com/mbarbero/p2-admin) for this. The argument should refer to the root directory of the p2 agent.

The optional *-t* argument define the directory where the repository must be created. If this argument is used, the repository will be located at */path/of/the/target/argument/repository* otherwise it will be located at */path/to/the/pomfile/repository*.

Finally, the trailing argument should refer to the directory containing the bundles and the features expected in the target repository.

## Maven plugins

### bundle-processor-plugin

This maven plugin enables user to modify OSGi bundles during a build. Two goals are provided by this plugin.

#### Goal *addEclipseBuddyPolicyToBundle*
This goal adds a Eclipse specific header to the MANIFEST of a given bundle. This header has the following structure:

```
Eclipse-BuddyPolicy: registered
```
It allows equinox (the Eclipse powered OSGi bundle) to performed specific operations from the modified bundle's classpath. This modification is especially usefull for some framework like hibernate.
During the goal execute, the maven plugin also add the suffix ".eclipse" to the symbolic name of the modified bundle. This mark the bundle has modified.

Parameters of this goal are:

- bundleFilename (mandatory): filename of the jar containing the bundle to modify
- repositoryPath (optional): directory containing this jar. If not specify, the goal will look for the jar in the *${project.build.directory}/plugin/* directory

In a maven project having a depency to this plugin:

```xml
      <plugins>
       <plugin>
          <groupId>fr.smartcontext</groupId>
          <artifactId>bundle-processor-plugin</artifactId>
          <version>0.9.0-SNAPSHOT</version>
        </plugin>
      </plugins>
```
The goal can be invoked by this way:
```
mvn fr.smartcontext:bundle-processor-plugin:addEclipseBuddyPolicyToBundle -DrepositoryPath=/path/to/the/jar -DbundleFilename=org.hibernate.core.eclipse_4.2.7.Final.jar
```
or defined in a pom.xml file:
```xml
        <plugin>
          <groupId>fr.smartcontext</groupId>
          <artifactId>bundle-processor-plugin</artifactId>
          <version>0.9.0-SNAPSHOT</version>
          <executions>
            <execution>
              <id>Add Eclipse Buddy Policy to Hibernate Bundle</id>
              <phase>package</phase>
              <goals>
                <goal>addEclipseBuddyPolicyToBundle</goal>
              </goals>
              <configuration>
                <bundleFilename>hibernate-core-4.2.7.Final.jar</bundleFilename>
              </configuration>              
            </execution>
          </executions>
        </plugin>
```

The default execution phase for this goal is `LifecyclePhase.INTEGRATION_TEST`.

#### Goal *associateSourcesBundles*
This goal look for source jars in a given directory and try to associate them to existing (binary) bundles in another directory. It is especially usefull when you download sources jar of framework with maven and you want to convert them in source bundles for Eclipse.

The association between the source jar and the binary bundle is made via a naming convention (the source jar should have the same name that the jar host the OSGi bundle suffixed by '-sources'). The goal converts the source jar in OSGi Bundle by populating its MANIFEST.MF file with headers coming from the binary bundle. Only the *Bundle-SymbolicName* and the *Bundle-Description* are changed to avoid conflict and to explicit the 'source nature' of the bundle. Once the modification done, the source bundles are move in the same directory than the binary bundle (in order to prepare the creation of a P2 repository).

The only parameter of this goal is:
- repositoryPath (optional): path to the directory containing the binary bundles and the source jars. If not defined, the *${project.build.directory}/plugin/* directory is used.

The target directory should be organized in this way:
- repositoryPath
  + plugins
    * bundle1.jar
    * bundle2.jar
    * ...
  + sources
    * bundle1-sources.jar
    * bundle2-sources.jar
    * ...

In a maven project having a depency to this plugin:

```xml
      <plugins>
       <plugin>
          <groupId>fr.smartcontext</groupId>
          <artifactId>bundle-processor-plugin</artifactId>
          <version>0.9.0-SNAPSHOT</version>
        </plugin>
      </plugins>
```
The goal can be invoked by this way:
```
mvn fr.smartcontext:bundle-processor-plugin:associateSourcesBundles -DrepositoryPath=/path/to/the/repository
```
or defined in a pom.xml file:
```xml
        <plugin>
          <groupId>fr.smartcontext</groupId>
          <artifactId>bundle-processor-plugin</artifactId>
          <version>0.9.0-SNAPSHOT</version>
          <executions>
             <execution>
              <id>Associate sources bundles</id>
              <phase>integration-test</phase>
              <goals>
                <goal>associateSourcesBundles</goal>
              </goals>
            </execution>
          </executions>
        </plugin>
```

The default execution phase for this goal is `LifecyclePhase.POST_INTEGRATION_TEST`.

### Installation

Since this maven plugin isn't yet deployed on maven central, you have to install it in your own maven repository. To do this, check out the osgitools repository, go to the *maven/bundle-processor-plugin/bundle-processor-plugin/* directory and run a `mvn install` command.

## Eclipse tooling:

### OSGi Tooling

A set of Eclipse plugins for performing cartography and analysis on OSGi declarative service. Until rework on this part, this tooling is deprecated.
