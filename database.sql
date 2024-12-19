Create table utilisateurs (
    id_user int Primary key,
    nom varchar(26),
    prenom varchar(26),
    email varchar(56),
    type ENUM('ETUDIANT','PROFESSEUR')
);
Create table evenement (
    id_event int Primary key,
    nom_event varchar(26),
    description varchar(226),
    id_user int Primary key,
    FOREIGN KEY (id_user) REFERENCES utilisateurs(id_user)
);
Create table salles (
    id_salle int Primary key,
    nom_salle varchar(26),
    capacite int
);
Create table terrain (
    id_terrain int Primary key,x
    nom_terrain varchar(26),
    type varchar(26)
);
Create table reservation (
    id_reservation int Primary key,
    id_user int Primary key,
    id_event int Primary key,
    id_salle int Primary key,
    id_terrain int Primary KEY,
    date_reservation DATE,
    FOREIGN KEY (id_user) REFERENCES utilisateurs(id_user),
    FOREIGN KEY (id_event) REFERENCES evenement(id_event),
    FOREIGN KEY (id_salle) REFERENCES salles(id_salle),
    FOREIGN KEY (id_terrain) REFERENCES terrain(id_terrain)
);