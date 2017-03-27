package br.edu.ufcg.computacao.si1.repository;

import br.edu.ufcg.computacao.si1.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findByEmail(String email);

    User findByName(String username);

    User findByEmailAndPassword(String email, String password);
}
