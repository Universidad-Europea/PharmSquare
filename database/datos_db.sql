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

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Bendaje de piel', 'Utilidad 1', 'Laboratorio 1', 9.99, 10, './res/img/productos/bendaje.jpg', 'S');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Ibuprofeno', 'Utilidad 2', 'Laboratorio 1', 9.99, 10, './res/img/productos/ibuprofeno.jpg', 'S');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Paracetamol', 'Utilidad 3', 'Laboratorio 3', 9.99, 10, './res/img/productos/paracetamol.jpg', 'S');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Aspirina', 'Utilidad 4', 'Laboratorio 4', 9.99, 10, './res/img/productos/aspirina.jpg', 'S');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Ebastel', 'Utilidad 5', 'Laboratorio 5', 9.99, 10, './res/img/productos/ebastel.jpg', 'S');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Crema solar', 'Utilidad 6', 'Laboratorio 6', 9.99, 10, './res/img/productos/crema_solar.jpg', 'N');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Suero', 'Utilidad 7', 'Laboratorio 5', 9.99, 10, './res/img/productos/suero.jpg', 'S');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Cafeina', 'Utilidad 8', 'Laboratorio 6', 9.99, 10, './res/img/productos/cafeina.jpg', 'S');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Suplemento alimenticio bebes', 'Utilidad 9', 'Laboratorio 6', 9.99, 10, './res/img/productos/suplemento_bebes.jpg', 'N');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Suplemento alimenticio adultos', 'Utilidad 10', 'Laboratorio 2', 9.99, 10, './res/img/productos/suplemento_adultos.jpg', 'N');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Suplemento alimenticio niños', 'Utilidad 11', 'Laboratorio 3', 9.99, 10, './res/img/productos/suplemento_ninos.jpg', 'N');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Crema hidratante', 'Utilidad 12', 'Laboratorio 4', 9.99, 10, './res/img/productos/crema_hidratante.jpg', 'N');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Tiritas', 'Utilidad 13', 'Laboratorio 5', 9.99, 10, './res/img/productos/tiritas.jpg', 'N');

INSERT INTO PRODUCTO (id, nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES (PRODUCTO_SEQ.NEXTVAL, 'Apósitos de nitrato de plata', 'Utilidad 14', 'Laboratorio 6', 9.99, 10, './res/img/productos/apositos.jpg', 'N');


-- Rellenar CATEGORIA_PRODUCTO

INSERT INTO CATEGORIA_PRODUCTO
VALUES (CATEGORIA_PRODUCTO_SEQ.NEXTVAL, 'Suplementos');

INSERT INTO CATEGORIA_PRODUCTO
VALUES (CATEGORIA_PRODUCTO_SEQ.NEXTVAL, 'Higiene');

INSERT INTO CATEGORIA_PRODUCTO
VALUES (CATEGORIA_PRODUCTO_SEQ.NEXTVAL, 'Medicamentos');

INSERT INTO CATEGORIA_PRODUCTO
VALUES (CATEGORIA_PRODUCTO_SEQ.NEXTVAL, 'Belleza');


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


-- Rellenar PERSONAL

INSERT INTO PERSONAL
VALUES ('123456789E', 'EMPLEADO 1', '1234', 'EMPLEADO');

INSERT INTO PERSONAL
VALUES ('123456789C', 'EMPLEADO 1', 'aBc23!@', 'EMPLEADO');

INSERT INTO PERSONAL
VALUES ('123456789D', 'ADMINISTRADOR 1', 'pfSG$%@', 'ADMINISTRADOR');


