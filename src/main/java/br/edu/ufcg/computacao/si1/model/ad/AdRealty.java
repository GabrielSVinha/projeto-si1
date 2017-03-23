package br.edu.ufcg.computacao.si1.model.ad;

import br.edu.ufcg.computacao.si1.model.user.User;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by gabriel on 12/03/17.
 */
@Entity
public class AdRealty extends Ad {

    public AdRealty(String title, Date creationDate, double price, String note, String type, User owner) {
        super(title, creationDate, price, note, type, owner);
    }

    AdRealty(){
        super();
    }
}
