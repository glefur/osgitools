#!/bin/bash

while getopts ":a:t:" opt; do
  case "$opt" in
    a) P2AGENT=$OPTARG ;;
    t) TARGET=$OPTARG ;;
  esac
done
shift $(( OPTIND - 1 ))
SOURCE=$*

if [ -z "$P2AGENT" ];
then
  echo "You must define a p2 agent with -a flag";
  exit 2;
fi

if [ -z "$SOURCE" ];
then
  echo "You must define the plugins (and features) to add in the p2 repository";
  exit 1;
fi

if [ -z "$TARGET" ];
then
  TARGET="$SOURCE/../repository"
fi

function buildRepository() {
  # 1 - Cleaning
  echo "Cleaning target directory..."

  if [ -d "$3" ]
  then
	  rm -rf "$3"
  fi

  echo "Target directory clean."

  # 2 - Publishing
  echo "Publishing repository..."

  java -jar $1/plugins/org.eclipse.equinox.launcher_*.jar -application org.eclipse.equinox.p2.publisher.FeaturesAndBundlesPublisher -metadataRepository file:$3 -artifactRepository file:$3 -source $2 -configs gtk.linux.x86_64 -compress -publishArtifacts

  echo "Publication done."

  # 3 - Categorizing
  echo "Checking categorization settings..."

  if [ -e "$2/category.xml" ]
  then
	  echo "Settings found launching categorization application..."

	  java -jar $1/plugins/org.eclipse.equinox.launcher_*.jar -application org.eclipse.equinox.p2.publisher.CategoryPublisher -metadataRepository file:/$3 -categoryDefinition file:/$2/category.xml -categoryQualifier -compress

	  echo "Categorization done."
  else
	  echo "No settings found."
  fi
}

buildRepository $P2AGENT $SOURCE $TARGET


