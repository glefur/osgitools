#!/bin/bash

source p2.sh

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

buildRepository $P2AGENT $SOURCE $TARGET


