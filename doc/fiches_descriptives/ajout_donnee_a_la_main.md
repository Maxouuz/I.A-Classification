# Fiche descriptive

**Système:** Belamcanda \
**Cas d'utilisation:** Ajouter une donnée à la main \
**Acteur principal:** Utilisateur \
**Acteur secondaire:** Système \
**Préconditions:** Le modèle d'un jeu de données est chargé \
**Garantie en cas de succès:** La donnée est ajoutée dans le modèle \
**Garantie minimale:** Pas de modification des données 

**Scénario nominal:**

1. L'Utilisateur séléctionne la fonction "Ajouter une donnée"
2. Le système affiche un formulaire de création de donnée avec les champs requis(en fonction du jeu de donnée).
3. L'Utilisateur remplit le formulaire dans son intégralité et valide.
4. Le système affiche un récapitulatif de la donnée qui va être créée.
5. L'utilisateur confirme.
6. Le système ajoute la nouvelle donnée au modèle de données et réaffiche le nuage de points.

**Scénario alternatifs:**

**A:** Annulation de la création de la donnée. \
* 3(A) L'utilisateur annule la création de la donnée ou ferme le formulaire
* 4(A): Le système ferme le formulaire sans modifier le modèle de donnée.

**B:** L'utilisateur ne remplit pas tout les champs. \
* 3(B) : L'utilisateur oublie de remplir des champs indispensables et valide
* 4(B): Le système signale à l'utilisateur que le formulaire n'est pas correctement remplit et retour à l'étape 2 en conservant les données déjà entrées.