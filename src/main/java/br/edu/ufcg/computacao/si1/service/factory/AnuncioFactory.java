package br.edu.ufcg.computacao.si1.service.factory;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioEmprego;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioImovel;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioMovel;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import br.edu.ufcg.computacao.si1.service.AnuncioService;
import br.edu.ufcg.computacao.si1.service.UsuarioService;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by gabriel on 12/03/17.
 */
@Component
public class AnuncioFactory {


    @Autowired
    private UsuarioRepository user;

    public Anuncio create(AnuncioForm form){
        switch (form.getType()){
            case "movel":
                return new AnuncioMovel(form.getTitle(),
                                        new Date(),
                                        form.getPrice(),
                                        null,
                                        "MOVEL",
                                        user.findOne(form.getUserId()));

            case "imovel":
                return new AnuncioImovel(form.getTitle(),
                                         new Date(),
                                         form.getPrice(),
                                         null,
                                         "IMOVEL",
                                         user.findOne(form.getUserId()));

            case "emprego":
                return new AnuncioEmprego(form.getTitle(),
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
