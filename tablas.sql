-- ---------------------------------
--  Nombre: Alejandra González
--  Carnet: 2020035049
-- ---------------------------------

DROP DATABASE IF EXISTS blockbuster;
CREATE DATABASE blockbuster;                       -- -> Crear la base de datos BLOCKBUSTER.
USE blockbuster;

												   -- -> Crear las tablas correspondientes en la base de datos BLOCKBUSTER. 
CREATE TABLE cliente(
	cedula int PRIMARY KEY auto_increment,
    nombre varchar(50),
	apellido varchar(50),
    telefono_celular int,
    direccion varchar(200)
);
CREATE TABLE categoria(
  id int PRIMARY KEY auto_increment,
  nombre_categoria varchar (50)
);
CREATE TABLE pelicula(
	codigo int PRIMARY KEY auto_increment,
    titulo varchar(50),
    lanzamiento timestamp,
    categoria int,
    CONSTRAINT categoria_fk FOREIGN KEY (categoria) REFERENCES categoria(id)
);

CREATE TABLE prestamo (
	cedula int,
    pelicula_codigo int,
	fecha_prestamo timestamp,
    fecha_devolucion timestamp,
    estado enum ('A','I'),
	CONSTRAINT cliente_fk FOREIGN KEY (cedula) REFERENCES cliente(cedula),
	CONSTRAINT pelicula_fk FOREIGN KEY (pelicula_codigo) REFERENCES pelicula(codigo)
);


DELIMITER $$
CREATE PROCEDURE insert_prestamo (in codigo int,in cliente int,in fecha timestamp)
BEGIN
	 START TRANSACTION;
		insert into prestamo(cedula,pelicula_codigo,fecha_prestamo)values(cliente,codigo,fecha);
	COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE select_all_prestamos ()
BEGIN
	 START TRANSACTION;
		SELECT * FROM prestamo;
	COMMIT;
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE select_prestamo (in codigo int)
BEGIN
	 START TRANSACTION;
		SELECT * FROM prestamo WHERE pelicula_codigo = codigo;
	COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE delete_prestamo (in codigo int,in cliente int)
BEGIN
	 START TRANSACTION;
		DELETE FROM prestamo WHERE cedula = cliente AND pelicula_codigo = codigo ;
	COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insert_categoria (in codigo int,in nombre varchar(50))
BEGIN
	 START TRANSACTION;
		insert into categoria(id,nombre_categoria)values(codigo,nombre);
	COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE select_all_categorias ()
BEGIN
	 START TRANSACTION;
		SELECT * FROM categoria;
	COMMIT;
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE select_categoria (in codigo int)
BEGIN
	 START TRANSACTION;
		SELECT * FROM categoria WHERE id = codigo;
	COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE delete_categoria (in codigo int)
BEGIN
	 START TRANSACTION;
		DELETE FROM categoria WHERE id = codigo ;
	COMMIT;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_categoria (in codigo int,in nuevo_nombre varchar(50))
BEGIN
	 START TRANSACTION;
		UPDATE categoria
        SET nombre_categoria = nuevo_nombre
        WHERE id = codigo;
	COMMIT;
END $$
DELIMITER ;

