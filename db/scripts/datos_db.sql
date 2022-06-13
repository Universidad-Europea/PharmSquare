-- Script generado usando nodejs
-- Para editar el archivo, usa el commando:
--		nodejs merger.js > datos_db.sql


-- Rellenar CLIENTE

INSERT INTO CLIENTE
VALUES ('000000000A', 'no registrado', NULL, NULL, NULL, NULL, 'O', NULL, NULL);

INSERT INTO CLIENTE
VALUES ('123456789A', 'Juan Garcia', '2019-01-01', 'C/Calle m nº 1', '1995-02-01', '12a!DSAb34!', 'H', '635 456 789', 'juan@gmail.com');

INSERT INTO CLIENTE
VALUES ('987654321A', 'Pedro Perez', '2019-01-01', 'C/Calle m nº 2', '1980-01-04', '@@134daSA', 'H', '635 45 67 43', 'pedro@gmail.com');

INSERT INTO CLIENTE
VALUES ('123456789B', 'Maria Perez', '2019-01-01', 'C/Calle m nº 3', '1970-05-08', '12abfCS!!', 'M', '735456789', 'maria@gmail.com');

INSERT INTO CLIENTE
VALUES ('987654321B', 'Ana Lopez', '2019-01-01', 'C/Calle m nº 4', '1999-07-04', '34!FDSsa!', 'M', '743545359', 'ana@gmail.com');


-- Rellenar PRODUCTO

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Vendaje de piel', 'Vendaje de 30 unidades para la piel.', 'Jhonson & Johnson', 8.69, 10, 'src/main/resources/img/productos/ventaje.png', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Ibuprofeno', 'Ibuprofeno 600mg.', 'Jhonson & Johnson', 5.99, 10, 'src/main/resources/img/productos/ibuprofeno.png', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Paracetamol', 'Paracetamol pack ahorro 40 monodosis.', 'Fharma Labs S.A.', 4.5, 10, 'src/main/resources/img/productos/paracetamol.png', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Aspirina', 'Ahora el doble de burbujas.', 'Fharma Labs S.A.', 3.99, 10, 'src/main/resources/img/productos/aspirina.png', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Ebastel', 'Ebastel monodosis. Pack de 40 dosis.', 'Fharma Labs S.A.', 9.99, 10, 'src/main/resources/img/productos/ebastel.png', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Crema solar', 'Protección 80.', 'Fharma Labs S.A.', 29.99, 10, 'src/main/resources/img/productos/crema_solar.png', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Suero', 'Suero fisiológico', 'Dalsy Corporated', 9.99, 10, 'src/main/resources/img/productos/suero.png', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Cafeina', 'Este producto suele desaparecer de nuestros almacenes por razones misteriosas.', 'Dalsy Corporated', 24.54, 10, 'src/main/resources/img/productos/cafeina.png', 'S');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Suplemento alimenticio bebes', 'Sabor crema de frutas y verduras.', 'Dalsy Corporated', 19.99, 10, 'src/main/resources/img/productos/suplemento_bebes.png', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Suplemento alimenticio adultos', 'Nuevo sabor Fabada con natillas.', 'Fharma Labs S.A.', 19.99, 10, 'src/main/resources/img/productos/suplemento_adultos.png', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Suplemento alimenticio niños', 'Sabor vainilla.', 'Fharma Labs S.A.', 19.99, 10, 'src/main/resources/img/productos/suplemento_ninos.png', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Crema hidratante', 'Especialmente diseñada para su absorción cutánea.', 'Dalsy Corporated', 9.99, 10, 'src/main/resources/img/productos/crema_hidratante.png', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Tiritas', 'Apósitos de tamaño reducido.', 'Dalsy Corporated', 3.99, 10, 'src/main/resources/img/productos/tiritas.png', 'N');

INSERT INTO PRODUCTO (nombre, utilidad, laboratorio, precio, stock, foto, necesita_login)
VALUES ('Apósitos de nitrato de plata', 'Tiritas grandes.', 'Dalsy Corporated', 3.99, 10, 'src/main/resources/img/productos/apositos.png', 'N');


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
VALUES ('123456789A', 1, DATETIME('2022-02-01 13:42'), 2);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('000000000A', 2, DATETIME('2022-02-01 11:42'), 3);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('123456789A', 3, DATETIME('2022-02-01 10:42'), 4);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('987654321B', 4, DATETIME('2022-02-01 14:42'), 5);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('987654321B', 5, DATETIME('2022-02-01 15:42'), 6);

INSERT INTO TRANSACCION (dni_cliente, id_producto, fecha, cantidad)
VALUES ('000000000A', 6, DATETIME('2022-02-01 16:42'), 7);


-- Rellenar PERSONAL

INSERT INTO PERSONAL (dni, nombre, passwd, categoria)
VALUES ('123456789E', 'EMPLEADO GENERICO UNO', 'aBc23!@', 'EMPLEADO');

INSERT INTO PERSONAL (dni, nombre, passwd, categoria)
VALUES ('123456789C', 'EMPLEADO GENERICO DOS', 'aBc23!@', 'EMPLEADO');

INSERT INTO PERSONAL (dni, nombre, passwd, categoria)
VALUES ('123456789D', 'ADMINISTRADOR DE FARMACIA', 'pfSG$%@', 'ADMINISTRADOR');


