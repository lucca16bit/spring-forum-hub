package br.com.forumhub.api.controllers;

import br.com.forumhub.api.dto.security.AuthDto;
import br.com.forumhub.api.dto.security.TokenJWTDto;
import br.com.forumhub.api.models.entities.Usuario;
import br.com.forumhub.api.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AuthDto dados) {
        var authToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var auth = manager.authenticate(authToken);

        var tokenJWT = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenJWTDto(tokenJWT));
    }
}
