-- Script generado usando nodejs
-- Para editar el archivo, usa el commando:
--		nodejs merger.js > datos_db.sql


-- Rellenar CLIENTE

INSERT INTO CLIENTE
VALUES ('000000000A', 'no registrado', NULL, NULL, NULL, NULL, 'O', NULL, NULL);

INSERT INTO CLIENTE
VALUES ('123456789A', 'Juan', '2019-01-01', 'C/Calle m nº 1', '1990-01-01', '12ab34!!', 'H', '666666666', 'juan@gmail.com');

INSERT INTO CLIENTE
VALUES ('987654321A', 'Pedro', '2019-01-01', 'C/Calle m nº 2', '1990-01-01', '12ab34!!', 'H', '666666666', 'pedro@gmail.com');

INSERT INTO CLIENTE
VALUES ('123456789B', 'Maria', '2019-01-01', 'C/Calle m nº 3', '1990-01-01', '12ab34!!', 'M', '666666666', 'maria@gmail.com');

INSERT INTO CLIENTE
VALUES ('987654321B', 'Ana', '2019-01-01', 'C/Calle m nº 4', '1990-01-01', '12ab34!!', 'M', '666666666', 'ana@gmail.com');


-- Rellenar PRODUCTO

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Bendaje de piel', 'Utilidad 1', 'Laboratorio 1', 9.99, 10, './res/img/productos/bendaje.jpg', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Ibuprofeno', 'Utilidad 2', 'Laboratorio 1', 9.99, 10, './res/img/productos/ibuprofeno.jpg', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Paracetamol', 'Utilidad 3', 'Laboratorio 3', 9.99, 10, './res/img/productos/paracetamol.jpg', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Aspirina', 'Utilidad 4', 'Laboratorio 4', 9.99, 10, './res/img/productos/aspirina.jpg', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Ebastel', 'Utilidad 5', 'Laboratorio 5', 9.99, 10, './res/img/productos/ebastel.jpg', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Crema solar', 'Utilidad 6', 'Laboratorio 6', 9.99, 10, './res/img/productos/crema_solar.jpg', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Suero', 'Utilidad 7', 'Laboratorio 5', 9.99, 10, './res/img/productos/suero.jpg', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Cafeina', 'Utilidad 8', 'Laboratorio 6', 9.99, 10, './res/img/productos/cafeina.jpg', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Suplemento alimenticio bebes', 'Utilidad 9', 'Laboratorio 6', 9.99, 10, './res/img/productos/suplemento_bebes.jpg', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Suplemento alimenticio adultos', 'Utilidad 10', 'Laboratorio 2', 9.99, 10, './res/img/productos/suplemento_adultos.jpg', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Suplemento alimenticio niños', 'Utilidad 11', 'Laboratorio 3', 9.99, 10, './res/img/productos/suplemento_ninos.jpg', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Crema hidratante', 'Utilidad 12', 'Laboratorio 4', 9.99, 10, './res/img/productos/crema_hidratante.jpg', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Tiritas', 'Utilidad 13', 'Laboratorio 5', 9.99, 10, './res/img/productos/tiritas.jpg', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Apósitos de nitrato de plata', 'Utilidad 14', 'Laboratorio 6', 9.99, 10, './res/img/productos/apositos.jpg', 'N');


-- Rellenar CATEGORIA_PRODUCTO

INSERT INTO CATEGORIA_PRODUCTO (nombre)
VALUES ('Suplementos');

INSERT INTO CATEGORIA_PRODUCTO (nombre)
VALUES ('Higiene');

INSERT INTO CATEGORIA_PRODUCTO (nombre)
VALUES ('Medicamentos');

INSERT INTO CATEGORIA_PRODUCTO (nombre)
VALUES ('Belleza');


-- Rellenar CATEGORIAS_PRODUCTO

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (1, 1);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (2, 1);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (3, 1);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (4, 1);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (5, 2);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (6, 2);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (7, 2);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (8, 2);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (9, 3);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (10, 3);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (11, 3);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (12, 3);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (13, 4);

INSERT INTO CATEGORIAS_PRODUCTO
VALUES (14, 4);


-- Rellenar TRANSACCION

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('000000000A', 2, DATETIME('2022-02-01 12:42'), 1);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('000000000A', 1, DATETIME('2022-02-01 13:42'), 2);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('000000000A', 2, DATETIME('2022-02-01 11:42'), 3);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('000000000A', 3, DATETIME('2022-02-01 10:42'), 4);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('000000000A', 4, DATETIME('2022-02-01 14:42'), 5);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('000000000A', 5, DATETIME('2022-02-01 15:42'), 6);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('000000000A', 6, DATETIME('2022-02-01 16:42'), 7);


-- Rellenar PERSONAL

INSERT INTO PERSONAL (dni, nombre, passwd, categoria)
VALUES ('123456789E', 'EMPLEADO GENERICO UNO', 'aBc23!@', 'EMPLEADO');

INSERT INTO PERSONAL (dni, nombre, passwd, categoria)
VALUES ('123456789C', 'EMPLEADO GENERICO DOS', 'aBc23!@', 'EMPLEADO');

INSERT INTO PERSONAL (dni, nombre, passwd, categoria)
VALUES ('123456789D', 'ADMINISTRADOR DE FARMACIA', 'pfSG$%@', 'ADMINISTRADOR');


