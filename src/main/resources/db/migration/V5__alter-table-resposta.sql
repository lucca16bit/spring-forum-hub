alter table resposta drop constraint fkltuv9rkfjtlmn8b0rb3wdbjsv;
alter table resposta add constraint fkltuv9rkfjtlmn8b0rb3wdbjsv
foreign key (topico_id) references topico(id) on delete cascade;

alter table resposta drop constraint fk9999kvnmdq63ah7imctrl06r7;
alter table resposta add constraint fk9999kvnmdq63ah7imctrl06r7
foreign key (autor_id) references usuario(id) on delete cascade;

alter table resposta alter column data_criacao set default current_timestamp;