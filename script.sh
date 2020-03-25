    #!/bin/bash

    cd src
    javac *.java



    test() {

        res=`(/usr/bin/time -f"%U\t%M" java testList $1 $2 $3> /dev/null) 2>&1`
        echo -e "$1\t$2\t$3\t$res"
        echo -e "$1\t$2\t$3\t$res" >> ../graphs/results
    }

    rm ../graphs/results
    touch ../graphs/results

    randomMax=10000

    echo -e "struct\toperation\tsize\ttmp\tmem" >> ../graphs/results

    for taille in 10 200 400 800 1000 2000 4000 8000 20000 40000 80000 200000
    do
        for struct in ArrayList Array HashMap
        do
            for operation in getFirst getRandom getLast remove contains
            do
                for itest in `seq 1 10`
                do
                    test $struct $operation $taille
                done
            done
        done

    done