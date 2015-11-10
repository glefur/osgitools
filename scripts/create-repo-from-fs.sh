#!/bin/bash

source p2.sh

function usage() {
  echo "Usage: create-repo-from-fs -a p2agent [OPTION] path"
  echo "Create a P2 repository from a location on the filesystem."
  echo ""
  echo "Arguments:"
  echo "  -a p2agent  : path to a eclipse (or a p2 agent) directory."
  echo "  path        : path to a directory containing the plugins (and optionally the features) to include in the P2 repository. This directory must contain, at least, a 'plugins' sub-directory containing all the bundles of the repository. The directory can also include a sub-directory with the features to include and a 'category.xml' to categorize the contained elements."
  echo ""
  echo "Options:"
  echo "  -t path     : path where the repository must be created."
  echo ""
}

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
  echo "You must define the plugins (and features) to add in the p2 repository";
  exit 2;
fi

if [ -z "$TARGET" ];
then
  TARGET="$SOURCE/../repository"
fi

buildRepository $P2AGENT $SOURCE $TARGET


