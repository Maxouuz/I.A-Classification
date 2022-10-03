# Fiche descriptive

**Système:** Belamcanda \
**Cas d'utilisation:** Changer la valeur de k \
**Acteur principal:** L'utilisateur \
**Préconditions:** Données de base fournies par l'utilisateur \
**Garantie en cas de succès:** Relancer la catégorisation avec un nouveau k

**Scénario nominal:**

1. L'utilisateur demande au système d'appliquer l'algorythme
2. Le système associe les données 
3. L'utilisateur choisit de relancer la catégorisation
4. Le système demande à l'utilisateur de lui fournir un nouveau k
5. L'utilisateur lui donne le nouveau k
6. Le système relance l'algorithme

**Scénarios alternatifs:**

* 5(A) : L'utilisateur ajoute une saisie de points manuelles
* 6(A) : Le système relance l'algorithme
