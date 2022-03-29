-- Cliente
CREATE TABLE CLIENTE (
	dni 		VARCHAR2(9) CONSTRAINT CLIENTE_DNI_PK PRIMARY KEY,
	nombre		VARCHAR2(30),
	fecha_alta 	DATE,
	direccion 	VARCHAR2(50),
	nacimiento 	DATE,
	contrasena 	VARCHAR2(50),
	sexo 		VARCHAR2(1),
	telefono 	VARCHAR2(9),
	mail 		VARCHAR2(50),

	CONSTRAINT CLIENTE_SEXO_CHK CHECK sexo in ('H', 'M', 'O')
);

-- Historial
CREATE TABLE HISTORIAL (
	id			NUMBER(5) CONSTRAINT HISTORIAL_ID_PK PRIMARY KEY,
	fecha		DATE,
	dni			VARCHAR2(9),
	diagnostico	VARCHAR2(300),

	CONSTRAINT HISTORIAL_DNI_FK FOREIGN KEY (dni) REFERENCES CLIENTE(dni)
);

CREATE TABLE CATEGORIA_HISTORIAL(
	id		NUMBER(3),
	nombre	VARCHAR2(30)
);

CREATE TABLE CATEGORIAS_HISTORIAL(
	id_historial	NUMBER(5),
	id_categoria	NUMBER(3),

	CONSTRAINT CAT_HIS_IDS_PK PRIMARY KEY (id_historial, id_categoria),
	CONSTRAINT CAT_HIS_ID_HIS_FK FOREIGN KEY (id_historial) REFERENCES HISTORIAL(id),
	CONSTRAINT CAT_HIS_ID_CAT_HIS_FK FOREIGN KEY (id_categoria) REFERENCES CATEGORIA_HISTORIAL(id)
);

-- Producto
CREATE TABLE PRODUCTOS (
	id				NUMBER(5) CONSTRAINT PRODUCTO_ID_PK PRIMARY KEY,
	utilidad		VARCHAR2(50),
	nombre			VARCHAR2(50),
	laboratorio		VARCHAR2(50),
	precio			NUMBER(5,2),
	stock			NUMBER(3),
	foto			VARCHAR2(150),
	necesita_login	VARCHAR2(2),

	CONSTRAINT PROD_NECE_LOG_CHK CHECK necesita_login IN ('SI', 'NO')
);

CREATE TABLE CATEGORIA_PRODUCTO(
	id		NUMBER(3),
	nombre	VARCHAR2(30)
);

CREATE TABLE CATEGORIAS_PRODUCTO(
	id_producto	NUMBER(5),
	id_categoria	NUMBER(3),

	CONSTRAINT CAT_HIS_IDS_PK PRIMARY KEY (id_producto, id_categoria),
	CONSTRAINT CAT_HIS_ID_HIS_FK FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id),
	CONSTRAINT CAT_HIS_ID_CAT_HIS_FK FOREIGN KEY (id_categoria) REFERENCES CATEGORIA_PRODUCTO(id)
);

-- Terminal
CREATE TABLE TERMINAL(
	term_id			NUMBER(1) CONSTRAINT TERMINAL_ID_PK PRIMARY KEY,
	moneda_1c		NUMBER(2) DEFAULT 0,
	moneda_2c		NUMBER(2) DEFAULT 0,
	moneda_5c		NUMBER(2) DEFAULT 0,
	moneda_10c		NUMBER(2) DEFAULT 0,
	moneda_20c		NUMBER(2) DEFAULT 0,
	moneda_50c		NUMBER(2) DEFAULT 0,
	moneda_1e		NUMBER(2) DEFAULT 0,
	billete_5e		NUMBER(2) DEFAULT 0,
	billete_10e		NUMBER(2) DEFAULT 0,
	billete_50e		NUMBER(2) DEFAULT 0,
	billete_100e	NUMBER(2) DEFAULT 0
);

-- Transacción
CREATE TABLE TRANSACCION(
	dni_cliente	VARCHAR2(9),
	producto_id	NUMBER(5),
	term_id		NUMBER(1),
	fecha		DATETIME,
	cantidad	NUMBER(3),

	CONSTRAINT TRANSACCION_PK PRIMARY KEY (dni_cliente, producto_id, term_id, fecha)
);

-- Personal
CREATE TABLE PERSONAL(
	dni VARCHAR2(9) CONSTRAINT PERSONAL_DNI_PK PRIMARY KEY,
	nombre VARCHAR2(50) NOT NULL,
	categoria VARCHAR2(50),
	password VARCHAR2(50)
	
	CONSTRAINT PERSONAL_CATE_CHK CHECK categoria IN ('EMPLEADO', 'ADMINISTRATIVO')
);
