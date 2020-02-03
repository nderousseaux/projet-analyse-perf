/**
 Recherche d'un entier alétoire dans un tableau de valeurs aléatoires
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_VALEUR 15

int *generer_tableau(long long unsigned int n)
{
	int *tableau = malloc(n*sizeof(int));
	long long unsigned int i;

	for (i=0; i<n; i++) {
		tableau[i] = rand()%MAX_VALEUR;
	}

	return tableau;
}

void afficher_tableau(int *tableau, long long unsigned int n)
{
	long long unsigned int i;
	for (i=0; i<n; i++) {
		printf("%d ",tableau[i]);
	}
	printf("\n");

}

long long unsigned int rechercher(int *tableau, long long unsigned int n, int valeur)
{
	long long unsigned int i;
	long long unsigned int trouve = -1;

	for (i=0; i<n; i++) {
		if (tableau[i] == valeur) {
			trouve=i;
		}
	}

	return trouve;
}

int main(int argc, char *argv[])
{
	int *tableau;
	int taille, valeur;
	char trouve;

	if (argc<2) {
		printf("%s: opérande manquant\n",argv[0]);
		printf("Recherche une valeur aléatoire dans un tableau d'entier aléatoire de taille n\n");
		printf("Affiche le tableau et renvoie 1 si la valeur est trouvée, 0 sinon\n");
		exit(1);
		printf("Usage: %s taille [graine]\n",argv[0]);
	}

	unsigned int graine;
	if (argc>2) {
		graine = atoi(argv[2]);
	} else {
		graine = time(NULL);
	}

	srand(graine);

	taille = strtoull(argv[1], (char **) NULL, 10);
	valeur = rand()%MAX_VALEUR;
	tableau = generer_tableau(taille);

	afficher_tableau(tableau,taille);
	trouve = rechercher(tableau, taille, valeur);

  printf("Valeur %d trouvée: %u\n",valeur, trouve);
}
