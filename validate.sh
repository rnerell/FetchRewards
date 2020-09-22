#!/bin/bash
if [ ! -n "$1" ]
then
  echo "Usage: `basename $0` <input string>"
  exit
fi

curl -d "input=$1" http://localhost:8090/pyramid/validate 
