# P4a : Analyse de performances de différentes structures

[Grille d'évaluation P4a](https://docs.google.com/spreadsheets/d/1x72glVEQHPx56Wr8G0RNQgfQXGX6xCsjms_6b7J6si0/edit?usp=sharing
)

## Problème

Description du Problème.

Nous analysons dans cette étude les performances des différents type de structure en JAVA. Pour ce faire, nous allons tester les structures à travers plusieurs opération, et comparer leur temp d'execution et leur alocation mémoire. 
Nous allons tester les trois structures suivantes : "ArrayList", "HashMap" et "Array". 
Nous allons confronter ces structures à travers 5 opérations : "contains", "remove", "getFirst", "getRandom" et "getLast".

L'objectif de cette étude est d'aider à la décision lorsqu'il s'agira de choisir une structure de données. 
Quelle est la structure la plus performante dans tel ou tel contexte ?


## Dispositif expérimental

### Application

[code source de l'application](https://git.unistra.fr/nderousseaux/P4a/-/tree/master/src)
```
Usage : java testList structure operation taille

structure : Type de la structure, peut prendre les valeurs suivantes
    ArrayList
    HashMap
    Array

operation : Type d'opération testé sur la structure, peut prendre les valeurs suivantes :
    contains : Teste si une valeur apparait dans la structure. La valeur est définie aléatoirement.
    remove : Supprime toutes les occurences d'une certaine valeur dans la structure. La valeur est définie aléatoirement.
    getFirst : Accède au premier élément de la structure.
    getRandom : Accède a l'élément d'index n de la structure. n est définit aléatoirement.
    getLast : Accède au dernier élément de la structure.


taille : Taille de la structure.
```

### Environnement de test

Description de la plateforme de test
```
cpu family      : 23
model name      : AMD Ryzen 5 2600 Six-Core Processor @ 3.40GHz
cpu MHz         : 3400.000
cache size      : 512 KB
cpu cores       : 6
```

### Description de la démarche systématique

Description de la démarche systématique et de l'espace d'exploration pour chaque paramètres.

```
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

for taille in $(seq 10 20000 200000)
do
    for struct in ArrayList Array HashMap
    do
        for operation in getFirst getRandom getLast remove contains
        do
            for itest in `seq 1 25`
            do
                test $struct $operation $taille
            done
        done
    done

done
```

Pour produire les données, il suffit de lancer le script.
Celui çi va lancer le programme "testList" pour chaque type de structure, pour chaque opération et pour différentes tailles, allant de 10 éléments, à 180 000 éléments.
Il va enregistrer le temps d'execution et l'allocation mesurés dans le fichier nommé "result" du dossier "graphs".
Il va faire ces opérations 25 fois, afin de pouvoir faire une moyenne.
On va devoir lancer le script R à la main pour générer les graphiques.

## Résultats préalables

### Temps d'exécution

![plot](prealable.png)

### Consommation mémoire

![plot](prealable-mem.png)

### Analyse des résultats préalables

En observant les résulats on constate des différences de performances d'une structure à l'autre.

Du point de vue du temps processeur, la structure HashMap consomme beaucoup plus de temps processeur que les autres. On retrouve ceci sur toutes les opérations.
ArrayList est souvent plus rapide que la structure Array, mais de peu. L'écart semble s'amplifier à mesure que le nombre d'élément augmente.

D'un point de vue de l'espace mémoire aloué, la aussi la structure HashMap est très gourmande. 
ArrayList et Array sont toutes les deux à peu prés à égalité.


### Discussion des résultats préalables

Ces résultats préalables sont facilement explicables. En effet, HashMap demande des opérations suplémentaire car elle prend en compte un couple clé/valeur, ce que ne font pas les structures Array et ArrayList.

## Etude approfondie

### Hypothèse

Nous pouvons voir dans nos résultats préalable que l'évolution de hashMap semble avoir un profil logarithmique en temp processeur.

Contrairement à ArrayList, qui semble avoir un augmentation linéaire.

Notre hypothèse sera la suivante : A partir d'une certaine taille, la structure HashMap devient plus rapide que ArrayList sur l'opération getRandom. 

### Protocole expérimental de vérification de l'hypothèse

Pour cela, nous allons modifier le script pour augmenter les tailles et tester uniquement ArrayList et HashMap sur l'opération getRandom.

```
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

for taille in $(seq 800000 8000000)
do
    for struct in ArrayList HashMap
    do
        for operation in getRandom
        do
            for itest in `seq 1 25`
            do
                test $struct $operation $taille
            done
        done
    done

done

```

### Résultats expérimentaux

### Analyse des résultats expérimentaux

Nous pouvons voir qu'en effet, arrayList à une croissance linéaire, contrairement à HashMap dont la croissance du temps de calcul ralentit à mesure que le nombre d'éléments augmente.

### Discussion des résultats expérimentaux



## Conclusion et travaux futurs
