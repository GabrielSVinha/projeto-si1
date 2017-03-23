package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.model.user.User;

import java.util.Collection;
import java.util.Optional;

public interface AdService {

    Ad create(AdForm ad);

    Ad getById(Long id);

    Collection<Ad> getByType(String tipo);

    Collection<Ad> getAll();

    Collection<Ad> getByUser(String username);

    boolean update(Ad ad);

    boolean delete(Long id);

}
