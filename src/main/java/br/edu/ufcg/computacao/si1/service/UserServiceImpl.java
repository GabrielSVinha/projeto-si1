package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.form.UserForm;
import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.repository.UserRepository;
import br.edu.ufcg.computacao.si1.security.auth.Token;
import br.edu.ufcg.computacao.si1.service.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Configurable
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(UserForm usuarioForm) {
        User usuario = UserFactory.create(usuarioForm);

        return userRepository.save(usuario);
    }

    @Override
    public User getById(Long id) {
        return (userRepository.findOne(id));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean update(User usuario) {
        if (userRepository.exists(usuario.getId())) {
            userRepository.save(usuario);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (userRepository.exists(id)) {
            userRepository.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
