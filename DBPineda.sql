-- drop database if exists DB_Laboratorio3;
create database DB_Laboratorio3;
use DB_Laboratorio3;

create table Categoria(
	id_Categoria int auto_increment,
    nombre_Categoria varchar(250), 
    descripcion_Categoria varchar(250),
    primary key PK_categoria (id_Categoria)
);

create table Carro(
	id_Carro int auto_increment,
    marca varchar(250), 
    modelo varchar(250), 
    año varchar(250), 
    primary key PK_carro (id_Carro)
);

create table Repuesto(
	id_Repuesto int auto_increment,
    nombre_Repuesto varchar(250), 
    descripcion varchar(250), 
    categoria int,
    primary key PK_repuesto (id_Repuesto),
    constraint FK_categoria foreign key (categoria)
		references Categoria(id_Categoria)
);

create table Compatibilidad(
	id_Compatibilidad int auto_increment,
    repuesto int,
    carro int,
    primary key PK_compatibilidad (id_Compatibilidad),
    constraint FK_id_repuesto_compa foreign key (repuesto)
		references Repuesto (id_Repuesto),
    constraint FK_id_carro_compa foreign key (carro)
		references Carro( id_Carro)			    
);

DELIMITER //
create procedure sp_AgregarCategoria(	
    nombre varchar(250), 
    descripcion varchar(250)
)
	begin
		insert into Categoria(nombre_Categoria, descripcion_Categoria)
			value(nombre, descripcion);
    end //
DELIMITER ;    
call sp_AgregarCategoria("Oriental EOM" ,"Fabricado por el diseñador original del automovil");

DELIMITER //
create procedure sp_AgregarCarro(
	marc varchar(250), 
    model varchar(250), 
    yearxd varchar(250)
)
	begin
    insert into Carro(marca, modelo, año)
			value(marc, model, yearxd);
    end //
DELIMITER ;
call sp_AgregarCarro("TOYOTA","supra","2029");

DELIMITER //
create procedure sp_AgregarRepuesto(
	nombre varchar(250), 
    descripcionxd varchar(250), 
    categoriaxd int
)
	begin
		    insert into Repuesto(nombre_Repuesto, descripcion, categoria)
			value(nombre, descripcionxd, categoriaxd);
    end //
DELIMITER ;    
call sp_AgregarRepuesto("Bateria","proporciona enegia al automovil",1);    

DELIMITER //
create procedure sp_AgregarCompatibilidad(	
    repuestoxd int,
    carroxd int
)
	begin
		insert into Compatibilidad(repuesto, carro)
			value(repuestoxd, carroxd);
    end //
DELIMITER ;
call sp_AgregarCompatibilidad(1,1);

DELIMITER //
create procedure sp_VerCategorias()
	begin
		select id_Categoria, nombre_Categoria, descripcion_Categoria from Categoria;
    end //
DELIMITER ;
call sp_VerCategorias();

DELIMITER //
create procedure sp_VerCarros()
	begin
		select id_Carro, marca, modelo, año from Carro;
    end //
DELIMITER ;    
call sp_VerCarros();

DELIMITER //
create procedure sp_VerRespuestos()
	begin
		select id_Repuesto, nombre_Repuesto, descripcion, categoria from Repuesto;
    end //
DELIMITER ;
call sp_VerRespuestos();

DELIMITER //
create procedure sp_VerCompatibilidades()
	begin
		select id_Compatibilidad, repuesto, carro from Compatibilidad;
    end //
DELIMITER ;
call sp_VerCompatibilidades();