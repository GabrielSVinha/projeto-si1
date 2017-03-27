package br.edu.ufcg.computacao.si1.service.factory;

import br.edu.ufcg.computacao.si1.model.ad.*;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AdFactory {

    @Autowired
    private UserRepository userRepository;

    public Ad create(AdForm form) {
        switch (form.getType()) {
            case FURNITURE:
                return new Ad(form.getTitle(),
                                        new Date(),
                                        form.getPrice(),
                                        AdType.FURNITURE,
                                        userRepository.findOne(form.getUserId()));

            case REALTY:
                return new Ad(form.getTitle(),
                                         new Date(),
                                         form.getPrice(),
                                         AdType.REALTY,
                                         userRepository.findOne(form.getUserId()));

            case JOB:
                return new Ad(form.getTitle(),
                                          new Date(),
                                          form.getPrice(),
                                          AdType.JOB,
                                          userRepository.findOne(form.getUserId())) ;

            default:
                break;
        }
        return null;
    }

}
