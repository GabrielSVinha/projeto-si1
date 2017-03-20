package br.edu.ufcg.computacao.si1.model.anuncio;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by gabriel on 12/03/17.
 */
@Entity
public class AnuncioImovel extends Anuncio {

    public AnuncioImovel(String titulo, Date dataDeCriacao, double preco, String nota, String tipo, Usuario owner) {
        super(titulo, dataDeCriacao, preco, nota, tipo, owner);
    }

    AnuncioImovel(){
        super();
    }

}
