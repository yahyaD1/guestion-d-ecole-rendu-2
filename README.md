# Application de Gestion des Événements, Salles,terrains et Réservations

Ce projet consiste en une application Java permettant de gérer des événements, des salles, des terrains et des réservations par un ecole, tout en assurant une interaction avec une base de données relationnelle via JDBC.


## Fonctionnalités

1. Gestion des utilisateurs

   - Ajouter un utilisateur (Étudiant ou Professeur).
   - Afficher tout les utilisateurs.
   - Supprimer un utilisateur.

2. Gestion des événements

   - Ajouter un événement.
   - Afficher les événements existants.
   - Modifier un événement.
   - Supprimer un événement.

3. Gestion des salles et terrains

   - Ajouter des salles ou des terrains.
   - Afficher les salles/terrains existants.
   - Supprimer des salles/terrains.

1. Gestion des réservations

   - Effectuer une réservation.
   - Vérifier la disponibilité d'une salle ou d'un terrain.
   - Afficher, modifier ou supprimer une réservation.

## base de donnee

1. Table des utilisateurs (users)
2. Table des événements (events)
3. Table des salles (rooms)
4. Table des terrains (fields)
5. Table des réservations (reservations)

Vous pouvez trouver l'intégralité du script SQL dans ./database.sql .

## Les etapes d’execution

Lancer le Programme
Commencez par exécuter la classe Main. Vous serez accueilli avec un menu où vous pourrez choisir une option. Voici les options disponibles :

1. Gestion des Utilisateurs
2. Gestion des Événements
3. Gestion des Salles
4. Gestion des Terrains

Après avoir choisi une option, un autre menu apparaîtra avec les actions spécifiques que vous pouvez effectuer en fonction de ce que vous souhaitez faire. Voici ce que vous pouvez faire dans chaque section :

1. Gestion des Utilisateurs
Vous pouvez :

Ajouter un Utilisateur 
Supprimer un Utilisateur 
Afficher Tous les Utilisateurs 

2. Gestion des Événements
Vous pouvez :

Ajouter un Événement
Afficher Tous les Événements
Modifier un Événement 
Supprimer un Événement 

3. Gestion des Salles
Vous pouvez :

Ajouter une Salle 
Afficher Toutes les Salles 
Supprimer une Salle 

4. Gestion des Terrains
Vous pouvez :

Ajouter un Terrain 
Afficher Tous les Terrains
Supprimer un Terrain 
