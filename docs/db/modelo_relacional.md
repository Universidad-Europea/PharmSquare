A menos que se especifique, todos los cambios son obligatorios.

### Cliente(dni, nombre, fecha alta, dirección, nacimiento, contraseña, sexo, teléfono, mail)
|Atributo|Especial|
|:---:|---|
|dni|clave primaria|
|nombre|-|
|fecha alta|-|
|dirección|-|
|nacimiento|-|
|passwd|-|
|sexo|Dominio definido: 'H', 'M', 'O'|
|teléfono|-|
|mail|-|

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

### Transacción(dni_cliente, producto_id, terminal_id, cantidad, fecha)
|Atributo|Especial|
|:---:|---|
|dni_cliente|clave primaria|
|producto_id|clave primaria|
|terminal_id|clave primaria|
|fecha|clave primaria|
|cantidad|-|

### Personal(dni, nombre, passwd, categoria)
|Atributo|Especial|
|:---:|---|
|dni|clave primaria|
|nombre|-|
|passwd|-|
|categoria|Dominio definido: 'EMPLEADO' y 'ADMINISTRATIVO'.|


