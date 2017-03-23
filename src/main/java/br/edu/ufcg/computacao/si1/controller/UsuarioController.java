package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.form.UsuarioForm;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<Usuario>> getAllUsuarios() {
        return new ResponseEntity<Collection<Usuario>>(usuarioService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> getById(@PathVariable long id) {
        return new ResponseEntity<Usuario>(usuarioService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Usuario> cadastroUsuario(@RequestBody UsuarioForm usuarioForm) {
        if (this.usuarioService.create(usuarioForm) == null) {
            return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Usuario>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable long id) {
        if (usuarioService.delete(id)) {
            return new ResponseEntity<Usuario>(HttpStatus.OK);
        }

        return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
    }
}
