package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;

import java.util.Collection;

/**
 * Created by Marcus Oliveira on 28/12/16.
 */
public interface AnuncioService {

    Ad create(AdForm anuncio);

    Ad getById(Long id);

    Collection<Ad> get(String tipo);

    Collection<Ad> getAll();

    Collection<Ad> getByUser(String username);

    boolean update(Ad anuncio);

    boolean delete(Long id);

    Collection<Ad> getByDate(String date);

    Collection<Ad> getByType(String type);
}
