#!/bin/bash

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

