#!/bin/bash

. p2.sh

function usage() {
  echo "Usage: create-repo-from-maven -a p2agent [OPTION] path"
  echo "Create a P2 repository from a list of maven dependencies."
  echo ""
  echo "Arguments:"
  echo "  -a p2agent  : path to an eclipse (or a p2 agent) directory."
  echo "  path        : path to a directory containing the master pom.xml. This pom.xml file must have the artifact 'fr.smartcontext:dependencies-downloader' as parent (see https://github.com/glefur/osgitools for details) and it must contain a list of dependencies that will be integrated in the target repository."
  echo ""
  echo "Options:"
  echo "  -t path     : path where the repository must be created."
  echo "  -h          : displays this help."
  echo ""
}

HERE=`pwd`

while getopts ":ha:t:" opt; do
  case "$opt" in
    h)
      usage
      exit 1
    ;;
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
  SOURCE=$PWD
fi

cd $SOURCE
mvn integration-test
buildRepository $P2AGENT $SOURCE/target/ $SOURCE/repository
mvn clean

if [ -v TARGET ];
then
  mv $SOURCE/repository $TARGET
fi
cd $HERE
