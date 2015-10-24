#!/bin/bash

OSGITOOLS_REPO_PATH=
ECLIPSE_PATH=
BUNDLES_TO_ECLIPSIFY=

cp $OSGITOOLS_REPO_PATH/scripts/pom.xml ./
mvn package
java -jar $OSGITOOLS_REPO_PATH/plugins/bundle-eclipsifier/target/bundle-eclipsifier.jar $PWD/target/plugins/ $BUNDLES_TO_ECLIPSIFY
$OSGITOOLS_REPO_PATH/scripts/repositify.sh -a $ECLIPSE_PATH $PWD/target/
rm -rf pom.xml target/
