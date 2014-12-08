/*
\connect postgres

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;


CREATE ROLE easypharma;
ALTER ROLE easypharma WITH SUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN REPLICATION PASSWORD 'md5284506a6bfcbc0b7f22b19f9a99d3135' VALID UNTIL 'infinity';
CREATE ROLE postgres;
ALTER ROLE postgres WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION PASSWORD 'md59f39b02c2d82c084795bf69ffd9e906a';

*/

-- Database: eashpharma

-- DROP DATABASE eashpharma;
/*
CREATE DATABASE eashpharma
  WITH OWNER = easypharma
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'French_France.1252'
       LC_CTYPE = 'French_France.1252'
       CONNECTION LIMIT = -1;
GRANT ALL ON DATABASE eashpharma TO easypharma;
*/

-- Table: assurance

-- DROP TABLE assurance;

CREATE TABLE assurance
(
  id integer NOT NULL,
  accident boolean,
  address character varying(255),
  agence character varying(255),
  aos boolean,
  assure integer,
  card_validity date,
  ean character varying(255),
  name character varying(255),
  npa character varying(255),
  ofas character varying(255),
  phone character varying(255),
  rcc character varying(255),
  type character varying(255),
  validation_date date,
  validation_number integer,
  CONSTRAINT assurance_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE assurance
  OWNER TO easypharma;

  
-- Table: client

-- DROP TABLE client;

CREATE TABLE client
(
  id integer NOT NULL,
  age integer,
  avs integer,
  birth_date date,
  cover_card character varying(255),
  email character varying(255),
  fax character varying(255),
  first_name character varying(255),
  fix character varying(255),
  last_name character varying(255),
  mpi integer,
  phone character varying(255),
  reference character varying(255),
  sexe boolean,
  CONSTRAINT client_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE client
  OWNER TO easypharma;

  
-- Table: assurance_client

-- DROP TABLE assurance_client;

CREATE TABLE assurance_client
(
  id integer NOT NULL,
  date_debut date,
  date_fin date,
  client_id integer,
  assurance_id integer,
  CONSTRAINT assurance_client_pkey PRIMARY KEY (id ),
  CONSTRAINT fk_assurance_client_assurance_id FOREIGN KEY (assurance_id)
      REFERENCES assurance (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_assurance_client_client_id FOREIGN KEY (client_id)
      REFERENCES client (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE assurance_client
  OWNER TO easypharma;

  
-- Table: medecin

-- DROP TABLE medecin;

CREATE TABLE medecin
(
  id integer NOT NULL,
  fax character varying(255),
  first_name character varying(255),
  last_name character varying(255),
  nc character varying(255),
  nrcc character varying(255),
  phone character varying(255),
  reference character varying(255),
  speciality character varying(255),
  CONSTRAINT medecin_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE medecin
  OWNER TO easypharma;

  
-- Table: operator

-- DROP TABLE operator;

CREATE TABLE operator
(
  id integer NOT NULL,
  firstname character varying(255),
  lastname character varying(255),
  CONSTRAINT operator_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE operator
  OWNER TO easypharma;


-- Table: posologie

-- DROP TABLE posologie;

CREATE TABLE posologie
(
  id integer NOT NULL,
  action character varying(255),
  applications character varying(255),
  avertissement character varying(255),
  codex character varying(255),
  dosage character varying(255),
  forme character varying(255),
  preparation character varying(255),
  recommendation character varying(255),
  unite character varying(255),
  CONSTRAINT posologie_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE posologie
  OWNER TO easypharma;

  
-- Table: vente

-- DROP TABLE vente;

CREATE TABLE vente
(
  id integer NOT NULL,
  paiement_assurance double precision,
  paiement_bvr double precision,
  paiement_carte double precision,
  paiement_cheque double precision,
  status character varying(255),
  type_vente character varying(255),
  client_id integer,
  medecin_id integer,
  operator_id integer,
  CONSTRAINT vente_pkey PRIMARY KEY (id ),
  CONSTRAINT fk_vente_client_id FOREIGN KEY (client_id)
      REFERENCES client (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_vente_medecin_id FOREIGN KEY (medecin_id)
      REFERENCES medecin (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_vente_operator_id FOREIGN KEY (operator_id)
      REFERENCES operator (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE vente
  OWNER TO easypharma;

  
  
-- Table: product

-- DROP TABLE product;

CREATE TABLE product
(
  id integer NOT NULL,
  designation character varying(255),
  pu double precision,
  quantity integer,
  reference character varying(255),
  thresholdalert integer,
  posologie_id integer,
  CONSTRAINT product_pkey PRIMARY KEY (id ),
  CONSTRAINT fk_product_posologie_id FOREIGN KEY (posologie_id)
      REFERENCES posologie (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE product
  OWNER TO easypharma;

  

-- Table: posologie_specifique

-- DROP TABLE posologie_specifique;

CREATE TABLE posologie_specifique
(
  id integer NOT NULL,
  avertissement character varying(255),
  condition character varying(255),
  dureetotal integer,
  etiquette character varying(255),
  heures integer,
  matin boolean,
  midi boolean,
  nombre_jours integer,
  nuit boolean,
  quantity integer,
  repas character varying(255),
  rythme integer,
  soir boolean,
  CONSTRAINT posologie_specifique_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE posologie_specifique
  OWNER TO easypharma;

  
  
-- Table: vente_produit

-- DROP TABLE vente_produit;

CREATE TABLE vente_produit
(
  id integer NOT NULL,
  quantity_vendu integer,
  remise double precision,
  type_paiement character varying(255),
  product_id integer,
  vente_id integer,
  specifique_id integer,
  CONSTRAINT vente_produit_pkey PRIMARY KEY (id ),
  CONSTRAINT fk_vente_produit_product_id FOREIGN KEY (product_id)
      REFERENCES product (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_vente_produit_specifique_id FOREIGN KEY (specifique_id)
      REFERENCES posologie_specifique (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_vente_produit_vente_id FOREIGN KEY (vente_id)
      REFERENCES vente (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE vente_produit
  OWNER TO easypharma;

  
-- Table: sequence

-- DROP TABLE sequence;

CREATE TABLE sequence
(
  seq_name character varying(50) NOT NULL,
  seq_count numeric(38,0),
  CONSTRAINT sequence_pkey PRIMARY KEY (seq_name )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sequence
  OWNER TO easypharma;



-- Operator Table
INSERT INTO operator(id, firstname, lastname) VALUES (1, 'MEHDI', 'HAYANI');
INSERT INTO operator(id, firstname, lastname) VALUES (2, 'MOHAMED', 'EL JAI');

-- Product Table
INSERT INTO product(
            id, designation, pu, quantity, reference, thresholdalert)
    VALUES (1, 'DOLIPRANE', 12, 12, '42HD0234YD2', 2);

INSERT INTO product(
            id, designation, pu, quantity, reference, thresholdalert)
    VALUES (2, 'CURACNE', 40, 10, '32D3423', 4);
	
-- Client Table	
INSERT INTO client(
            id, age, avs, birth_date, cover_card, email, fax, first_name, 
            fix, last_name, mpi, phone, reference)
    VALUES (1, 27, 3398723, '1987-12-13', 'FG328D230', 'omar@gmail.com', '+33643233298', 'Omar', 
            '+33598544746', 'Omari', 742244, '+33598544746', 'CD12345');

INSERT INTO client(
            id, age, avs, birth_date, cover_card, email, fax, first_name, 
            fix, last_name, mpi, phone, reference)
    VALUES (2, 35, 3398723, '1980-06-06', '47FF9584', 'amine@gmail.com', '+33643233298', 'Amine', 
            '+33598544746', 'Alaoui', 324123, '+33598544746', 'CD54321');
			
-- Medecin Table
INSERT INTO medecin(
            id, fax, first_name, last_name, nc, nrcc, phone, reference, speciality)
    VALUES (1, '+33598544746', 'Jean-Jack', 'Duran', '32GR2003', '34G2DE2', '+33598544746', 'CD11111', 'PEDIATRIE');

INSERT INTO medecin(
            id, fax, first_name, last_name, nc, nrcc, phone, reference, speciality)
    VALUES (2, '+33598544746', 'Olivier', 'Marcel', '32GR2003', '34G2DE2', '+33598544746', 'CD22222', 'PEDIATRIE');

-- Assurance Table
INSERT INTO assurance(
            id, address, agence, assure, card_validity, ean, 
            name, npa, ofas, phone, rcc, type, validation_date, validation_number)
    VALUES (1, 'Address 1', 'AXA', 329632, '2016-12-13', '4234GD32', 
            'AXA', 'NDFZH23', 'FH2349D3', '+33598544746', 'DF2323', 'ACCIDENT', '2010-12-13', 3327);

INSERT INTO assurance(
            id, address, agence, assure, card_validity, ean, 
            name, npa, ofas, phone, rcc, type, validation_date, validation_number)
    VALUES (2, 'Address 2', 'MUTUEL', 329632, '2018-10-10', '4234GD32', 
            'MUTUEL', 'NDFZH23', 'FH2349D3', '+33598544746', 'DF2323', 'OBLIGATOIRE', '2012-10-10', '3327');

INSERT INTO assurance(
            id, address, agence, assure, card_validity, ean, 
            name, npa, ofas, phone, rcc, type, validation_date, validation_number)
    VALUES (3, 'Address 3', 'WAFA', 329632, '2017-04-04', '4234GD32', 
            'WAFA', 'NDFZH23', 'FH2349D3', '+33598544746', 'DF2323', 'COMPLEMENTAIRE', '2014-04-04', 3327);
