create table estoque (
	id int not null auto_increment,
    filial_id int not null,
    produto_id int not null,
    quantidade int default 0,
    
    primary key(id)
);

alter table estoque add constraint fk_estoque_filial
foreign key(filial_id) references filial(id);

alter table estoque add constraint fk_estoque_produto
foreign key(produto_id) references produto(id);