## Persistencia:

[Ubicación](../src/main/java/dam/pharmaSquare/model/persistencia/)

Cada clase representa una tabla de la base de datos.

Cada clase contine, además de los atributos de la clase, un atributo con el nombre de la tabla y otro con los atributos que conforman la clave primaria.


## Modelos:

[Ubicación](../src/main/java/dam/pharmaSquare/model/)

- Cuando se construye una instancia de una de estas clases, los atributos son verificados. 
Si alguno no cumple las condiciones, se lanzan excepciones con el mensaje de error correspondiente.

- Para cada atributo, tienen un método `public static void isXxxValid(Object Xxx)` que lanza excepciones si el dato introducido es inválido. 
Estos están pensados para la verificación anterior y para verificar a priori los formularios.
