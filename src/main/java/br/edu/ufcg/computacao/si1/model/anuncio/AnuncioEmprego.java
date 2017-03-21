package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by gabriel on 12/03/17.
 */
@Entity
public class AnuncioEmprego extends Anuncio {

    public AnuncioEmprego(String title, Date creationDate, double price, String note, String type, Usuario owner) {
        super(title, creationDate, price, note, type, owner);
    }

    AnuncioEmprego(){
        super();
    }
}
