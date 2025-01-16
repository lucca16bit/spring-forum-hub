package br.com.forumhub.api.dto.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroTopicoDto(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        Long autorId,

        @NotBlank
        String curso) {
}
