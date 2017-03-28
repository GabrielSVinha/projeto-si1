package br.edu.ufcg.computacao.si1.repository;

import br.edu.ufcg.computacao.si1.model.ad.SoldAd;
import br.edu.ufcg.computacao.si1.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by gabriel on 27/03/17.
 */
public interface SoldRepository extends JpaRepository<SoldAd, Long> {

    Collection<SoldAd> findByOwner(User user);

}
