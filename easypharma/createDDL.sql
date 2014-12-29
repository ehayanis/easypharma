CREATE TABLE ASSURANCE (ID INTEGER NOT NULL, ACCIDENT BOOLEAN, ADDRESS VARCHAR(255), AGENCE VARCHAR(255), AOS BOOLEAN, ASSURE INTEGER, card_validity DATE, EAN VARCHAR(255), NAME VARCHAR(255), NPA VARCHAR(255), OFAS VARCHAR(255), PHONE VARCHAR(255), RCC VARCHAR(255), validation_date DATE, validation_number INTEGER, PRIMARY KEY (ID))
CREATE TABLE CLIENT (ID INTEGER NOT NULL, addr_facturation VARCHAR(255), addr_livraison VARCHAR(255), addr_principal VARCHAR(255), AGE INTEGER, AVS INTEGER, birth_date DATE, EMAIL VARCHAR(255), FAX VARCHAR(255), first_name VARCHAR(255), FIX VARCHAR(255), last_name VARCHAR(255), MPI INTEGER, PHONE VARCHAR(255), REFERENCE VARCHAR(255), SEXE BOOLEAN, PRIMARY KEY (ID))
CREATE TABLE MEDECIN (ID INTEGER NOT NULL, ADDRESS VARCHAR(255), EMAIL VARCHAR(255), FAX VARCHAR(255), first_name VARCHAR(255), last_name VARCHAR(255), NC VARCHAR(255), NRCC VARCHAR(255), PHONE VARCHAR(255), REFERENCE VARCHAR(255), SPECIALITY VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PRODUCT (ID INTEGER NOT NULL, DESIGNATION VARCHAR(255), PU FLOAT, QUANTITY INTEGER, REFERENCE VARCHAR(255), THRESHOLDALERT INTEGER, POSOLOGIE_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE OPERATOR (ID INTEGER NOT NULL, FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE VENTE (ID INTEGER NOT NULL, date_creation DATE, paiement_assurance FLOAT, paiement_bvr FLOAT, paiement_carte FLOAT, paiement_cheque FLOAT, STATUS VARCHAR(255), type_vente VARCHAR(255), CLIENT_ID INTEGER, MEDECIN_ID INTEGER, OPERATOR_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE assurance_client (ID INTEGER NOT NULL, cover_card VARCHAR(255), date_debut DATE, date_fin DATE, TYPE VARCHAR(255), CLIENT_ID INTEGER, ASSURANCE_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE vente_produit (ID INTEGER NOT NULL, quantity_vendu INTEGER, REMISE FLOAT, type_paiement VARCHAR(255), PRODUCT_ID INTEGER, VENTE_ID INTEGER, SPECIFIQUE_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE POSOLOGIE (ID INTEGER NOT NULL, ACTION VARCHAR(255), APPLICATIONS VARCHAR(255), AVERTISSEMENT VARCHAR(255), CODEX VARCHAR(255), contre_indication VARCHAR(255), DOSAGE VARCHAR(255), FORME VARCHAR(255), PREPARATION VARCHAR(255), RECOMMENDATION VARCHAR(255), UNITE VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE posologie_specifique (ID INTEGER NOT NULL, AVERTISSEMENT VARCHAR(255), CONDITION VARCHAR(255), DUREETOTAL INTEGER, ETIQUETTE VARCHAR(255), HEURES INTEGER, MATIN BOOLEAN, MIDI BOOLEAN, nombre_jours INTEGER, NUIT BOOLEAN, QUANTITY INTEGER, REPAS VARCHAR(255), RYTHME INTEGER, SOIR BOOLEAN, PRIMARY KEY (ID))
ALTER TABLE PRODUCT ADD CONSTRAINT FK_PRODUCT_POSOLOGIE_ID FOREIGN KEY (POSOLOGIE_ID) REFERENCES POSOLOGIE (ID)
ALTER TABLE VENTE ADD CONSTRAINT FK_VENTE_CLIENT_ID FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT (ID)
ALTER TABLE VENTE ADD CONSTRAINT FK_VENTE_OPERATOR_ID FOREIGN KEY (OPERATOR_ID) REFERENCES OPERATOR (ID)
ALTER TABLE VENTE ADD CONSTRAINT FK_VENTE_MEDECIN_ID FOREIGN KEY (MEDECIN_ID) REFERENCES MEDECIN (ID)
ALTER TABLE assurance_client ADD CONSTRAINT FK_assurance_client_CLIENT_ID FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT (ID)
ALTER TABLE assurance_client ADD CONSTRAINT FK_assurance_client_ASSURANCE_ID FOREIGN KEY (ASSURANCE_ID) REFERENCES ASSURANCE (ID)
ALTER TABLE vente_produit ADD CONSTRAINT FK_vente_produit_VENTE_ID FOREIGN KEY (VENTE_ID) REFERENCES VENTE (ID)
ALTER TABLE vente_produit ADD CONSTRAINT FK_vente_produit_PRODUCT_ID FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID)
ALTER TABLE vente_produit ADD CONSTRAINT FK_vente_produit_SPECIFIQUE_ID FOREIGN KEY (SPECIFIQUE_ID) REFERENCES posologie_specifique (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)