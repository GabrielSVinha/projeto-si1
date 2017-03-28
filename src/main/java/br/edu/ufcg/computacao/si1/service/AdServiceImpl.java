package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.ad.SoldAd;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.repository.AdRepository;
import br.edu.ufcg.computacao.si1.repository.SoldRepository;
import br.edu.ufcg.computacao.si1.repository.UserRepository;
import br.edu.ufcg.computacao.si1.service.factory.AdFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AdServiceImpl implements AdService {
    //TODO add validity checks

    private AdRepository adRepository;

    private UserRepository userRepository;

    private SoldRepository soldRepository;

    @Autowired
    private AdFactory factory;

    @Autowired
    public AdServiceImpl(AdRepository adRepository, UserRepository userRepository, SoldRepository soldRepository) {
        this.adRepository = adRepository;
        this.userRepository = userRepository;
        this.soldRepository = soldRepository;
    }

    public AdRepository getAdRepository(){
        return this.adRepository;
    }

    public Collection<Ad> getAnunciosDoUsuario(){return null;}

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
        /*aqui recuperamos o anuncio pelo seu id*/
        return adRepository.findOne(id);
    }

    @Override
    public Collection<Ad> get(String tipo) {

        /*pegamos aqui todos os anuncios, mas retornamos os anuncios por tipo
        * filtrando o tipo, pelo equals, retornando um arrayLista*/
        return adRepository.findAll().stream()
                .filter(anuncio -> anuncio.getType().equals(tipo))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<Ad> getAll() {
        /*aqui retornamos todos os anuncios, sem distincao*/

        return adRepository.findAll();
    }

    @Override
    public boolean update(Ad anuncio) {
        /*a atualizacao do anuncio eh feita apenas se o anuncio ja existir*/
        if (adRepository.exists(anuncio.getId())) {
            adRepository.save(anuncio);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        /*aqui se apaga o anuncio se ele existir*/


        if (adRepository.exists(id)) {
            adRepository.delete(id);
            return true;
        }
        return false;
    }

    private Collection<Ad> getByDate(String date) {

        return adRepository.findAll().stream()
                .filter(anuncio -> anuncio.getCreationDate().toString().contains(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Collection<Ad> getByUser(String username) {
        /*
        aqui filtramos os anuncios pelo usuario
         */
        return adRepository.findAll().stream()
                .filter(anuncio -> anuncio.getUser().getId().equals(userRepository.findByName(username).getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Collection<Ad> getByType(String type) {
        return adRepository.findAll().stream()
                .filter(anuncio -> anuncio.getType().name().equalsIgnoreCase(type))
                .collect(Collectors.toCollection(ArrayList::new));
    }

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