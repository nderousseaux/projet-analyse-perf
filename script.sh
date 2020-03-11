#!/bin/bash

cd src
javac *.java



test() {

    echo ""
    echo "Test $3 de $2 avec $1 éléments"
    res=`(/usr/bin/time -f"%U\t%M" java testList $1 $2 $3 > /dev/null) 2>&1`
    echo -e "$1\t$res" >>../graphs/results
}

rm ../graphs/results
touch ../graphs/results



for liste in ArrayList LinkedList CopyOnWriteList
do
    echo "----------------------Test de $liste----------------------" >> ../graphs/results
    for operation in get insert remove
    do 
        echo "Test de $operation sur $liste :" >> ../graphs/results
        for taille in 10 100 1000 10000 100000 100000
        do
            test $taille $liste $operation
        done
        echo -e "\n" >> ../graphs/results
    done
    echo -e "\n" >> ../graphs/results
done

# R
# perf <- red.table("../graphs/results")
