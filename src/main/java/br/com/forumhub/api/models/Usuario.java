package br.com.forumhub.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @ManyToOne
    @JoinColumn(name = "perfis", nullable = false)
    private Perfil perfil;
}
