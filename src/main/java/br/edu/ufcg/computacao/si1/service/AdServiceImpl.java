package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.ad.SoldAd;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.repository.AdRepository;
import br.edu.ufcg.computacao.si1.repository.SoldRepository;
import br.edu.ufcg.computacao.si1.repository.UserRepository;
import br.edu.ufcg.computacao.si1.service.factory.AdFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SoldRepository soldRepository;

    @Autowired
    private AdFactory factory;

    @Override
    public Ad create(AdForm form) {
        Ad anuncio = factory.create(form);
        if(anuncio != null){
            adRepository.save(anuncio);
            return anuncio;
        }
        return null;
    }

    @Override
    public Ad getById(Long id) {
        return adRepository.findOne(id);
    }

    @Override
    public Collection<Ad> getAll() {
        return adRepository.findAll();
    }

    @Override
    public boolean update(Ad ad) {
        if (adRepository.exists(ad.getId())) {
            adRepository.save(ad);
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
    public List<Ad> getByDate(String dateStr) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Date date = null;

        try {
            date = format.parse(dateStr);
        } catch (Exception e) {
            return new ArrayList<>();
        }

        if (date == null) {
            return new ArrayList<>();
        }

        return adRepository.findByCreationDate(date);
    }

    @Override
    public Collection<Ad> getByUser(String username) {
        User user = userRepository.findByName(username);

        return adRepository.findByOwner(user);
    }

    @Override
    public Collection<Ad> getByType(String type) {
        return adRepository.findAll().stream()
                .filter(ad -> ad.getType().name().equalsIgnoreCase(type))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<Ad> search(String searchContent, String searchType) {
        if (searchType.equals("user")) {
            return this.getByUser(searchContent);
        } else if (searchType.equals("date")) {
            return this.getByDate(searchContent);
        } else if (searchType.equals("type")) {
            return this.getByType(searchContent);
        }

        throw new RuntimeException("Parametro de busca invalido");
    }

    @Override
    public boolean sellAd(Long id, String time){
        Ad ad = this.adRepository.findOne(id);
        if(ad == null){
            return false;
        }
        SoldAd sold = new SoldAd(ad.getTitle(), ad.getUser().getId());
        soldRepository.save(sold);
        adRepository.delete(ad);
        return true;
    }

}