package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.form.UserForm;
import br.edu.ufcg.computacao.si1.model.user.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    User create(UserForm usuarioForm);

    User getById(Long id);

    Optional<User> getByEmail(String email);

    Collection<User> getAll();

    boolean update(User usuario);

    boolean delete(Long id);
}
