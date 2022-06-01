-- Cliente
CREATE TABLE CLIENTE (
	dni 		VARCHAR2(9) CONSTRAINT CLIENTE_DNI_PK PRIMARY KEY,
	nombre		VARCHAR2(30),
	fecha_alta 	DATE,
	direccion 	VARCHAR2(50),
	nacimiento 	DATE,
	passwd 	VARCHAR2(50),
	sexo 		VARCHAR2(1),
	telefono 	VARCHAR2(9),
	mail 		VARCHAR2(50),

	CONSTRAINT CLIENTE_SEXO_CHK CHECK sexo in ('H', 'M', 'O')
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

-- Transacción
CREATE TABLE TRANSACCION(
	dni_cliente	VARCHAR2(9),
	producto_id	NUMBER(5),
	fecha		DATETIME,
	cantidad	NUMBER(3),

	CONSTRAINT TRANSACCION_PK PRIMARY KEY (dni_cliente, producto_id, fecha)
);

-- Personal
CREATE TABLE PERSONAL(
	dni VARCHAR2(9) CONSTRAINT PERSONAL_DNI_PK PRIMARY KEY,
	nombre VARCHAR2(50) NOT NULL,
	categoria VARCHAR2(50),
	passwd VARCHAR2(50),
	
	CONSTRAINT PERSONAL_CATE_CHK CHECK categoria IN ('EMPLEADO', 'ADMINISTRATIVO')
);