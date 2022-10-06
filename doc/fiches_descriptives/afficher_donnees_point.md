# Fiche descriptive

**Le système:** Belamcanda \
**Cas d'utilisation:** Afficher les données d'un point \
**Acteur principal:** Utilisateur \
**Préconditions:** Avoir un nuage de point affiché non vide \
**Garantie en cas de succès:** Les données du point sont visibles \

**Scénario nominal:**

1. L'utilisateur clique sur un point du nuage de points \
2. Le système affiche les données de ce point dans une zone dédiée \

**Scénario alternatif:**

**A:** Un survol est effectué plutôt qu'un clic \
Si à l'étape 1, l'utilisateur survole le nuage de points, alors:
* 1(A) : L'utilisateur survole un point du nuage de points \
* 2(A) : Le système  affiche les données de ce point à côté du curseur \
* 3(A) : L'utilisateur arrête de survoler ce point \
* 4(A) : Le système  fait disparaître les informations de l'écran \