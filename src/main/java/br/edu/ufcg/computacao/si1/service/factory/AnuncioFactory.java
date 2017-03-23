package br.edu.ufcg.computacao.si1.service.factory;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.ad.AdFurniture;
import br.edu.ufcg.computacao.si1.model.ad.AdJob;
import br.edu.ufcg.computacao.si1.model.ad.AdRealty;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AnuncioFactory {


    @Autowired
    private UserRepository user;

    public Ad create(AdForm form){
        switch (form.getType()){
            case "movel":
                return new AdFurniture(form.getTitle(),
                                        new Date(),
                                        form.getPrice(),
                                        null,
                                        "MOVEL",
                                        user.findOne(form.getUserId()));

            case "imovel":
                return new AdRealty(form.getTitle(),
                                         new Date(),
                                         form.getPrice(),
                                         null,
                                         "IMOVEL",
                                         user.findOne(form.getUserId()));

            case "emprego":
                return new AdJob(form.getTitle(),
                                          new Date(),
                                          form.getPrice(),
                                          null,
                                          "EMPREGO",
                                          user.findOne(form.getUserId())) ;

            default:
                break;
        }
        return null;
    }

}
