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
> mvn exec:java -Dexec.args=”cusr” // retorna todos los clientes
> mvn exec:java -Dexec.args="cusu 6 Juan Soto 33445533 PerezZeledon" // actualiza el registro en el ID. Campos requeridos(nombre,apellido,telefono,direccion)
1. La llave primaria NO se puede actualizar
> mvn exec:java -Dexec.args=”cusr”  // para visualizar los cambios del update
> mvn exec:java -Dexec.args="cusr 1" // retorna cliente con ID 1
> mvn exec:java -Dexec.args="cusd 6" // borra cliente con ID 6
> mvn exec:java -Dexec.args=”cusr”  // para visualizar los cambios del delete

```



