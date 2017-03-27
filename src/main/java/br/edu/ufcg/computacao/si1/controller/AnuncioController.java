package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioServiceImpl anuncioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<Anuncio>> getAllAnuncios(){
        return new ResponseEntity<Collection<Anuncio>>(anuncioService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Collection<Anuncio>> getUserAnuncios(@RequestParam(value="user") String user){
        return new ResponseEntity<Collection<Anuncio>>(anuncioService.getByUser(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Anuncio> deleteAnuncio(@PathVariable long id){
        if(anuncioService.delete(id)){
            return new ResponseEntity<Anuncio>(HttpStatus.OK);
        }
        return new ResponseEntity<Anuncio>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Anuncio> cadastroAnuncio(@RequestBody AnuncioForm anuncioForm){
        if(this.anuncioService.create(anuncioForm) == null){
            return new ResponseEntity<Anuncio>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Anuncio>(HttpStatus.OK);
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public ResponseEntity<Collection<Anuncio>> getAnunciosByDate(@RequestParam(value="date") String date){
        return new ResponseEntity<Collection<Anuncio>>(anuncioService.getByDate(date), HttpStatus.OK);
    }
}
