package br.com.forumhub.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "curso")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;
}
