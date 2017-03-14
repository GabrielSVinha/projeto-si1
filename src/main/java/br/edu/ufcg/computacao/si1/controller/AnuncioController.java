package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.form.AnuncioForm;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import br.edu.ufcg.computacao.si1.service.AnuncioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value = "/api/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioServiceImpl anuncioService;

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Anuncio>> getUserAnuncio(@RequestParam String user){
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<Anuncio>> getAllAnuncios(){
        return new ResponseEntity<Collection<Anuncio>>(anuncioService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Anuncio> deleteAnuncio(@PathVariable long id){
        if(anuncioService.delete(id)){
            return new ResponseEntity<Anuncio>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Anuncio>(HttpStatus.OK);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Anuncio> cadastroAnuncio(@RequestParam(required = true) String titulo,
                                                   @RequestParam(required = true) String preco,
                                                   @RequestParam(required = true) String tipo,
                                                   @RequestParam("user_id") Long user_id){
        AnuncioForm anuncioForm = new AnuncioForm(titulo.substring(1, titulo.length()-1),
                                                  Double.parseDouble(preco),
                                                  tipo.substring(1, tipo.length()-1),
                                                  (long) user_id);

        if(this.anuncioService.create(anuncioForm) == null){
            return new ResponseEntity<Anuncio>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Anuncio>(anuncioService.create(anuncioForm), HttpStatus.OK);
    }
}
