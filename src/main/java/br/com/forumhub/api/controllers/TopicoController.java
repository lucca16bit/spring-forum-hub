package br.com.forumhub.api.controllers;

import br.com.forumhub.api.dto.topico.CadastroTopicoDto;
import br.com.forumhub.api.dto.topico.DetalhesTopicoDto;
import br.com.forumhub.api.models.entities.Topico;
import br.com.forumhub.api.repositories.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid CadastroTopicoDto dados, UriComponentsBuilder builder) {
        var topico = new Topico(dados);
        System.out.println(topico);

        var uri = builder.path("/topicos/{id}")
                .buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesTopicoDto(topico));
    }
}
