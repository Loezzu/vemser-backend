CREATE USER AULA2_HOMEWORK1 IDENTIFIED BY oracle;
GRANT CONNECT TO AULA2_HOMEWORK1;
GRANT CONNECT, RESOURCE, DBA TO AULA2_HOMEWORK1;
GRANT CREATE SESSION TO AULA2_HOMEWORK1;
GRANT DBA TO AULA2_HOMEWORK1;
GRANT CREATE VIEW, CREATE PROCEDURE, CREATE SEQUENCE to AULA2_HOMEWORK1;
GRANT UNLIMITED TABLESPACE TO AULA2_HOMEWORK1;
GRANT CREATE MATERIALIZED VIEW TO AULA2_HOMEWORK1;
GRANT CREATE TABLE TO AULA2_HOMEWORK1;
GRANT GLOBAL QUERY REWRITE TO AULA2_HOMEWORK1;
GRANT SELECT ANY TABLE TO AULA2_HOMEWORK1;



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



CREATE SEQUENCE SEQ_PAIS
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;
DROP SEQUENCE SEQ_PAIS 

CREATE SEQUENCE SEQ_ESTADO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;
DROP SEQUENCE SEQ_ESTADO 

CREATE SEQUENCE SEQ_CIDADE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;
DROP SEQUENCE SEQ_CIDADE 

CREATE SEQUENCE SEQ_BAIRRO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;
DROP SEQUENCE SEQ_BAIRRO 

CREATE SEQUENCE SEQ_ENDERECO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;
DROP SEQUENCE SEQ_ENDERECO


INSERT INTO PAIS (ID_PAIS, NOME) VALUES(SEQ_PAIS.nextval, 'Brasil');
INSERT INTO PAIS (ID_PAIS, NOME) VALUES(SEQ_PAIS.nextval, 'Argentina');

INSERT INTO ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (SEQ_ESTADO.nextval, 1, 'Rio Grande do Sul');
INSERT INTO ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (SEQ_ESTADO.nextval, 1, 'Santa Catarina');
INSERT INTO ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (SEQ_ESTADO.nextval, 2, 'Buenos Aires');
INSERT INTO ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (SEQ_ESTADO.nextval, 2, 'Chaco');

INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval, 1, 'Gravataí');
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval, 2, 'Florianópolis');
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval, 3, 'Santa Rosa');
INSERT INTO CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_CIDADE.nextval, 4, 'Resistencia');

INSERT INTO BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_BAIRRO.nextval, 1, 1, 'Morada do Vale 2');
INSERT INTO BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_BAIRRO.nextval, 2, 2, 'Centro');
INSERT INTO BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_BAIRRO.nextval, 3, 3, 'Bairro Argentino 1');
INSERT INTO BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (SEQ_BAIRRO.nextval, 4, 4, 'Bairro Argentino 2');

INSERT INTO ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP) VALUES (SEQ_ENDERECO.nextval , 1, 1, 'Rua 1', 1, 899940200);
INSERT INTO ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP) VALUES (SEQ_ENDERECO.nextval , 1, 1, 'Rua 2', 2, 063634567);
INSERT INTO ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP) VALUES (SEQ_ENDERECO.nextval, 2, 2, 'Rua 3', 3, 535333120);
INSERT INTO ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP) VALUES (SEQ_ENDERECO.nextval, 2, 2, 'Rua 4', 4, 042233131);
INSERT INTO ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP) VALUES (SEQ_ENDERECO.nextval, 3, 3, 'Rua 5', 5, 888888880);
INSERT INTO ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP) VALUES (SEQ_ENDERECO.nextval, 3, 3, 'Rua 6', 6, 232323232);
INSERT INTO ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP) VALUES (SEQ_ENDERECO.nextval, 4, 4, 'Rua 7', 7, 777777777);
INSERT INTO ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, CEP) VALUES (SEQ_ENDERECO.nextval, 4, 4, 'Avenida 1', 8, 999999999);


SELECT NOME  FROM PAIS
ORDER BY NOME DESC;

SELECT LOGRADOURO, CEP FROM ENDERECO
WHERE UPPER(LOGRADOURO) LIKE 'A%'; 

SELECT * FROM ENDERECO 
WHERE CEP LIKE '%0';

SELECT * FROM ENDERECO
WHERE NUMERO BETWEEN 1 AND 100;

SELECT * FROM ENDERECO
WHERE UPPER(LOGRADOURO) LIKE 'RUA%'
ORDER BY CEP DESC; 

SELECT COUNT(ID_ENDERECO)
FROM ENDERECO;

SELECT ID_CIDADE, COUNT(ID_ENDERECO)
FROM ENDERECO
GROUP BY ID_CIDADE
ORDER BY ID_CIDADE;

