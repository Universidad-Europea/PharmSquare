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

### Historial(id, fecha, dni, categoria, diagnóstico)
|Atributo|Especial|
|:---:|---|
|id|clave primaria|
|fecha|-|
|dni|-|
|diagnóstico|-|
<!-- Las categorías van en Categorias_historial -->

### Categoria_historial(id, nombre)
<!-- Nos permite añadir categorías sobre la marcha -->
|Atributo|Especial|
|:---:|---|
|id|clave primaria|
|nombre|-|

### Categorias_historial(id_historial, id_categoria)
<!-- Relaciona un historial con una categoría. Nos permite varias categorías en un mismo historial. -->
|Atributo|Especial|
|:---:|---|
|id_historial|clave primaria y clave foránea de **historial**|
|id_categoria|clave primaria y clave foránea de **categoria_historial**|


### Producto(id, categoria, utilidad, nombre, laboratorio, precio, stock, foto, necesita_login)
|Atributo|Especial|
|:---:|---|
|id|clave primaria|
|utilidad|-|
|nombre|-|
|laboratorio|-|
|precio|-|
|stock|-|
|foto|-|
|necesita_login|Dominio definido: 'SI' o 'NO'.|
<!-- Las categorías van en Categorias_producto -->

### Categoria_producto(id, nombre)
<!-- Nos permite añadir categorías sobre la marcha -->
|Atributo|Especial|
|:---:|---|
|id|clave primaria|
|nombre|-|

### Categorias_producto(id_historial, id_producto)
<!-- Relaciona un producto con una categoría. Nos permite varias categorías en un mismo producto. -->
|Atributo|Especial|
|:---:|---|
|id_producto|clave primaria y clave foránea de **producto**|
|id_categoria|clave primaria y clave foránea de **categoria_historial**|


### Terminal(term_id, moneda_1c, moneda_2c, moneda_5c, moneda_10c, moneda_20c, moneda_50c, moneda_1e, billete_5e, billete_10e, billete_50e, billete_100e)
|Atributo|Especial|
|:---:|---|
|term_id|clave primaria.|
|moneda_1c|Opcional con valor por defecto 0.|
|moneda_2c|Opcional con valor por defecto 0.|
|moneda_5c|Opcional con valor por defecto 0.|
|moneda_10c|Opcional con valor por defecto 0.|
|moneda_20c|Opcional con valor por defecto 0.|
|moneda_50c|Opcional con valor por defecto 0.|
|moneda_1e|Opcional con valor por defecto 0.|
|billete_5e|Opcional con valor por defecto 0.|
|billete_10e|Opcional con valor por defecto 0.|
|billete_50e|Opcional con valor por defecto 0.|
|billete_100e|Opcional con valor por defecto 0.|


### Transacción(dni_cliente, producto_id, terminal_id, cantidad, fecha, pago)
|Atributo|Especial|
|:---:|---|
|dni_cliente|clave primaria|
|producto_id|clave primaria|
|terminal_id|clave primaria|
|fecha|clave primaria|
|cantidad|-|
|pago|-|

### Personal(dni, nombre, categoria)
|Atributo|Especial|
|:---:|---|
|dni|clave primaria|
|nombre|-|
|categoria|Dominio definido: 'EMPLEADO' y 'ADMINISTRATIVO'.|


