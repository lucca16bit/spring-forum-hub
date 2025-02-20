package br.com.forumhub.api.controllers;

import br.com.forumhub.api.dto.resposta.CadastroRespostaDto;
import br.com.forumhub.api.dto.resposta.DetalhesRespostaDto;
import br.com.forumhub.api.models.entities.Resposta;
import br.com.forumhub.api.repositories.RespostaRepository;
import br.com.forumhub.api.repositories.TopicoRepository;
import br.com.forumhub.api.repositories.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/topicos/{topicoId}/respostas")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {
    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarResposta(@PathVariable Long topicoId,
                                            @RequestBody @Valid CadastroRespostaDto dados) {
        var topico = topicoRepository.findById(topicoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico não encontrado"));
        var autor = usuarioRepository.findById(dados.autorId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        var resposta = new Resposta(dados.mensagem(), topico, autor, false);
        respostaRepository.save(resposta);

        return ResponseEntity.status(HttpStatus.CREATED).body(new DetalhesRespostaDto(resposta));
    }
}
