# osgitools

## Overview

This repository hosts a set of tools easing the OSGi development. 

Those tools are used to create the p2CoJaL repository. Check out the associated github repository: https://github.com/glefur/p2CoJaL to get an example of their use.

## Shell scripts

### create-repo-from-maven

This script uses a list of maven dependencies to generate a P2 repository. Here is an example pom.xml to create for this use:

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
./create-repo-from-maven.sh -a /path/to/eclipse [-t /path/to/target/directory -p /path/to/a/p2repoPublisher -g /path/to/a/publishing/template] /path/to/src/directory/

```

The *-a* argument defines the p2 agent to use. You can either use a standard eclipse installation (since version 3.4) or a tool like p2-admin (https://github.com/mbarbero/p2-admin) for this. The argument should refer to the root directory of the p2 agent.

The optional *-t* argument define the directory where the repository must be created. If this argument is used, the repository will be located at */path/of/the/target/argument/repository* otherwise it will be located at */path/to/the/pomfile/repository*.

The optional *-p* and *-g* arguments enable (if they are set) a publishing operation. the *-p* argument should point on a p2repoPublisher application (see Eclipse tools: p2repoPublisher section) and the *-g* should point on a template to use with the p2repoPublisher. Note that, in case of use of the *-p* parameter, the *-g* parameter must be defined, otherwise no publishing would be executed. Once the repository built, the p2repoPublisher pointed will be invoked with the specified template to generate a webpage describing the repository. In order to set up properties for this publishing, a *repo.properties* file can be set next to the pom.xml describing the repository.

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

Note that features and category.xml files are optional. Once the directory organized in this way, the shell script can be invoked with the following syntax:

```
./create-repo-from-fs.sh -a /path/to/eclipse [-t /path/to/target/directory] /path/to/src/directory/
```
The *-a* argument defines the p2 agent to use. You can either use a standard eclipse installation (since version 3.4) or a tool like p2-admin (https://github.com/mbarbero/p2-admin) for this. The argument should refer to the root directory of the p2 agent.

The optional *-t* argument defines the directory where the repository must be created. If this argument is used, the repository will be located at */path/of/the/target/argument/repository* otherwise it will be located at */path/to/the/pomfile/repository*.

Finally, the trailing argument should refer to the directory containing the bundles and the features expected in the target repository.

## Maven plugins

### bundle-processor-plugin

This maven plugin enables user to modify OSGi bundles during a build. Two goals are provided by this plugin.

#### Goal *addEclipseBuddyPolicyToBundle*
This goal adds a Eclipse specific header to the MANIFEST of a given bundle. This header has the following structure:

```
Eclipse-BuddyPolicy: registered
```
It allows equinox (the Eclipse powered OSGi bundle) to performed specific operations from the modified bundle's classpath. This modification is useful in some frameworks like Hibernate.
During the goal execution, the maven plugin will also add the suffix ".eclipse" to the symbolic name of the modified bundle. This is done to mark the bundle as *modified*.

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
This goal looks for source jars in a given directory and try to associate them to existing (binary) bundles in another directory. It is useful when you download sources jar of a framework with maven and you want to convert them in source bundles for Eclipse.

The association between the source jars and the binary bundles is done via a naming convention (the source jar should have the same name that the jar host the OSGi bundle suffixed by '-sources'). The goal converts the source jar in OSGi Bundle by populating its MANIFEST.MF file with headers coming from the binary bundle. Only the *Bundle-SymbolicName* and the *Bundle-Description* are changed to avoid conflict and to explicit the 'source nature' of the bundle. Once the modification done, the source bundles are moved in the same directory than the binary bundle (in order to prepare the creation of a P2 repository).

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

### p2repoPublisher

This Eclipse based tool generate a webpage describing the contents of a given p2 repository. It uses yatte (https://github.com/glefur/yatte) as template engine to generate the page.

#### usage
```
./p2repoPublisher -a /path/to/eclipse -t /path/to/template -r /path/to/p2/repository -o /path/to/output/file -p /path/to/properties/file
```

The *-a* argument defines the p2 agent to use. You can either use a standard eclipse installation (since version 3.4) or a tool like p2-admin (https://github.com/mbarbero/p2-admin) for this. The argument should refer to the root directory of the p2 agent.

The *-t* argument defines the template to use for generating the output file.

The *-r* argument specifies the path to the p2 repository to publish.

Finally, the *-o* argument defines the output files where the data will be published.

The *-p* argument allows user to point to a properties files to give additional information about the analyzed repository (name, description...)

> p2repoPublisher currently requires Java 8 to run. Otherwise yatte would not be able to be loaded.


#### Template
When defining your publishing template, you can use the directive
```
<!--gen:service qname=fr.smartcontext.osgitools.p2repository.publisher.services.HTMLGen target=repo operation=repositoryArtifacts-->
```
to produce an HTML table listing all the artifacts contained in the repository. You can also use every properties you define in the referenced properties file. For instance, if you use a properties file containing the following line:
``` 
repo.name=My Repo
```
You can generate the name of your repo via: 
```
<!--gen:feature target=repo feature=name-->
```

#### Build
To build the p2repoPublisher, go to the directory *osgitools/environments/fr.smartcontext.osgitools.p2repository.publisher.environment/maven/aggregator* and run a `mvn clean package`

#### Properties
A properties file must be defined for p2repoPublisher usage. This file must contain, at least, the following line:
```
repo.type=fr.smartcontext.osgitools.p2repository.publisher.internal.data.P2Repository
```
You can optionally add the following properties:
```
repo.name=My Repo
repo.description=My Repo description
repo.version=Version of my repo
```

### OSGi Tooling

A set of Eclipse plugins for performing cartography and analysis on OSGi declarative service. Until rework on this part, this tooling is deprecated.
