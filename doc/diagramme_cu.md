```plantuml
left to right direction

actor Utilisateur as u
actor Système as s

package Belamcada {
  usecase "Fournir un fichier CSV" as UC1
  usecase "Visualiser les données en nuages de points" as UC2
  usecase "Sélectionner un nuage de points" as UC3
  usecase "Visualiser la classification" as UC4
  usecase "Saisir de nouveaux points" as UC5
  usecase "Changer la valeur k" as UC6
  usecase "Accéder au calcul de robustesse" as UC7
  usecase "Classifier un jeu de donnée" as UC8
}

u --> UC1
u --> UC2
u --> UC3
u --> UC4
u --> UC5
u --> UC6
u --> UC7

s --> UC8
```