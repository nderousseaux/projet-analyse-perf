#!/bin/bash

cd src
javac *.java



test() {

    res=`(/usr/bin/time -f"%U\t%M" java testList $1 $2 $3> /dev/null) 2>&1`
    echo -e "$1\t$2\t$3\t$res"
    echo -e "$1\t$2\t$3\t$res" >> ../graphs/results2
}

rm ../graphs/results2
touch ../graphs/results2

randomMax=10000

echo -e "struct\toperation\tsize\ttmp\tmem" >> ../graphs/results2

for taille in 200000 400000 600000 800000 1000000 2000000 20000000
do
    for struct in ArrayList Array
    do
        for operation in getRandom
        do
            for itest in `seq 1 10`
            do
                test $struct $operation $taille
            done
        done
    done

done