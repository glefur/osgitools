#!/bin/bash

. p2.sh

HERE=`pwd`

while getopts ":a:" opt; do
  case "$opt" in
    a) P2AGENT=$OPTARG ;;
  esac
done
shift $(( OPTIND - 1 ))
TARGET=$*

if [ -z "$P2AGENT" ];
then
  echo "You must define a p2 agent with -a flag";
  exit 2;
fi

if [ -z "$TARGET" ];
then
  TARGET=$PWD
fi


cd $TARGET
mvn integration-test
buildRepository $P2AGENT $TARGET/target/ $TARGET/repository
mvn clean
cd $HERE
