DROP TABLE IF EXISTS Pays;
DROP TABLE IF EXISTS Devise;

DROP TABLE IF EXISTS ClientCompte;
DROP TABLE IF EXISTS Operation;
DROP TABLE IF EXISTS Compte;
DROP TABLE IF EXISTS Client;
DROP TABLE IF EXISTS Adresse;



CREATE TABLE Devise(
	codeDevise VARCHAR(8),
	monnaie VARCHAR(64),
	dChange double,
	PRIMARY KEY(codeDevise));	 

CREATE TABLE Pays(
	codePays VARCHAR(8),
	capitale VARCHAR(64),
	nomPays VARCHAR(64),
	ref_devise VARCHAR(64),
	PRIMARY KEY(codePays));	 


ALTER TABLE Pays ADD CONSTRAINT Pays_avec_devise_valide 
FOREIGN KEY (ref_devise) REFERENCES Devise(codeDevise);

INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('EUR',1.11570,'euro');
INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('JPY',0.00961816 ,'yen');
INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('USD',1.0,'dollar');
INSERT INTO Devise (codeDevise,dChange,monnaie) VALUES ('GBP',1.32940,'livre');

INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
               VALUES ('Paris','fr','France','EUR');
 INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
               VALUES ('Berlin','de','Allemagne','EUR');
 INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
               VALUES ('Rome','it','Italie','EUR');      
 INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
               VALUES ('Londres','uk','Royaumes unis','GBP');           
 INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
               VALUES ('Washingtown','us','USA','USD');     
 INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
               VALUES ('Pekin','china','Chine','USD');         
 INSERT INTO Pays (capitale,codePays,nomPays,ref_devise)
               VALUES ('Tokyo','JP','Japon','JPY');                 

SELECT * FROM Devise;
SELECT * FROM Pays;

CREATE TABLE Client(
	nom VARCHAR(64),
	prenom VARCHAR(64),
	numClient integer GENERATED BY DEFAULT AS IDENTITY 
                                         (START WITH 1, INCREMENT BY 1) NOT NULL,
	dateNaissance DATE,
	telephone VARCHAR(16),
	email VARCHAR(64),
	ref_adressePrincipale integer,
	password VARCHAR(64),
	PRIMARY KEY(numClient));	 

CREATE TABLE Adresse(
	codePostal VARCHAR(64),
	ville VARCHAR(64),
	rue VARCHAR(64),
	idAdr integer GENERATED BY DEFAULT AS IDENTITY 
                                         (START WITH 1, INCREMENT BY 1) NOT NULL,
	
	PRIMARY KEY(idAdr));	 


CREATE TABLE Compte(
	label VARCHAR(64),
	numCpt integer GENERATED BY DEFAULT AS IDENTITY 
                                         (START WITH 1, INCREMENT BY 1) NOT NULL,
	solde double,
	typeCompte VARCHAR(12) default 'courant',
	tauxInteretPct double,
	apportMensuel double,
	PRIMARY KEY(numCpt));	 

CREATE TABLE Operation(
	label VARCHAR(64),
	montant double,
	numOp integer GENERATED BY DEFAULT AS IDENTITY 
                                         (START WITH 1, INCREMENT BY 1) NOT NULL,
	dateOp DATE,
	ref_compte integer,
	PRIMARY KEY(numOp));	 
	
CREATE TABLE ClientCompte(
	numCli integer,
	numCpt integer,
	PRIMARY KEY(numCli,numCpt));


ALTER TABLE Client ADD CONSTRAINT Client_avec_adressePrincipale_valide 
FOREIGN KEY (ref_adressePrincipale) REFERENCES Adresse(idAdr);



ALTER TABLE ClientCompte ADD CONSTRAINT ClientCompte_avec_client_valide 
FOREIGN KEY (numCli) REFERENCES Client(numClient);
ALTER TABLE ClientCompte ADD CONSTRAINT ClientCompte_avec_compte_valide 
FOREIGN KEY (numCpt) REFERENCES Compte(numCpt);


ALTER TABLE Operation ADD CONSTRAINT Operation_avec_compte_valide 
FOREIGN KEY (ref_compte) REFERENCES Compte(numCpt);



INSERT INTO Adresse (codePostal,idAdr,rue,ville)  VALUES ('75000',1,'2 rue elle','Paris'),
                                                         ('80000',2,'2 Jules Verne','Amiens');
INSERT INTO Client (numClient,nom,prenom,dateNaissance,ref_adressePrincipale,password,telephone,email)
              VALUES (1,'Defrance','Didier','1969-07-11',1,'mypwd','0102030405','didier@ici_ou_la'),
                     (2,'Therieur','Alex','1980-05-20',2,'mypwd','0102030405','alex.therieur@ici_ou_la');
INSERT INTO Compte (label,numCpt,solde,typeCompte,tauxInteretPct,apportMensuel) VALUES ('compte courant',1,1200.0,'courant',null,null);
INSERT INTO Compte (label,numCpt,solde,typeCompte,tauxInteretPct,apportMensuel) VALUES ('compte codevi',2,50.0,'LDD',1.5,null);    
INSERT INTO Compte (label,numCpt,solde,typeCompte,tauxInteretPct,apportMensuel) VALUES ('compte 3',3,850.0,'PEL',2.0,50.0); 
INSERT INTO Operation (dateOp,label,montant,numOp,ref_compte)  VALUES ('2011-01-20','achat yy',-50.0,1,1);
INSERT INTO Operation (dateOp,label,montant,numOp,ref_compte)  VALUES ('2011-01-21','achat zz',-30.0,2,1);
INSERT INTO ClientCompte (numCli,numCpt) VALUES (1,1);
INSERT INTO ClientCompte (numCli,numCpt) VALUES (1,2);
INSERT INTO ClientCompte (numCli,numCpt) VALUES (2,3);


SELECT * FROM Client;
SELECT * FROM Adresse;
SELECT * FROM Compte;
SELECT * FROM Operation;
SELECT * FROM ClientCompte;

