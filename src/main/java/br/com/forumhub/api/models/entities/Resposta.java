package br.com.forumhub.api.models.entities;

import br.com.forumhub.api.dto.resposta.CadastroRespostaDto;
import br.com.forumhub.api.repositories.TopicoRepository;
import br.com.forumhub.api.repositories.UsuarioRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "resposta")
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    private boolean solucao;

    public Resposta(@NotBlank String mensagem, Topico topico, Usuario autor, boolean b) {}

    public Resposta(String mensagem, Topico topico, LocalDateTime dataCriacao, Usuario autor, boolean solucao) {
        this.mensagem = mensagem;
        this.topico = topico;
        this.autor = autor;
        this.solucao = solucao;
        this.dataCriacao = dataCriacao;
    }

    public Resposta(CadastroRespostaDto dados, UsuarioRepository usuarioRepository, TopicoRepository topicoRepository) {
        this.mensagem = dados.mensagem();
        this.solucao = false;
        this.dataCriacao = LocalDateTime.now();

        this.autor = usuarioRepository.findById(dados.autorId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não existe"));
        this.topico = topicoRepository.findById(dados.topicoId())
                .orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public boolean isSolucao() {
        return solucao;
    }

    public void setSolucao(boolean solucao) {
        this.solucao = solucao;
    }
}
