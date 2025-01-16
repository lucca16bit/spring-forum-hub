package br.com.forumhub.api.dto.topico;

import jakarta.validation.constraints.NotNull;

public record AtualizarTopicoDto(
    @NotNull
    Long id,

    String titulo,
    String mensagem,
    String curso
) {
}
