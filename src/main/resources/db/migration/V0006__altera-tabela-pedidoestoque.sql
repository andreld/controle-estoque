alter table pedidoestoque add column filial_id int not null after id;
alter table pedidoestoque add constraint fk_pedidoestoque_filial 
foreign key(filial_id) references filial(id);