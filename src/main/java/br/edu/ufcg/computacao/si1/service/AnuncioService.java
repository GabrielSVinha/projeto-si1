package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Marcus Oliveira on 28/12/16.
 */
public interface AnuncioService {

    Anuncio create(AnuncioForm anuncio);

    Anuncio getById(Long id);

    Collection<Anuncio> get(String tipo);

    Collection<Anuncio> getAll();

    Collection<Anuncio> getByUser(String username);

    boolean update(Anuncio anuncio);

    boolean delete(Long id);

    Collection<Anuncio> getByDate(String date);

    Collection<Anuncio> getByType(String type);
}
