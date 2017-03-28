package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.model.user.User;

import java.util.Collection;
import java.util.Optional;

public interface AdService {

    Ad create(AdForm anuncio);

    Ad getById(Long id);

    Collection<Ad> get(String tipo);

    Collection<Ad> getAll();

    Collection<Ad> getByUser(String username);

    boolean update(Ad anuncio);

    boolean delete(Long id);

    Collection<Ad> getByDate(String date);

    Collection<Ad> getByType(String type);

    boolean sellAd(Long id, String time);
}
