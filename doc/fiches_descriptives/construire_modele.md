# Fiche descriptive

**Système:** Belamcanda \
**Cas d'utilisation:** Construire le modèle \
**Acteur principal:** Utilisateur \
**Préconditions:** Aucune \
**Garantie en cas de succès:** Construire le modèle \
**Garantie minimale:** Le jeu de donnée est chargé si et seulement si le fichier CSV est valide

**Scénario nominal:**

1. L'utilisateur sélectionne la fonctionnalité "Construire le modèle"
2. Le système affiche un moyen de sélectionner le fichier CSV
3. L'utilisateur sélectionne le fichier CSV
4. Le système vérifie la validité du fichier et charge le jeu de données. Ensuite, il affiche le graphique du nuage de points sans choisir les deux attributs à afficher

**Scénario alternatifs:**

**A:** Fichier CSV invalide \
Si à l'étape 3, le fichier CSV contient des données invalides, alors:
* 4(A): Le système affiche un message d'erreur à l'utilisateur lui informant que le fichier est invalide
* 5(A): On retourne à l'étape 1 du scénario nominal