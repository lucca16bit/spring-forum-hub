package br.com.forumhub.api.dto.topico;

import br.com.forumhub.api.models.entities.Topico;
import br.com.forumhub.api.models.entities.Usuario;
import br.com.forumhub.api.models.status.Status;

import java.time.LocalDateTime;

public record DetalhesTopicoDto(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        Status status,
        Usuario autor,
        String curso
) {
    public DetalhesTopicoDto(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
