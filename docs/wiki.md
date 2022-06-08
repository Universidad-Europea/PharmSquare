# PharmaSquare Wiki:

## Índice:
- [UI/UX](#uiux)
	- TODO
- [Backend](#backend)
	- [Base de datos](#base-de-datos)
	- [Persistencia](#persistencia) 
	- [](#)
	- [](#)
	- [](#)
	- [](#)


## UI/UX:
Ups! Sección todavía en desarrollo.

## Backend:
Este apartado relata cómo se ha desarrollado toda la lógica que hay por detrás de la aplicación. Si bien es cierto que nuestra aplicación local no tiene un backend como tal, esta seción mostrará cómo se ha desarrollado cada parte para integrarse con la aplicación.

### Base de datos:


### Persistencia:

[Ubicación](../src/main/java/dam/pharmaSquare/model/persistencia/)

Cada clase representa una tabla de la base de datos.

Cada clase contine, además de los atributos de la clase, un atributo con el nombre de la tabla y otro con los atributos que conforman la clave primaria.


### Modelos:

[Ubicación](../src/main/java/dam/pharmaSquare/model/)

- Cuando se construye una instancia de una de estas clases, los atributos son verificados. 
Si alguno no cumple las condiciones, se lanzan excepciones con el mensaje de error correspondiente.

- Para cada atributo, tienen un método `public static void isXxxValid(Object Xxx)` que lanza excepciones si el dato introducido es inválido. 
Estos están pensados para la verificación anterior y para verificar a priori los formularios.


### Base de datos:

[Ubicación](../src/main/java/dam/pharmaSquare/db/)

La lógica de la base de datos está formada por una serie de clases y métodos que simplifican la consulta y modificación de esta de manera que resulte sencillo su implementación en el proyecto.
