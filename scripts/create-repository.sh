#!/bin/bash

OSGITOOLS_REPO_PATH=/home/glefur/Perso/repositories/osgitools
ECLIPSE_PATH=/home/glefur/Perso/Softwares/eclipses/mars-osgi-jee
BUNDLES_TO_ECLIPSIFY=hibernate-core-4.2.7.Final.jar

mvn package
#java -jar $OSGITOOLS_REPO_PATH/plugins/bundle-handler/target/bundle-handler.jar eclipsifyHibernateBundle $PWD/target/ $BUNDLES_TO_ECLIPSIFY
java -jar $OSGITOOLS_REPO_PATH/plugins/bundle-handler/target/bundle-handler.jar associateSourcesJar $PWD/target/
$OSGITOOLS_REPO_PATH/scripts/repositify.sh -a $ECLIPSE_PATH $PWD/target/
rm -rf target/
