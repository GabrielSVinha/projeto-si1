package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.repository.AdRepository;
import br.edu.ufcg.computacao.si1.repository.UserRepository;
import br.edu.ufcg.computacao.si1.service.factory.AdFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdFactory factory;

    public Collection<Ad> getAdsFromUser(User user) {
        return adRepository.findByOwner(user);
    }

    @Override
    public Ad create(AdForm form) {
        Ad ad = factory.create(form);
        if (ad != null) {
            adRepository.save(ad);
            return ad;
        }
        return null;
    }

    @Override
    public Ad getById(Long id) {
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
    public Collection<Ad> getByUsername(String username) {
        User user = userRepository.findByName(username);

        return adRepository.findByOwner(user);
    }
}
