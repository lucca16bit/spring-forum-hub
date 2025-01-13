package br.com.forumhub.api.repositories;

import br.com.forumhub.api.models.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
