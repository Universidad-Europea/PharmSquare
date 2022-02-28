A menos que se especifique, todos los cambios son obligatorios.

#### Cliente (dni, nombre, fecha alta, dirección, nacimiento, contraseña, sexo, teléfono, mail)

|Atributo|Especial|
|
|dni|clave primaria
|nombre|-|
|fecha alta|-|
|dirección|-|
|nacimiento|-|
|contraseña|-|
|sexo|-|
|teléfono|-|
|mail|-|

#### Historial médico(id, fecha, dni, categoría, diagnóstico)
- id
- fecha
- dni
- categoría
- diagnóstico

#### Productos()
- id
- categoría
- utilidad
- nombre
- laboratorio
- precio
- stock
- foto
- necesita_login

#### terminal pago()
- moneda_1c
- moneda_2c
- moneda_5c
- moneda_10c
- moneda_20c
- moneda_50c
- moneda_1e
- billete_5e
- billete_10e
- billete_50e
- billete_100e



#### transacción()
- dni_cliente
- producto_id
- cantidad
- fecha
- pago

CREATE TABLE transaccion (
    
)


#### Personal()
- dni- 
- nombre
- categoría

CREATE TABLE personal (
    dni varchar(9) NOT NULL,
    nombre varchar(50) NOT NULL,
    categoria varchar(50) NOT NULL,
    PRIMARY KEY (dni)
);

