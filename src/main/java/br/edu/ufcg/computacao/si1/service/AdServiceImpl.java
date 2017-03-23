package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.repository.AdRepository;
import br.edu.ufcg.computacao.si1.repository.UserRepository;
import br.edu.ufcg.computacao.si1.service.factory.AnuncioFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Marcus Oliveira on 28/12/16.
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnuncioFactory factory;

    public Collection<Ad> getAnunciosDoUsuario() {
        return null;
    }

    @Override
    public Ad create(AdForm form) {
        Ad anuncio = factory.create(form);
        if (anuncio != null) {
            adRepository.save(anuncio);
            return anuncio;
        }
        return null;
    }

    @Override
    public Ad getById(Long id) {
        /*aqui recuperamos o anuncio pelo seu id*/
        return adRepository.findOne(id);
    }

    @Override
    public Collection<Ad> getByType(String type) {
        return adRepository.findByType(type);
    }

    @Override
    public Collection<Ad> getAll() {
        return adRepository.findAll();
    }

    @Override
    public boolean update(Ad anuncio) {
        if (adRepository.exists(anuncio.getId())) {
            adRepository.save(anuncio);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (adRepository.exists(id)) {
            adRepository.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public Collection<Ad> getByUser(String username) {
        User user = userRepository.findByName(username);

        return adRepository.findByOwner(user);
    }
}
