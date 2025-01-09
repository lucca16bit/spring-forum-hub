package br.com.forumhub.api.dto.security;

public record AuthDto(
        String email,
        String senha
) {
}
