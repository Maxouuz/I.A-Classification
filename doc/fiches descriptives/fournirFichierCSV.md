# Fiche descriptive

**Système:** Belamcada \
**Cas d'utilisation:** Fournir un fichier CSV \
**Acteur principal:** Utilisateur \
**Préconditions:** Aucune \
**Garantie en cas de succès:** Le fichier CSV est converti en jeu de donnée \
**Garantie minimale:** Le jeu de donnée est chargé si et seulement si le fichier CSV est valide

**Scénario nominal:**

1. L'utilisateur sélectionne la fonctionnalité "Ouvrir un fichier CSV"
2. Le système affiche un moyen de sélectionner le fichier CSV
3. L'utilisateur sélectionne le fichier CSV
4. Le système vérifie la validité du fichier et charge le jeu de données

**Scénario alternatifs:**

**A:** Fichier CSV invalide \
Si le fichier CSV contient des données invalides, alors à l'étape 4:
* 4(A): Le système affiche un message d'erreur à l'utilisateur lui informant que le fichier est invalide
* 5(A): On retourne à l'étape 1 du scénario nominal