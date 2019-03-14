/**
 Recherche d'un entier alétoire dans un tableau de valeurs aléatoires
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_VALEUR 150000

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

char rechercherV1(int *tableau, long long unsigned int n, int valeur)
{
	long long unsigned int i;
	char trouve = 0;

	for (i=0; i<n; i++) {
		if (tableau[i] == valeur) {
			trouve=1;
		}
	}

	return trouve;
}

char rechercherV2(int *tableau, long long unsigned int n, int valeur)
{
	long long unsigned int i;
	char trouve = 0;

	for (i=0; i<n; i++) {
		if (tableau[i] == valeur) {
			return 1;
		}
	}

	return 0;
}


int main(int argc, char *argv[])
{
	int *tableau;
	int taille, valeur;
	char trouve;
	int version;

	if (argc<2) {
		printf("%s: opérande manquant\n",argv[0]);
		printf("Recherche une valeur aléatoire dans un tableau d'entier aléatoire de taille n\n");
		printf("Affiche le tableau et renvoie 1 si la valeur est trouvée, 0 sinon\n");
		exit(1);
		printf("Usage: %s taille version [graine]\n",argv[0]);
	}

	unsigned int graine;
	if (argc>3) {
		graine = atoi(argv[3]);
	} else {
		graine = time(NULL);
	}

	srand(graine);

	taille = strtoull(argv[1], (char **) NULL, 10);
	version = strtoull(argv[2], (char **) NULL, 10);
	valeur = rand()%MAX_VALEUR;
	tableau = generer_tableau(taille);

	switch(version) {
	case 1:
		afficher_tableau(tableau,taille);
		trouve = rechercherV1(tableau, taille, valeur);
		break;
	case 2:
		trouve = rechercherV1(tableau, taille, valeur);
		break;
	case 3:
		afficher_tableau(tableau,taille);
		trouve = rechercherV2(tableau, taille, valeur);
		break;
	case 4:
		trouve = rechercherV2(tableau, taille, valeur);
		break;
	}

  printf("Valeur %d trouve: %d\n",valeur, trouve);
}
