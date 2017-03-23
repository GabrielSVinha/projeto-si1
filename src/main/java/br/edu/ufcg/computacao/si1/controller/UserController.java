package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.form.UserForm;
import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.security.auth.Token;
import br.edu.ufcg.computacao.si1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UserController {

    @Autowired
    private UserService usuarioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> getAllUsers() {
        return new ResponseEntity<>(usuarioService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getById(@PathVariable long id) {
        return new ResponseEntity<>(usuarioService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody UserForm userForm) {
        if (this.usuarioService.create(userForm) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        if (usuarioService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Token> login(@RequestBody UserForm userForm) {
        return null;
    }
}
