package br.com.forumhub.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "perfil")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
}
