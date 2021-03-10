create table itenspedido(
	estoque_id int not null,
    pedidoestoque_id int not null,
    quantidade int not null,
    status varchar(20) not null,
    valortotal decimal(10,2)
);

alter table itenspedido add constraint fk_estoque_itenspedido
foreign key(estoque_id) references estoque(id);

alter table itenspedido add constraint fk_pedidoestoque_itenspedido
foreign key(pedidoestoque_id) references pedidoestoque(id);
