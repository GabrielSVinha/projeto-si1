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

    public  UsuarioEmpresa(String nome, String email, String senha){
        super(nome, email, senha, "COMPANY");
    }

}
