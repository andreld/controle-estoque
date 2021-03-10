create table pedidoestoque (
	id int not null auto_increment,
    tipo varchar(20) not null,
	observacao text,
    valortotal decimal(10,2),
    
    primary key(id)
)