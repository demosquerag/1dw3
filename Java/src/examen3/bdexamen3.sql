CREATE DATABASE bdexamen3 DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_spanish_ci;

CREATE TABLE bdexamen3.personas (dni VARCHAR(9) NOT NULL, nombre VARCHAR(30) NOT NULL , apellido VARCHAR(30) NOT NULL ,PRIMARY KEY (dni));
INSERT INTO bdexamen3.personas VALUES ('P1', 'Nombre 1', 'Apellido 1');
INSERT INTO bdexamen3.personas VALUES ('P2', 'Nombre 2', 'Apellido 2');
INSERT INTO bdexamen3.personas VALUES ('P3', 'Nombre 3', 'Apellido 3');
INSERT INTO bdexamen3.personas VALUES ('P4', 'Nombre 4', 'Apellido 4');
