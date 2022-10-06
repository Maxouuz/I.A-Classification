# Fiche descriptive

**Système:** Belamcanda \
**Cas d'utilisation:** Ajouter une donnée à la main \
**Acteur principal:** Utilisateur \
**Acteur secondaire:** Système \
**Préconditions:** L'Utilisateur à un jeu de donnée de construit. \
**Garantie en cas de succès:** La donnée est ajoutée dans un modèle. \
**Garantie minimale:** Pas de modification des données \

**Scénario nominal:**

1. L'Utilisateur séléctionne la fonction "Ajouter une donnée"
2. Le système affiche un formulaire de création de donnée avec les champs requis(en fonction du jeu de donnée).
3. L'Utilisateur remplis le formulaire dans son intégralité et valide.
4. Le système affiche un récapitulatif de la donnée qui va être créée.
5. L'utilisateur confirme.
6. Le système ajoute la nouvelle donnée au modèle de données et réaffiche le nuage de points.

**Scénario alternatifs:**

**A:** L'utilisateur annule la création de la donnée. \
Si à l'étape 3, L'utilisateur annule la création de la donnée / ferme le formulaire, alors:
* 4(A): Le système ferme le formulaire sans modifier le modèle de donnée.

**B:** L'utilisateur ne remplit pas tout les champs. \
Si à l'étape 3, l'utilisateur ne remplit que partiellement le formulaire et valide, alors:
* 4(B): Le système signale à l'utilisateur que le formulaire n'est pas correctement remplis et retourne à l'étape 2 en concervant les données déjà entrées.