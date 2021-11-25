# blockbuster-app

PROYECTO #2 - BASES DE DATOS

ALUMNA : ALEJANDRA GONZÁLEZ FERNÁNDEZ

CARNÉ : 2020035049

LA BASE DE DATOS TIENE LOS SIGUIENETE REGISTROS GUARDADOS

TABLA CLIENTE

![image](https://user-images.githubusercontent.com/74033751/143482470-2ca36bea-91f4-46a0-9712-258854a1be02.png)

TABLA CATEGORIA

![image](https://user-images.githubusercontent.com/74033751/143482511-d81f7459-c410-43fe-892e-d06ef6dcd501.png)

TABLA PELICULA

![image](https://user-images.githubusercontent.com/74033751/143482586-44d7b22f-3d75-423f-a437-e40ca5e66926.png)

TABLA PRESTAMO

![image](https://user-images.githubusercontent.com/74033751/143482626-d53fdb0f-f222-4749-9be0-4be8acea35f1.png)


EJECUCIÓN DEL PROGRAMA

CRUD CLIENTE
ATENCION: TODOS LOS NOMBRES DE DIRECCION NO PUEDEN LLEVAR ESPACIOS
```
> mvn exec:java -Dexec.args="cusc Juan Soto 88669977 SanVito"   // Agrega nuevo cliente. Campos requeridos(nombre,apellido,telefono,direccion)
 mvn exec:java -Dexec.args="cusc Vanessa Araya 88766789 Sabalito"   // Agrega nuevo cliente. Campos requeridos(nombre,apellido,telefono,direccion)
> mvn exec:java -Dexec.args=”cusr” // retorna todos los clientes
> mvn exec:java -Dexec.args="cusr 1" // retorna cliente con ID 1
> mvn exec:java -Dexec.args="cusd 7" // borra cliente con ID 6
> mvn exec:java -Dexec.args=”cusr”  // para visualizar los cambios del delete
> mvn exec:java -Dexec.args="cusu 6 Juan Soto 33445533 PerezZeledon" // actualiza el registro en el ID. Campos requeridos(nombre,apellido,telefono,direccion)
1. La llave primaria NO se puede actualizar
> mvn exec:java -Dexec.args=”cusr”  // para visualizar los cambios del update

```

CRUD CATEGORIA
ATENCION: TODOS LOS NOMBRES DE LAS CATEGORIAS NO PUEDEN LLEVAR ESPACIOS
```
> mvn exec:java -Dexec.args="catc Terror" // Agrega nueva categoria. Campos requeridos(nombre)
> mvn exec:java -Dexec.args="catc Romance" // Agrega nueva categoria. Campos requeridos(nombre)
> mvn exec:java -Dexec.args=”catr” // retorna todos las categorías
> mvn exec:java -Dexec.args="catr 1" // retorna categoría con ID 1
> mvn exec:java -Dexec.args="catd 6" // borra categoría con ID 6
> mvn exec:java -Dexec.args=”catr” // para visualizar los cambios del delete
> mvn exec:java -Dexec.args="catu 5 Suspenso" // actualiza el registro en el ID 5. La llave
primaria NO se puede actualizar
> mvn exec:java -Dexec.args=”catr” // para visualizar los cambios del update
```



CRUD MOVIE
ATENCION: TODOS LOS NOMBRES DE LAS PELICULAS NO PUEDEN LLEVAR ESPACIOS
```
> mvn exec:java -Dexec.args="movc Matrix 1999-09-09 4" //Agrega nueva pelicula. Campos requeridos(titulo,fecha de lanzamiento(YYYY-MM-DD),idCategoria)
> mvn exec:java -Dexec.args="movc Constantine 2002-05-10 6" //Agrega nueva pelicula. Campos requeridos(titulo,fecha de lanzamiento(YYYY-MM-DD),idCategoria)
> mvn exec:java -Dexec.args=”movr” // retorna todos las películas
> mvn exec:java -Dexec.args="movr 1" // retorna película con ID 1
> mvn exec:java -Dexec.args="movd 7" // borra película con ID 6
> mvn exec:java -Dexec.args=”movr” // para visualizar los cambios del delete
> mvn exec:java -Dexec.args="movu 6 Matrix 2005-09-09 3" // actualiza el registro en el ID 6.Campos requeridos(movieId,titulo,fecha de lanzamiento(YYYY-MM-DD),idCategoria)
La llave primaria NO se puede actualizar
```



CRUD PRESTAMO
```
> mvn exec:java -Dexec.args="loanc 6 6 2021-09-29 2021-12-12 A" // Agregar prestamo.Campos requeridos(idCliente,idMovie,fechaPrestamo,fechaDevolucion,estado)
> mvn exec:java -Dexec.args="loanc 6 3 2021-09-29 2021-12-12 A" // Agregar prestamo.Campos requeridos(idCliente,idMovie,fechaPrestamo,fechaDevolucion,estado)
> mvn exec:java -Dexec.args=”loanr” // retorna todos los préstamos
> mvn exec:java -Dexec.args="loanr 6" // retorna préstamos del cliente con id 6
> mvn exec:java -Dexec.args="loand 6 3" // borra el préstamo del cliente con id 6 con la pelicula con id 3
```









