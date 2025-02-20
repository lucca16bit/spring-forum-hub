package br.com.forumhub.api.repositories;

import br.com.forumhub.api.models.entities.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
