CREATE TABLE CLIENTE (
	dni 		VARCHAR2(9) CONSTRAINT CLIENTE_DNI_PK PRIMARY KEY,
	fecha_alta 	DATE,
	direccion 	VARCHAR2(50),
	nacimiento 	DATE,
	contrasena 	VARCHAR2(50),
	sexo 		VARCHAR2(1),
	telefono 	VARCHAR2(9),
	mail 		VARCHAR2(50),

	CONSTRAINT CLIENTE_SEXO_CHK CHECK sexo in ('H', 'M', 'O')
);

CREATE TABLE HISTORIAL (
	id			NUMBER(5) CONSTRAINT HISTORIAL_ID_PK PRIMARY KEY,
	fecha		DATE,
	dni			VARCHAR2(9),
	diagnostico	VARCHAR2(300),

	CONSTRAINT HISTORIAL_DNI_FK FOREIGN KEY (dni) REFERENCES CLIENTE(dni)
);

CREATE TABLE PRODUCTOS (
	id				NUMBER(5) CONSTRAINT PRODUCTO_ID_PK PRIMARY KEY,
	utilidad		VARCHAR2(50),
	nombre			VARCHAR2(50),
	laboratorio		VARCHAR2(50),
	precio			NUMBER(5,2),
	stock			NUMBER(3),
	foto			VARCHAR2(150),
	necesita_login	VARCHAR2(2),
	-- ! CATEGORIA

	CONSTRAINT PROD_NECE_LOG_CHK CHECK necesita_login IN ('SI', 'NO')
);



CREATE TABLE TERMINAL (
	id				NUMBER(1) CONSTRAINT TERMINAL_ID_PK PRIMARY KEY,
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



-- #### transacción:
-- - dni_cliente: puede ser un id null (-1 = no registrado)
-- - producto_id
-- - cantidad:
-- - fecha
-- - pago: 1billete

CREATE TABLE transaccion (
	dni_cliente VARCHAR2(9),
	producto_id INTEGER,
	cantidad INTEGER,
	fecha DATE,
	pago VARCHAR2(50)
);

-- CREATE TABLE transaccion (
	
-- )


-- #### Personal
-- - dni- 
-- - nombre
-- - categoría: administrador, empleado

-- CREATE TABLE personal (
--     dni varchar(9) NOT NULL,
--     nombre varchar(50) NOT NULL,
--     categoria varchar(50) NOT NULL,
--     PRIMARY KEY (dni)
-- );


