package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.repository.AdRepository;
import br.edu.ufcg.computacao.si1.repository.UserRepository;
import br.edu.ufcg.computacao.si1.service.factory.AdFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class AdServiceImpl implements AnuncioService {
    //TODO add validity checks

    private AdRepository anuncioRepository;
    private UserRepository usuarioRepository;

    @Autowired
    private AdFactory factory;

    @Autowired
    public AdServiceImpl(AdRepository anuncioRepository, UserRepository userRepository) {
        this.anuncioRepository = anuncioRepository;
        this.usuarioRepository = userRepository;
    }

    public AdRepository getAnuncioRepository(){
        return this.anuncioRepository;
    }

    public Collection<Ad> getAnunciosDoUsuario(){return null;}

    @Override
    public Ad create(AdForm form) {
        Ad anuncio = factory.create(form);
        if(anuncio != null){
            anuncioRepository.save(anuncio);
            return anuncio;
        }
        return null;
    }

    @Override
    public Ad getById(Long id) {
        /*aqui recuperamos o anuncio pelo seu id*/
        return anuncioRepository.findOne(id);
    }

    @Override
    public Collection<Ad> get(String tipo) {

        /*pegamos aqui todos os anuncios, mas retornamos os anuncios por tipo
        * filtrando o tipo, pelo equals, retornando um arrayLista*/
        return anuncioRepository.findAll().stream()
                .filter(anuncio -> anuncio.getType().equals(tipo))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<Ad> getAll() {
        /*aqui retornamos todos os anuncios, sem distincao*/

        return anuncioRepository.findAll();
    }

    @Override
    public boolean update(Ad anuncio) {
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
    public Collection<Ad> getByDate(String date) {

        return anuncioRepository.findAll().stream()
                .filter(anuncio -> anuncio.getCreationDate().toString().contains(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<Ad> getByUser(String username) {
        /*
        aqui filtramos os anuncios pelo usuario
         */
        return anuncioRepository.findAll().stream()
                .filter(anuncio -> anuncio.getUser().equals(usuarioRepository.findByName(username)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<Ad> getByType(String type) {
        return anuncioRepository.findAll().stream()
                .filter(anuncio -> anuncio.getType().equals(type))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}