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
        switch (form.getTipo()){
            case "movel":
                return new AnuncioMovel(form.getTitulo(),
                                        new Date(),
                                        form.getPreco(),
                                        null,
                                        "MOVEL",
                                        user.findOne(form.getUser()));

            case "imovel":
                return new AnuncioImovel(form.getTitulo(),
                                         new Date(),
                                         form.getPreco(),
                                         null,
                                         "IMOVEL",
                                         user.findOne(form.getUser()));

            case "emprego":
                return new AnuncioEmprego(form.getTitulo(),
                                          new Date(),
                                          form.getPreco(),
                                          null,
                                          "EMPREGO",
                                          user.findOne(form.getUser())) ;

            default:
                break;
        }
        return null;
    }

}
