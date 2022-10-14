Nathan HALLEZ \
Rémi VAUTIER \
Alexandre HERSSENS \
Maxence STIEVENARD

# Diagramme de cas d'utilisation

![Diagramme de cas d'utilisation](https://www.plantuml.com/plantuml/svg/TP1DRXin38NtEWMHJLUpYFEJBjCQw05g99kY2rQYRROQAY35e47H-yJdc8lLWaV0k80tmeFmVIJn7gsYLXzpoBIjK0iex_OL4Yl5oaL2m5YBmbFbp8QLN04DF91Khc-mURCwlO_KFYs4Pg7iCi5doZX6b8Jm9m2uKKGZkFfIN8KLN63BSS-aiDuyNpN_QNsz9DT5hAgp4cI2iQJfFLC7pycCPhnjip8Pf28o7SWwkrgopsoEcUq_5aX077VjY-2biDJkd-bVfqFqb-cWiy-oBJfYg-feVd0vkRDwSsapGfnlZjZScRzTyXjaOstdIF5NGlzzVjVTMGLxbDrfyYjcSeLVCtQ_n3x5E1qIAQ13n1mzj_bQVhXLCklrFbnermL-aZVbr5ldFuQ_8JWCGwkxXrKFDptSzd3NmtqF3o4SrNd2zIAlGcWl3D_sd1B9zm4i73V2qC8ZIV8n_mC0)

# Fiches descriptives

## Afficher les données d'un point

**Le système:** Belamcanda \
**Cas d'utilisation:** Afficher les données d'un point \
**Acteur principal:** L'utilisateur \
**Préconditions:** Avoir un nuage de point affiché non vide \
**Garantie en cas de succès:** Les données du point sont visibles

**Scénario nominal:**

1. L'utilisateur clique sur un point du nuage de points 
2. Le système affiche les données de ce point dans une zone dédiée 

**Scénario alternatif:**

**A:** Un survol est effectué plutôt qu'un clic \
Si à l'étape 1, l'utilisateur survole le nuage de points, alors:
* 1(A) : L'utilisateur survole un point du nuage de points 
* 2(A) : Le système  affiche les données de ce point à côté du curseur 
* 3(A) : L'utilisateur arrête de survoler ce point 
* 4(A) : Le système fait disparaître les informations de l'écran 

---

## Ajouter une donnée à la main

**Système:** Belamcanda \
**Cas d'utilisation:** Ajouter une donnée à la main. \
**Acteur principal:** utilisateur. \
**Préconditions:** L'utilisateur à un jeu de donnée de construit. \
**Garantie en cas de succès:** La donnée est ajoutée dans un modèle. \
**Garantie minimale:** Pas de modification des données

**Scénario nominal:**

1. L'utilisateur sélectionne la fonction "Ajouter une donnée"
2. Le système affiche un formulaire de création de données avec les champs requis (en fonction du jeu de données).
3. L'utilisateur remplit le formulaire dans son intégralité et valide.
4. Le système affiche un récapitulatif de la donnée qui va être créée.
5. L'utilisateur confirme.
6. Le système ajoute la nouvelle donnée au modèle de données et actualise le graphique du nuage de points.

**Scénario alternatifs:**

**A:** L'utilisateur annule la création de la donnée. \
Si à l'étape 3, L'utilisateur annule la création de la donnée / ferme le formulaire, alors:
* 4(A): Le système ferme le formulaire sans modifier le modèle de donnée.

**B:** L'utilisateur ne remplit pas tout les champs. \
Si à l'étape 3, l'utilisateur ne remplit que partiellement le formulaire et valide, alors:
* 4(B): Le système signale à l'utilisateur que le formulaire n'est pas correctement remplit et retourne à l'étape 2 en conservant les données déjà entrées.

---

## Changer la valeur de k

**Système:** Belamcanda \
**Cas d'utilisation:** Changer la valeur de k \
**Acteur principal:** L'utilisateur \
**Préconditions:** Données de base fournies par l'utilisateur \
**Garantie en cas de succès:** Relancer la catégorisation avec un nouveau k

**Scénario nominal:**

1. L'utilisateur demande au système d'appliquer l'algorithme
2. Le système associe les données 
3. L'utilisateur choisit de relancer la catégorisation
4. Le système demande à l'utilisateur de lui fournir un nouveau k
5. L'utilisateur lui donne le nouveau k
6. Le système relance l'algorithme

**Scénarios alternatifs:**

* 5(A) : L'utilisateur ajoute une saisie de points manuelles
* 6(A) : Le système relance l'algorithme

---

## Choisir 2 attributs dans la visualisation du nuage de points

**Système:** Belamcanda \
**Cas d'utilisation:** Choisir 2 attributs dans la visualisation du nuage de points \
**Acteur principal:** utilisateur \
**Préconditions:** Avoir des données chargées dans le programme \
**Garantie en cas de succès:** Le nuage de points est visible à l'écran

**Scénario nominal :**

1. L'utilisateur sélectionne deux attributs parmis les attributs et valide
2. Le système met à jour le nuage de points 

**Scénario alternatif :** 

**A:** L'utilisateur déselectionne un attribut du graphique dans un graphique avec un attribut \
Si à l'étape 1, l'utilisateur désélectionne un attribut du graphique
* 2(A): Le système met à jour le nuage de points en retirant l'attribut du graphique

---

## Classifier un jeu de donnée

**Système:** Belamcanda \
**Cas d'utilisation:** Classifier un jeu de donnée \
**Acteur principal:** L'utilisateur \
**Préconditions:** Un modèle a été créé \
**Garantie en cas de succès:** Les données sont ajoutés au nuages de points et classifiés \
**Garantie minimale:** Le jeu de donnée est chargé si et seulement si le fichier CSV est valide

**Scénario nominal:**

1. L'utilisateur sélectionne la fonctionnalité "Classifier des données à partir d'un CSV"
2. Le système affiche un moyen de sélectionner le fichier CSV
3. L'utilisateur sélectionne le fichier CSV
4. Le système vérifie la validité du fichier et charge le jeu de données. Ensuite, il ajoute les données au nuage de points

**Scénario alternatifs:**

**A:** Type de données incohérent \
Si à l'étape 3, le fichier CSV contient des données ne correspondant pas à notre implémentation ou qui ne sont pas cohérente entre elles, alors:
* 4(A): Le système affiche un message d'erreur "Type de données incohérent" à l'utilisateur.
* 5(A): On retourne à l'étape 2 du scénario nominal 

**B:** Structure de données du fichier CSV incompatible \
Si à l'étape 3, le fichier CSV ne correspond pas à notre implémentation, alors:
* 4(B): Le système affiche un message d'erreur "Structure du fichier incorrect" à l'utilisateur.
* 5(B): On retourne à l'étape 2 du scénario nominal

---

## Construire le modèle

**Système:** Belamcanda \
**Cas d'utilisation:** Construire le modèle \
**Acteur principal:** L'utilisateur \
**Préconditions:** Aucune \
**Garantie en cas de succès:** Le modèle est créé \
**Garantie minimale:** Le modèle est créé si et seulement si le fichier CSV est valide

**Scénario nominal:**

1. L'utilisateur sélectionne la fonctionnalité "Construire le modèle"
2. Le système affiche un moyen de sélectionner le fichier CSV
3. L'utilisateur sélectionne le fichier CSV
4. Le système vérifie la validité du fichier et créé le modèle. Ensuite, il affiche le graphique du nuage de points sans choisir les deux attributs à afficher

**Scénario alternatifs:**

**A:** Type de données incohérent \
Si à l'étape 3, le fichier CSV contient des données ne correspondant pas à notre implémentation ou qui ne sont pas cohérente entre elles, alors:
* 4(A): Le système affiche un message d'erreur "Type de données incohérent" à l'utilisateur.
* 5(A): On retourne à l'étape 2 du scénario nominal 

**B:** Structure de données du fichier CSV incompatible \
Si à l'étape 3, le fichier CSV ne correspond pas à notre implémentation, alors:
* 4(B): Le système affiche un message d'erreur "Structure du fichier incorrect" à l'utilisateur.
* 5(B): On retourne à l'étape 2 du scénario nominal
