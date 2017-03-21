package br.edu.ufcg.computacao.si1.model.usuario;

import javax.persistence.Entity;

/**
 * Created by gabriel on 09/03/17.
 */
@Entity
public class UsuarioEmpresa extends Usuario {

    public UsuarioEmpresa(){
        super();
    }

    public  UsuarioEmpresa(String name, String email, String password){
        super(name, email, password, "COMPANY");
    }

}
