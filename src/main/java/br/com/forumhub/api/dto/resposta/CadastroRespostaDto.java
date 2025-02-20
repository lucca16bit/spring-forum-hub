package br.com.forumhub.api.dto.resposta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroRespostaDto(
        @NotBlank
        String mensagem,

        @NotNull
        Long topicoId,

        @NotNull
        Long autorId
) {
}
