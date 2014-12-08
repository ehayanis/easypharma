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
