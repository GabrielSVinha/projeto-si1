package br.edu.ufcg.computacao.si1.service.factory;

import br.edu.ufcg.computacao.si1.model.form.UsuarioForm;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.model.usuario.UsuarioEmpresa;
import br.edu.ufcg.computacao.si1.model.usuario.UsuarioPessoa;

/**
 * Created by user on 09/03/17.
 */
public class UsuarioFactory {

    public static Usuario create(UsuarioForm form){

        Usuario user = null;

        switch (form.getRole()){
            case 1:
                user = new UsuarioPessoa(form.getNome(), form.getEmail(), form.getSenha());
                break;
            case 2:
                user = new UsuarioEmpresa(form.getNome(), form.getEmail(), form.getSenha());
                break;
        }
        return user;
    }

}
