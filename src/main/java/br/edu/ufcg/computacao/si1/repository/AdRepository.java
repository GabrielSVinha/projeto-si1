package br.edu.ufcg.computacao.si1.repository;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.ad.AdType;
import br.edu.ufcg.computacao.si1.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

    List<Ad> findByOwner(User user);

    List<Ad> findByType(String type);

    List<Ad> findByCreationDate(Date date);

    List<Ad> findByType(AdType type);
}
