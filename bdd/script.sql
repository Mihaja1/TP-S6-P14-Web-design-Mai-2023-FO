CREATE DATABASE iacontent;
CREATE USER webdesign WITH PASSWORD 'webdesign';
ALTER DATABASE iacontent OWNER TO webdesign;

CREATE TABLE Contenu(
    id SERIAL PRIMARY KEY NOT NULL,
    titre VARCHAR(255) NOT NULL,
    contenu TEXT NOT NULL,
    dateAjout TIMESTAMP DEFAULT now() NOT NULL,
    idAdmin int NOT NULL,
    idCategorie int NOT NULL
);

CREATE TABLE Admin(
    id SERIAL PRIMARY KEY NOT NULL,
    nom VARCHAR(20) NOT NULL,
    mail VARCHAR(20) NOT NULL,
    motDePasse VARCHAR(20) NOT NULL
);

CREATE TABLE Categorie(
    id SERIAL PRIMARY KEY NOT NULL,
    designation VARCHAR(50) NOT NULL
);

ALTER TABLE Contenu ADD FOREIGN KEY (idAdmin) REFERENCES Admin(id);
ALTER TABLE Contenu ADD FOREIGN KEY (idCategorie) REFERENCES Categorie(id);

INSERT INTO Categorie(designation) VALUES ('Santé');
INSERT INTO Categorie(designation) VALUES ('Finance');
INSERT INTO Categorie(designation) VALUES ('Commerce électronique');
INSERT INTO Categorie(designation) VALUES ('Automobile');
INSERT INTO Categorie(designation) VALUES ('Marketing');
INSERT INTO Categorie(designation) VALUES ('Education');
INSERT INTO Categorie(designation) VALUES ('Sécurité');

INSERT INTO Admin VALUES (default, 'Admin', 'admin@gmail.com', 'Admin');
