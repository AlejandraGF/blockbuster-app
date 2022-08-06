# blockbuster-app

###### Bases de Datos - Alejandra González
###### Este proyecto consiste en una base de datos para un sistema de rentas de pelicula, las funciones de CRUD de las tablas son manejadas desde Java utilizando procedimientos almacenados y transacciones en JDBC. Se agregan registros de prueba para ver el funcionamiento de la BD.
Los archivos que manenjan la base de datos fueron escrito en Java y están gestionados por la herramienta de gestión de proyectos de software Maven ######

## Registros de prueba

Se hace el insert de registros para realizar las pruebas.

Tabla cliente

![image](https://user-images.githubusercontent.com/74033751/143482470-2ca36bea-91f4-46a0-9712-258854a1be02.png)

Tabla categoria

![image](https://user-images.githubusercontent.com/74033751/143482511-d81f7459-c410-43fe-892e-d06ef6dcd501.png)

Tabla pelicula

![image](https://user-images.githubusercontent.com/74033751/143482586-44d7b22f-3d75-423f-a437-e40ca5e66926.png)

Tabla prestamo

![image](https://user-images.githubusercontent.com/74033751/143482626-d53fdb0f-f222-4749-9be0-4be8acea35f1.png)


## EJECUCIÓN DEL PROGRAMA

### CRUD CLIENTE
 - insert: se utiliza el comando `cusc` que recibe 4 parametros (String nombre,String apellido, int telefono, String direccion) 
 - select: para retornar todos los clientes se utiliza `cusr` o para retornar un cliente específico `cusr` `#id`
 - update: se utiliza el comando `cusu` que recibe 5 parametros (int id,String nombre,String apellido, long telefono, String direccion)
- delete: se utiliza el comando `cusd` `#id` para borrar el cliente con el id ingresado

> Precauciones: 
> 
> Los nombres de dirección NO pueden llevar espacios
> 
> La llave primaria (id) NO se puede actualizar


```
> mvn exec:java -Dexec.args="cusc Juan Soto 88669977 SanVito"         // Agrega nuevo cliente. 
> mvn exec:java -Dexec.args="cusc Vanessa Araya 88766789 Sabalito"    // Agrega nuevo cliente.
> mvn exec:java -Dexec.args=”cusr”                                    // retorna todos los clientes
> mvn exec:java -Dexec.args="cusr 1"                                  // retorna cliente con ID 1
> mvn exec:java -Dexec.args="cusd 7"                                  // borra cliente con ID 7
> mvn exec:java -Dexec.args=”cusr”                                    // visualizar los cambios del delete
> mvn exec:java -Dexec.args="cusu 6 Juan Soto 33445533 PerezZeledon"  // actualiza el registro en el ID 6
> mvn exec:java -Dexec.args=”cusr”                                    // visualizar los cambios del update

```

### CRUD CATEGORIA
 - insert: se utiliza el comando `catc` que recibe como parametros (String nombre) 
 - select: para retornar todos las categorias se utiliza `catr` o para retornar una categoria específica `catr` `#id`
 - update: se utiliza el comando `catu` que recibe 2 parametros (int idCategoria,String nombre)
- delete: se utiliza el comando `catd` `#id` para borrar la categoria con el id ingresado

> Precauciones: 
> 
> Los nombres de las categorias NO pueden llevar espacios
> 
> La llave primaria (idCategoria) NO se puede actualizar

```
> mvn exec:java -Dexec.args="catc Terror"                              // Agrega nueva categoria
> mvn exec:java -Dexec.args="catc Romance"                             // Agrega nueva categoria
> mvn exec:java -Dexec.args=”catr”                                     // retorna todos las categorías
> mvn exec:java -Dexec.args="catr 1"                                   // retorna categoría con ID 1
> mvn exec:java -Dexec.args="catd 6"                                   // borra categoría con ID 6
> mvn exec:java -Dexec.args=”catr”                                     // visualizar los cambios del delete
> mvn exec:java -Dexec.args="catu 5 Suspenso"                          // actualiza el registro en el ID 5
> mvn exec:java -Dexec.args=”catr”                                     // visualizar los cambios del update
```


### CRUD MOVIE
 - insert: se utiliza el comando `movc` que recibe como parametros (String titulo,fechaLanzamiento(YYYY-MM-DD),int idCategoria)
 - select: para retornar todos las peliculas se utiliza `movr` o para retornar una pelicula específica `movr` `#id`
 - update: se utiliza el comando `movu` que recibe 4 parametros (int idPelicula,String nombre,fechaLanzamiento(YYYY-MM-DD), int idCategoria)
 - delete: se utiliza el comando `movd` `#id` para borrar la pelicula con el id ingresado

> Precauciones: 
> 
> Los nombres de las peliculas NO pueden llevar espacios
> 
> La llave primaria (idPelicula) NO se puede actualizar

```
> mvn exec:java -Dexec.args="movc Matrix 1999-09-09 4"                //Agrega nueva pelicula
> mvn exec:java -Dexec.args="movc Constantine 2002-05-10 5"           //Agrega nueva pelicula
> mvn exec:java -Dexec.args=”movr”                                    // retorna todos las películas
> mvn exec:java -Dexec.args="movr 1"                                  // retorna película con ID 1
> mvn exec:java -Dexec.args="movd 7"                                  // borra película con ID 6
> mvn exec:java -Dexec.args=”movr”                                    // visualizar los cambios del delete
> mvn exec:java -Dexec.args="movu 6 Matrix 2005-09-09 3"              // actualiza el registro en el ID 6
> mvn exec:java -Dexec.args=”movr”                                    // visualizar los cambios del update
```



### CRUD PRESTAMO
 - insert: se utiliza el comando `loanc` que recibe como parametros (int clienteID,int movieID,fechaPrestamo(YYYY-MM-DD),fechaDevolucion(YYYY-MM-DD),char estado)
 - select: para retornar todos los prestamos se utiliza `loanr` o para retornar todos los prestamos de un cliente en especifico `loanr` `#idCliente`
 - delete: se utiliza el comando `loand` `#idCliente` `#idPelicula` para borrar el prestamo con el id ingresado

```
> mvn exec:java -Dexec.args="loanc 6 6 2021-09-29 2021-12-12 A"       // Agregar prestamo
> mvn exec:java -Dexec.args="loanc 6 3 2021-09-29 2021-12-12 A"       // Agregar prestamo.Campos requeridos(idCliente,idMovie,fechaPrestamo,fechaDevolucion,estado)
> mvn exec:java -Dexec.args=”loanr”                                   // retorna todos los préstamos
> mvn exec:java -Dexec.args="loanr 6"                                 // retorna todos los préstamos del cliente con id 6
> mvn exec:java -Dexec.args="loand 6 3"                               // borra el préstamo del cliente con id 6 y la pelicula con id 3
> mvn exec:java -Dexec.args=”loanr”                                   // visualizar los cambios del delete

```









