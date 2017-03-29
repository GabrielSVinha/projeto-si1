package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.model.user.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AdService {

    Ad create(AdForm anuncio);

    Ad getById(Long id);

    Collection<Ad> getAll();

    boolean update(Ad anuncio);

    boolean delete(Long id);

    Collection<Ad> getByUser(String username);

    Collection<Ad> getByType(String type);

    List<Ad> getByDate(String dateStr);

    Collection<Ad> search(String searchContent, String searchType);

    boolean sellAd(Long id, String time);
}
