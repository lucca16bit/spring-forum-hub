package br.com.forumhub.api.controllers;

import br.com.forumhub.api.dto.topico.AtualizarTopicoDto;
import br.com.forumhub.api.dto.topico.CadastroTopicoDto;
import br.com.forumhub.api.dto.topico.DetalhesTopicoDto;
import br.com.forumhub.api.dto.topico.ListagemTopicosDto;
import br.com.forumhub.api.models.entities.Topico;
import br.com.forumhub.api.repositories.TopicoRepository;
import br.com.forumhub.api.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid CadastroTopicoDto dados, UriComponentsBuilder builder) {
        var topico = new Topico(dados, usuarioRepository);
        repository.save(topico);

        var uri = builder.path("/topicos/{id}")
                .buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesTopicoDto(topico));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemTopicosDto>> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC) Pageable paginacao) {
        var page = repository.findAll(paginacao)
                .map(ListagemTopicosDto::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id) {
        var topico = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do tópico não existe"));

        return ResponseEntity.ok(new DetalhesTopicoDto(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico(@RequestBody @Valid AtualizarTopicoDto dados) {
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInfo(dados);

        return ResponseEntity.ok(new DetalhesTopicoDto(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTopico(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id do tópico não existe");
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
