CREATE USER AULA2EX1 IDENTIFIED BY oracle;
GRANT CONNECT TO AULA2EX1;
GRANT CONNECT, RESOURCE, DBA TO AULA2EX1;
GRANT CREATE SESSION TO AULA2EX1;
GRANT DBA TO AULA2EX1;
GRANT CREATE VIEW, CREATE PROCEDURE, CREATE SEQUENCE to AULA2EX1;
GRANT UNLIMITED TABLESPACE TO AULA2EX1;
GRANT CREATE MATERIALIZED VIEW TO AULA2EX1;
GRANT CREATE TABLE TO AULA2EX1;
GRANT GLOBAL QUERY REWRITE TO AULA2EX1;
GRANT SELECT ANY TABLE TO AULA2EX1;


CREATE TABLE PAIS ( 
ID_PAIS NUMBER(38,0) PRIMARY KEY NOT NULL,
NOME VARCHAR2(50) UNIQUE NOT NULL 
); 
DROP TABLE PAIS;


CREATE TABLE ESTADO( 
ID_ESTADO NUMBER(38,0) PRIMARY KEY NOT NULL,
ID_PAIS NUMBER(38,0) NOT NULL, 
NOME VARCHAR2(50) UNIQUE NOT NULL, 
CONSTRAINT FK_ID_PAIS FOREIGN KEY ( ID_PAIS ) REFERENCES PAIS( ID_PAIS ) 
);

DROP TABLE ESTADO;

CREATE TABLE CIDADE(
ID_CIDADE NUMBER(38,0) NOT NULL,
ID_ESTADO NUMBER (38,0) NOT NULL,
NOME VARCHAR2(50) NOT NULL,
CONSTRAINT PK_CIDADE_ESTADO PRIMARY KEY (ID_CIDADE, ID_ESTADO)
);

DROP TABLE CIDADE;


CREATE TABLE BAIRRO (
ID_BAIRRO NUMBER(38,0) NOT NULL,
ID_CIDADE NUMBER(38,0) NOT NULL,
ID_ESTADO NUMBER (38,0) NOT NULL,
NOME VARCHAR2(50) NOT NULL,
CONSTRAINT PK_BAIRRO_CIDADE PRIMARY KEY (ID_BAIRRO , ID_CIDADE),
CONSTRAINT FK_ID_ESTADO FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO (ID_ESTADO)

);

DROP TABLE BAIRRO;



CREATE TABLE ENDERECO(
ID_ENDERECO NUMBER(38,0) PRIMARY KEY NOT NULL,
ID_CIDADE NUMBER(38,0) NOT NULL,
ID_BAIRRO NUMBER (38,0) NOT NULL,
LOGRADOURO VARCHAR2(255) NOT NULL,
NUMERO NUMBER(38,0) NOT NULL,
COMPLEMENTO VARCHAR2(100),
CEP CHAR(9),
CONSTRAINT FK_ID_BAIRRO FOREIGN KEY (ID_BAIRRO, ID_CIDADE) REFERENCES BAIRRO (ID_BAIRRO, ID_CIDADE)
);

DROP TABLE ENDERECO;




SELECT * FROM PAIS;
SELECT * FROM ESTADO;
SELECT * FROM CIDADE;
SELECT * FROM BAIRRO;
SELECT * FROM ENDERECO;


