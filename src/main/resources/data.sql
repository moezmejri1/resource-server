--CREATE TABLE Utilisateur ( firstname VARCHAR(100),lastname VARCHAR(100),login VARCHAR(100),email VARCHAR(100),password VARCHAR(200));
INSERT INTO Utilisateur (firstname, lastname,login, email, password) VALUES ('Moez','Mejri','MME','moez@gmail.com',ENCRYPT('AES', HASH('SHA256', STRINGTOUTF8('secret-key-12345'), 1), STRINGTOUTF8('1234')));
INSERT INTO Utilisateur (firstname, lastname,login, email, password) VALUES ('Malik','Chettih','MCH','malik@gmail.com',ENCRYPT('AES', HASH('SHA256', STRINGTOUTF8('secret-key-12345'), 1), STRINGTOUTF8('5678')));
