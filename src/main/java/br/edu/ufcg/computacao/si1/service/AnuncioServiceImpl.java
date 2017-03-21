package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import br.edu.ufcg.computacao.si1.service.factory.AnuncioFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Marcus Oliveira on 28/12/16.
 */
@Service
public class AnuncioServiceImpl implements AnuncioService {
    //TODO add validity checks

    private AnuncioRepository anuncioRepository;

    @Autowired
    private AnuncioFactory factory;

    @Autowired
    public AnuncioServiceImpl(AnuncioRepository anuncioRepository) {
        this.anuncioRepository = anuncioRepository;
    }

    public AnuncioRepository getAnuncioRepository() {
        return this.anuncioRepository;
    }

    public Collection<Anuncio> getAnunciosDoUsuario() {
        return null;
    }

    @Override
    public Anuncio create(AnuncioForm form) {
        Anuncio anuncio = factory.create(form);
        if (anuncio != null) {
            anuncioRepository.save(anuncio);
            return anuncio;
        }
        return null;
    }

    @Override
    public Anuncio getById(Long id) {
        /*aqui recuperamos o anuncio pelo seu id*/
        return anuncioRepository.findOne(id);
    }

    @Override
    public Collection<Anuncio> get(String tipo) {

        /*pegamos aqui todos os anuncios, mas retornamos os anuncios por tipo
        * filtrando o tipo, pelo equals, retornando um arrayLista*/
        return anuncioRepository.findAll().stream()
                .filter(anuncio -> anuncio.getType().equals(tipo))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<Anuncio> getAll() {
        /*aqui retornamos todos os anuncios, sem distincao*/

        return anuncioRepository.findAll();
    }

    @Override
    public boolean update(Anuncio anuncio) {
        /*a atualizacao do anuncio eh feita apenas se o anuncio ja existir*/
        if (anuncioRepository.exists(anuncio.getId())) {
            anuncioRepository.save(anuncio);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        /*aqui se apaga o anuncio se ele existir*/


        if (anuncioRepository.exists(id)) {
            anuncioRepository.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public Collection<Anuncio> getByUser(String username) {
        /*
        aqui filtramos os anuncios pelo usuario
         */
        return anuncioRepository.findAll().stream()
                .filter(anuncio -> anuncio.getUser().getUsername().equals(username))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
