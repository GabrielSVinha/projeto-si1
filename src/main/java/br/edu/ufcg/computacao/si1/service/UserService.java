package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.ad.SoldAd;
import br.edu.ufcg.computacao.si1.model.form.UserForm;
import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.security.auth.Token;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    User create(UserForm usuarioForm);

    User getById(Long id);

    Optional<User> getByEmail(String email);

    Collection<User> getAll();

    boolean update(User usuario);

    boolean delete(Long id);

    User getByEmailAndPassword(String email, String password);

    Collection<SoldAd> salesNotifications(Long id);
}
