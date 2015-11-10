osgitools
=========

# Overview

This repository hosts a set of tools easing the OSGi development. 

#Shell scripts

## create-repo-from-maven

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

Once this script defined, the shell script can be invoked with the following syntax:

```
./create-repo-from-maven -a /path/to/eclipse [-t /path/to/target/directory] /path/to/src/directory/

```

The *-a* argument define the p2 agent to use. You can either use a standard eclipse installation (since version 3.4) or a tool like p2-admin (https://github.com/mbarbero/p2-admin) for this. The argument should refer to the root directory of the p2 agent.

The optional *-t* argument define the directory where the repository must be created. If this argument is used, the repository will be located at */path/of/the/target/argument/repository* otherwise it will be located at */path/to/the/pomfile/repository*.

Finally, the trailing argument should refer to the directory containing the *pom.xml* file listing the expected bundles.

## create-repo-from-fs
A shell script easing the creation of P2 repository from a specific directory on the filesystem

#Maven plugins

## bundle-processor-plugin

 a maven plugin allowing OSGi bundle modifying during a build

#Eclipse tooling:

## OSGi Tooling

A set of Eclipse plugins for OSGi cartography (deprecated)

These tools are used to create the p2CoJaL repository so examples of usage can be found in the associated repository: https://github.com/glefur/p2CoJaL .

