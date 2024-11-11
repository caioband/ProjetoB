
create table funcionarios
(
    id serial primary key,
    nome varchar(40),
    senha varchar(30)
);

create table clientes (
    id serial primary key,
    nome varchar(40)
);

create table produtos(
item_nome varchar(15),
item_qtd integer,
item_vendas integer,
item_prc integer
)