# PharmaSquare Wiki:

## Índice:
- [UI/UX](#uiux)
- [Backend](#backend)
    - [Base de datos](#base-de-datos)
    - [Persistencia](#persistencia) 
    - [Control base de datos](#control-base-de-datos)
- [Tests unitarios](#tests-unitarios)


## UI/UX:
Ups! Sección todavía en desarrollo.

## Backend:
Este apartado relata cómo se ha desarrollado toda la lógica que hay por detrás de la aplicación. Si bien es cierto que nuestra aplicación local no tiene un backend como tal, esta seción mostrará cómo se ha desarrollado cada parte para integrarse con la aplicación.

### Base de datos:
[Ubicación](../db/)

La base de datos de nuestro sistema es una base de datos SQL con SQLite3. Esta almacena toda la información necesaria por nuestra aplicación.

Para acceder a esta fuente de datos, hacemos uso de la clase [PharmaSquareDB](../src/main/java/dam/pharmaSquare/db/PharmaSquareDB.java).
Con la ayuda de la lógica lógica común para el manejo de BBDD que tenemos en el paquete [db](../src/main/java/dam/db/),
somos capaces de crear de una manera sencilla toda la lógica entre la aplicación y la base de datos.

![base de datos](../res/img/mer_fondoblanco.png)


### Persistencia:

[Ubicación](../src/main/java/dam/pharmaSquare/model/persistencia/)

Cada clase representa una tabla de la base de datos.

Cada clase contine, además de los atributos de la clase, un atributo con el nombre de la tabla y otro con los atributos que conforman la clave primaria.


### Modelos:

[Ubicación](../src/main/java/dam/pharmaSquare/model/)

Cuando se construye una instancia de una de estas clases, los atributos son verificados. 
Si alguno no cumple las condiciones, se lanzan excepciones con el mensaje de error correspondiente.

Para cada atributo, tienen un método `public static void isXxxValid(Object Xxx)` que lanza excepciones si el dato introducido es inválido. 
Estos están pensados para la verificación anterior y para verificar a priori los formularios.


### Control Base de datos:

[Ubicación](../src/main/java/dam/pharmaSquare/db/)

La lógica de la base de datos está formada por una serie de clases y métodos que simplifican la consulta y modificación de esta de manera que resulte sencillo su implementación en el proyecto.

## Tests unitarios:
A la hora de verificar cada uno de los módulos usados en el código, se ha utilizado tests unitarios JUnit5.
Estos verifican de manera individual cada una de las funcionalidades.

*Nota*: Nos hubiera gustado crear tests automáticos de uso-implementación. Sin embargo, el currículo del curso
no plantea que seamos capaces de realizar este tipo de tests. Por este motivo, toda la parte propia de la
aplicación no contiene tests más de los que ya tienen los módulos que usan.