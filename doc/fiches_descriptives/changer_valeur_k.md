# Fiche descriptive

**Système:** Belamcanda \
**Cas d'utilisation:** Changer la valeur de k \
**Acteur principal:** L'utilisateur \
**Préconditions:** Le modèle est chargé et des données doivent être classifiés \
**Garantie en cas de succès:** Nouvelle classfication des données à l'échelle k

**Scénario nominal:**
  
1. L'utilisateur choisit de faire une nouvelle catégorisation
2. Le système lui demande la nouvelle valeur de k appliquée à l'algorithme
3. L'utilisateur lui donne le nouveau k
4. Le système reclassifie les données avec le nouveau k et met à jour le nuage de points.

**Scénarios alternatifs:**
Si la valeur k est en dehors des limites fixées


* 3(A) L'utilisateur fournit au système une valeur de k inférieure ou supérieure au nombre d'élements
* 4(A) Le système lui refuse l'entrée et retour à l'étape 2. du scénario .

