package br.com.forumhub.api.dto.topico;

import br.com.forumhub.api.models.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroTopicoDto(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        Usuario autor,

        @NotBlank
        String curso) {
}
