package br.com.forumhub.api.dto.resposta;

import br.com.forumhub.api.models.entities.Resposta;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DetalhesRespostaDto(
        Long id,
        String mensagem,
        Long topicoId,
        Long autorId,
        boolean solucao,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCriacao
) {
    public DetalhesRespostaDto(Resposta resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getTopico().getId(),
                resposta.getAutor().getId(),
                resposta.isSolucao(),
                resposta.getDataCriacao()
        );
    }
}
