DROP TABLE CATEGORIAS_PRODUCTO;
DROP TABLE CATEGORIA_PRODUCTO;
DROP TABLE TRANSACCION;
DROP TABLE CLIENTE;
DROP TABLE PRODUCTO;
DROP TABLE PERSONAL;

-- Cliente
CREATE TABLE CLIENTE (
	dni 		VARCHAR2(9) CONSTRAINT CLIENTE_DNI_PK PRIMARY KEY,
	nombre		VARCHAR2(30) UNIQUE,
	fecha_alta 	DATE,
	direccion 	VARCHAR2(50),
	nacimiento 	DATE,
	passwd 		VARCHAR2(50),
	sexo 		VARCHAR2(1),
	telefono 	VARCHAR2(9) UNIQUE,
	mail 		VARCHAR2(50) UNIQUE,

	CONSTRAINT CLIENTE_SEXO_CHK CHECK (sexo in ('H', 'M', 'O'))
);

-- Producto
CREATE TABLE PRODUCTO (
	id				INTEGER CONSTRAINT PRODUCTO_ID_PK PRIMARY KEY AUTOINCREMENT,
	utilidad		VARCHAR2(50),
	nombre			VARCHAR2(50) UNIQUE,
	laboratorio		VARCHAR2(50),
	precio			NUMBER(5,2),
	stock			NUMBER(3),
	foto			VARCHAR2(150),
	necesita_login	VARCHAR2(1),

	CONSTRAINT PROD_NECE_LOG_CHK CHECK (necesita_login IN ('S', 'N'))
);

CREATE TABLE CATEGORIA_PRODUCTO(
	id		INTEGER CONSTRAINT CAT_PROD_PK PRIMARY KEY AUTOINCREMENT,
	nombre	VARCHAR2(30) UNIQUE
);

CREATE TABLE CATEGORIAS_PRODUCTO(
	id_producto		INTEGER,
	id_categoria	INTEGER,

	CONSTRAINT CAT_HIS_IDS_PK PRIMARY KEY (id_producto, id_categoria),
	CONSTRAINT CAT_HIS_ID_HIS_FK FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id),
	CONSTRAINT CAT_HIS_ID_CAT_HIS_FK FOREIGN KEY (id_categoria) REFERENCES CATEGORIA_PRODUCTO(id)
);

-- Transacción
CREATE TABLE TRANSACCION(
	dni_cliente	VARCHAR2(9),
	id_producto	INTEGER,
	fecha		DATETIME,
	cantidad	NUMBER(3),

	CONSTRAINT TRANSACCION_PK PRIMARY KEY (dni_cliente, id_producto, fecha)
);

-- Personal
CREATE TABLE PERSONAL(
	dni VARCHAR2(9) CONSTRAINT PERSONAL_DNI_PK PRIMARY KEY,
	nombre VARCHAR2(50) NOT NULL,
	categoria VARCHAR2(50),
	passwd VARCHAR2(50),
	
	CONSTRAINT PERSONAL_CATE_CHK CHECK (categoria IN ('EMPLEADO', 'ADMINISTRADOR'))
);
