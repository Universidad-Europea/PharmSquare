CREATE TABLE CLIENTE (
	dni VARCHAR2(9) CONSTRAINT CLIENTE_DNI_PK PRIMARY KEY,
	fecha_alta DATE,
	direccion VARCHAR2(50),
	nacimiento DATE,
	contrasena VARCHAR2(50),
	sexo VARCHAR2(1),
	telefono VARCHAR2(9),
	mail VARCHAR2(50),

	CONSTRAINT CLIENTE_SEXO_CHK CHECK sexo in ('H', 'M', 'O')
);

CREATE TABLE HISTORIAL (
	id NUMBER(5) CONSTRAINT HISTORIAL_ID_PK PRIMARY KEY,
	fecha DATE,
	dni VARCHAR2(9),
	diagnostico VARCHAR2(300),

	CONSTRAINT HISTORIAL_DNI_FK FOREIGN KEY (dni) REFERENCES CLIENTE(dni)
);

CREATE TABLE PRODUCTOS (
	id NUMBER(5) CONSTRAINT PRODUCTO_ID_PK PRIMARY KEY,
	utilidad VARCHAR2(50),
	nombre VARCHAR2(50),
	laboratorio VARCHAR2(50),
	precio NUMBER(5,2),
	stock NUMBER(3),
	foto VARCHAR2(150),
	necesita_login VARCHAR2(2),
	-- CATEGORIA

	CONSTRAINT PROD_NECE_LOG_CHK CHECK necesita_login IN ('SI', 'NO')
);

-- #### terminal pago:
-- - moneda_1c
-- - moneda_2c
-- - moneda_5c
-- - moneda_10c
-- - moneda_20c
-- - moneda_50c
-- - moneda_1e
-- - billete_5e
-- - billete_10e
-- - billete_50e
-- - billete_100e

CREATE TABLE terminal_pago (
	moneda_1c INTEGER,
	moneda_2c INTEGER,
	moneda_5c INTEGER,
	moneda_10c INTEGER,
	moneda_20c INTEGER,
	moneda_50c INTEGER,
	moneda_1e INTEGER,
	billete_5e INTEGER,
	billete_10e INTEGER,
	billete_50e INTEGER,
	billete_100e INTEGER
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


