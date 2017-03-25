package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.form.UserForm;
import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.security.auth.Token;
import br.edu.ufcg.computacao.si1.service.UserService;
import br.edu.ufcg.computacao.si1.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/user", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getById(@PathVariable long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody UserForm userForm) {
        if (this.userService.create(userForm) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        if (userService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Token> login(@RequestBody UserForm userForm) {
        User user = userService.getByEmailAndPassword(userForm.getEmail(), userForm.getPassword());

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(tokenService.createSessionToken(user));
    }
}
