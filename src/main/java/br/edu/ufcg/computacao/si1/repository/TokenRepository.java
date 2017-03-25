package br.edu.ufcg.computacao.si1.repository;

import br.edu.ufcg.computacao.si1.security.auth.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
}
