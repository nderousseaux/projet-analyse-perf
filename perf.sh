#!/bin/bash

echo -e "test\ttaille\tversion\texectime\tmem"

for test in `seq 1 10`
do
  taille=${RANDOM}000

  for version in 1 2 3 4
  do
    (
    res=`(/usr/bin/time -f "%U\t%M" ./recherche $taille $version > /dev/null) 2>&1`

    echo -e "$test\t$taille\tv$version\t$res"
    ) &
  done
  wait 
done
