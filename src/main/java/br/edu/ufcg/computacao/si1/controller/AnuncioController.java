package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioServiceImpl anuncioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<Anuncio>> getAllAnuncios() {
        return new ResponseEntity<Collection<Anuncio>>(anuncioService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Anuncio>> getUserAnuncios(@RequestParam String user) {
        return new ResponseEntity<Collection<Anuncio>>(anuncioService.getByUser(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Anuncio> deleteAnuncio(@PathVariable long id) {
        if (anuncioService.delete(id)) {
            return new ResponseEntity<Anuncio>(HttpStatus.OK);
        }

        return new ResponseEntity<Anuncio>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Anuncio> cadastroAnuncio(@RequestBody AnuncioForm anuncioForm) {
        if (this.anuncioService.create(anuncioForm) == null) {
            return new ResponseEntity<Anuncio>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Anuncio>(HttpStatus.OK);
    }
}
