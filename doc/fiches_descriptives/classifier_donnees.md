# Fiche descriptive

**Système:** Belamcanda \
**Cas d'utilisation:** Classifier un jeu de donnée \
**Acteur principal:** Utilisateur \
**Préconditions:** Un modèle a été crée \
**Garantie en cas de succès:** Les données sont ajoutés au nuages de points et classifiés \
**Garantie minimale:** Le jeu de donnée est chargé si et seulement si le fichier CSV est valide

**Scénario nominal:**

1. L'utilisateur sélectionne la fonctionnalité "Classifier des données à partir d'un CSV"
2. Le système affiche un moyen de sélectionner le fichier CSV
3. L'utilisateur sélectionne le fichier CSV
4. Le système vérifie la validité du fichier et charge le jeu de données. Ensuite, il ajoute les données au nuage de points

**Scénario alternatifs:**

**A:** Fichier CSV invalide \
Si à l'étape 3, le fichier CSV contient des données invalides, alors:
* 4(A): Le système affiche un message d'erreur à l'utilisateur lui informant que le fichier est invalide
* 5(A): On retourne à l'étape 1 du scénario nominal