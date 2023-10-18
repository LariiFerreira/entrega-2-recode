
CREATE TABLE agenciaviagens.ComprasViagem (
ID_ComprasViagem INTEGER PRIMARY KEY,
ID_Destinos INTEGER,
ID_Usuário INTEGER,
Data NUMERIC(10),
Valortotal VARCHAR(40)
);

CREATE TABLE agenciaviagens.Contato (
ID_Contato INTEGER PRIMARY KEY,
Nome VARCHAR(50),
Email VARCHAR(50),
Mensagem VARCHAR(120)
);

CREATE TABLE agenciaviagens.Usuário (
ID_Usuário INTEGER PRIMARY KEY,
Nome VARCHAR(50),
Sobrenome VARCHAR(50),
Email VARCHAR(50),
Celular VARCHAR(15),
Senha VARCHAR(80),
Gênero VARCHAR(20),
CPF VARCHAR(11),
ID_ComprasViagem INTEGER,
FOREIGN KEY(ID_ComprasViagem) REFERENCES ComprasViagem (ID_ComprasViagem)
);

CREATE TABLE agenciaviagens.Destinos (
ID_Destinos INTEGER PRIMARY KEY,
Promoções VARCHAR(50),
NomeDestino VARCHAR(50),
ValorPadrão VARCHAR(20),
valorPromocional VARCHAR(30),
ID_ComprasViagem INTEGER
);

ALTER TABLE ComprasViagem ADD FOREIGN KEY(ID_Destinos) REFERENCES Destinos (ID_Destinos);
ALTER TABLE ComprasViagem ADD FOREIGN KEY(ID_Usuário) REFERENCES Usuário (ID_Usuário);
ALTER TABLE Destinos ADD FOREIGN KEY(ID_ComprasViagem) REFERENCES Destinos (ID_Destinos);