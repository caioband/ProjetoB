alter table usuarios add column banido bool;
update usuarios set banido = true;