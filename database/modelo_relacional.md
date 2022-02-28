A menos que se especifique, todos los cambios son obligatorios.

### Cliente(dni, nombre, fecha alta, dirección, nacimiento, contraseña, sexo, teléfono, mail)
|Atributo|Especial|
|:---:|---|
|dni|clave primaria|
|nombre|-|
|fecha alta|-|
|dirección|-|
|nacimiento|-|
|contraseña|-|
|sexo|-|
|teléfono|-|
|mail|-|

### Historial(id, fecha, dni, categoría, diagnóstico)
|Atributo|Especial|
|:---:|---|
|id|clave primaria|
|fecha|-|
|dni|-|
|categoría|-|
|diagnóstico|-|

### Producto(id, categoría, utilidad, nombre, laboratorio, precio, stock, foto, necesita_login)
|Atributo|Especial|
|:---:|---|
|id|clave primaria|
|categoría|-|
|utilidad|-|
|nombre|-|
|laboratorio|-|
|precio|-|
|stock|-|
|foto|-|
|necesita_login|-|

### Terminal(term_id, moneda_1c, moneda_2c, moneda_5c, moneda_10c, moneda_20c, moneda_50c, moneda_1e, billete_5e, billete_10e, billete_50e, billete_100e)
|Atributo|Especial|
|:---:|---|
|term_id|clave primaria|
|moneda_1c|-|
|moneda_2c|-|
|moneda_5c|-|
|moneda_10c|-|
|moneda_20c|-|
|moneda_50c|-|
|moneda_1e|-|
|billete_5e|-|
|billete_10e|-|
|billete_50e|-|
|billete_100e|-|

### Transacción(dni_cliente, producto_id, cantidad, fecha, pago)
|Atributo|Especial|
|:---:|---|
|dni_cliente|clave primaria|
|producto_id|clave primaria|
|fecha|clave primaria|
|cantidad|-|
|pago|-|

### Personal(dni, nombre, categoría)
|Atributo|Especial|
|:---:|---|
|dni|-|
|nombre|-|
|categoría|-|


