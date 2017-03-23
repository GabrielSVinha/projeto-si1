package br.edu.ufcg.computacao.si1.service.factory;

import br.edu.ufcg.computacao.si1.model.form.UserForm;
import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.model.user.UserType;

public class UsuarioFactory {

    public static User create(UserForm form){
        User user = null;

        switch (form.getType()){
            case COMPANY:
                user = new User(form.getName(), form.getEmail(), form.getPassword(), UserType.COMPANY);
                break;
            case INDIVIDUAL:
                user = new User(form.getName(), form.getEmail(), form.getPassword(), UserType.INDIVIDUAL);
                break;
        }
        return user;
    }

}
