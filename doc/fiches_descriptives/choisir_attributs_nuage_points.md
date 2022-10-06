# Fiche descriptive

**Système:** Belamcanda \
**Cas d'utilisation:** Choisir 2 attributs dans la visualisation du nuage de points \
**Acteur principal:** Utilisateur \
**Préconditions:** Avoir des données chargées dans le programme \
**Garantie en cas de succès:** Le nuage de points est visible à l'écran

**Scénario nominal :**

1. L'utilisateur sélectionne un attribut dans la liste des attributs
2. Le système met à jour le nuage de points en ajoutant l'attribut au graphique
3. L'utilisateur sélectionne un second attribut dans la liste des attributs
4. Le système remet à jour le nuage de points. Aussi, il bloque la fonctionnalité de choisir un troisième attribut

**Scénario alternatif :** 

**A:** L'utilisateur désectionne un attribut du graphique dans un graphique avec un attribut
Si à l'étape 1, l'utilisateur désélectionne un attribut du graphique \
* 2(A): Le système met à jour le nuage de points en retirant l'attribut du graphique

**B:** L'utilisateur désectionne un attribut du graphique dans un graphique avec deux attributs
Si à l'étape 3, l'utilisateur désélectionne un attribut du graphique \
* 4(B): Le système remet à jour le nuage de points. Il redonne la fonctionnalité de choisir un deuxième attribut