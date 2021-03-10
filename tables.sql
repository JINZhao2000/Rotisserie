CREATE TABLE commande(
    numCom INT PRIMARY KEY AUTO_INCREMENT,
    nomClient VARCHAR(50) NOT NULL,
    frit INT DEFAULT 0
);
CREATE TABLE poulet(
    taille CHAR(1) PRIMARY KEY,
    temps TIME NOT NULL,
    stock INT DEFAULT 0
);
CREATE TABLE waitqueue(
    wid INT PRIMARY KEY AUTO_INCREMENT,
    numCom INT,
    taille CHAR(1),
    FOREIGN KEY (numCom) REFERENCES commande(numCom),
    FOREIGN KEY (taille) REFERENCES poulet(taille)
);
CREATE TABLE manager(
    uname VARCHAR(20) PRIMARY KEY,
    pwd INT
);
CREATE TABLE bac(
    bid INT PRIMARY KEY AUTO_INCREMENT,
    statuts INT DEFAULT 0,
    numCom INT DEFAULT 0,
    taille CHAR(1)
);
CREATE TABLE pret(
    pid INT PRIMARY KEY AUTO_INCREMENT,
    numCom INT,
    taille CHAR(1),
    FOREIGN KEY (numCom) REFERENCES commande(numCom),
    FOREIGN KEY (taille) REFERENCES poulet(taille)
);
INSERT INTO manager(uname, pwd) VALUES('s',115);
INSERT INTO poulet(taille,temps,stock) VALUES('L','00:00:30',10);
INSERT INTO poulet(taille,temps,stock) VALUES('M','00:00:20',10);
INSERT INTO poulet(taille,temps,stock) VALUES('S','00:00:10',10);
INSERT INTO bac(statuts) VALUES(0);