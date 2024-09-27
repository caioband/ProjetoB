
create table usuarios
(
    id serial primary key,
    nome varchar(40)
);

create table produtos(
item_nome varchar(15),
item_qtd integer,
item_vendas integer,
item_prc integer
)