# PharmSquare

## TODO:
- [ ] Entregar.
- [ ] Verificar toque todo lo requerido para la entrega está listo.
	- [ ] Verificar MER.
	- [ ] Verificar modelo relacional.
	- [ ] Script de creación.
	- [ ] Datos de entrada.
	- [ ] Product Backlog.
- [ ] Añadir la clave primaria term_id en la tabla terminal.
- [ ] Añadir las tablas **Categoria_historial** y **Categorias_historial** al script de creación y datos de entrada.
- [ ] Añadir **terminal_id** a la tabla transacción.
- [ ] Eliminar la relación **MODIFICAR** entre **TERMINAL** y **TRANSACCION** en el MER
	- Para que esta relación exista, se necesita que añadir varias tablas y no creo que merezca la pena la complejidad.
	- Podemos hacerlo independiente y que para pagar ya tengas que tener en cuenta la lógica del dinero introducido vs dinero retornado.
	- Por tanto, el atributo pago de la tabla transacción también será eliminado.