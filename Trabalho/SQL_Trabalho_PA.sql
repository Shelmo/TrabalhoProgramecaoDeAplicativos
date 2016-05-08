DROP DATABASE IF EXISTS pizzaria;
CREATE DATABASE pizzaria;
USE pizzaria;

CREATE TABLE Categoria
(
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Produto
(
	id INT NOT NULL AUTO_INCREMENT,
	idCategoria INT NOT NULL,
	nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
	valor DECIMAL(16,2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idCategoria) REFERENCES Categoria(id) ON DELETE CASCADE
);

CREATE TABLE Cliente
(
	id INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	cidade VARCHAR(255),
    bairro VARCHAR(255),
	logradouro VARCHAR(255),
	numero INT,
	complemento VARCHAR(255),
	CEP VARCHAR(8),
	fone VARCHAR(15),
	celular VARCHAR(15),
	email VARCHAR(255),
    dataNasc DATE,
    PRIMARY KEY (id)
);

/*INSERT INTO Categoria VALUES (NULL, 'Cate1');*/

SELECT * FROM Categoria;
SELECT * FROM Produto;
SELECT * FROM Cliente;