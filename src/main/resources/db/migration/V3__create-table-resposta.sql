create table resposta (
    id bigint not null generated by default as identity,
    mensagem text not null,
    topico bigint not null,
    data_criacao timestamp not null,
    autor bigint not null,
    solucao boolean not null,

    primary key(id),
    foreign key(topico) references topico(id),
    foreign key(autor) references usuario(id)
);