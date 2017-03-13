package br.edu.ufcg.computacao.si1.service.factory;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioEmprego;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioImovel;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioMovel;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by gabriel on 12/03/17.
 */
public class AnuncioFactory {

    @Autowired
    private static UsuarioRepository userRepo;

    public static Anuncio create(AnuncioForm form){
        switch (form.getTipo()){
            case "movel":
                return new AnuncioMovel(form.getTitulo(),
                                        new Date(),
                                        form.getPreco(),
                                        null,
                                        "MOVEL",
                                        userRepo.findOne(form.getUser()));

            case "imovel":
                return new AnuncioImovel(form.getTitulo(),
                                         new Date(),
                                         form.getPreco(),
                                         null,
                                         "IMOVEL",
                                         userRepo.findOne(form.getUser()));

            case "emprego":
                return new AnuncioEmprego(form.getTitulo(),
                                          new Date(),
                                          form.getPreco(),
                                           null,
                                          "EMPREGO",
                                          userRepo.findOne(form.getUser()));

            default:
                break;
        }
        return null;
    }

}
