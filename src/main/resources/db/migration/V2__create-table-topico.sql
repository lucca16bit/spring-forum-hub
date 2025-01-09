create table topico (
    id bigint not null generated by default as identity,
    titulo varchar(100) not null,
    mensagem text not null,
    data_criacao timestamp not null,
    status varchar(255) not null default 'NAO_RESPONDIDO',
    autor bigint not null,
    curso varchar(100) not null,
    respostas bigint,

    primary key(id),
    foreign key(autor) references usuario(id)
);