create database smartlife;
use smartlife;
create table usuario(
nombre nvarchar(20),
a_paterno nvarchar(40),
a_materno nvarchar(40),
usuario nvarchar(100),
correo nvarchar(50),
telefono nvarchar(50),
rol nvarchar(100),
contraseña nvarchar(100)
);
select * from usuario;
