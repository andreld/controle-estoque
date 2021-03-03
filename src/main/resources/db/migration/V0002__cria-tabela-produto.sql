create table produto (
	id int not null auto_increment,
	descricao varchar(100) not null,
    codigobarras varchar(100) not null,
    valor decimal(10,2),
    
	primary key(id)
)