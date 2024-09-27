alter table usuarios add column banido smallint;
update usuarios set banido = 0;