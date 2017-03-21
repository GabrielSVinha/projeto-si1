package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.model.form.UsuarioForm;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import br.edu.ufcg.computacao.si1.service.factory.UsuarioFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Configurable
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repo){
        this.usuarioRepository = repo;
    }

    @Override
    public Usuario create(UsuarioForm usuarioForm) {
        Usuario usuario = UsuarioFactory.create(usuarioForm);

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getById(Long id) {
        return (usuarioRepository.findOne(id));
    }

    @Override
    public Optional<Usuario> getByEmail(String email) {
        return Optional.ofNullable(usuarioRepository.findByEmail(email));
    }

    @Override
    public Collection<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public boolean update(Usuario usuario) {
        if (usuarioRepository.exists(usuario.getId())) {
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (usuarioRepository.exists(id)) {
            usuarioRepository.delete(id);
            return true;
        }
        return false;
    }

}
