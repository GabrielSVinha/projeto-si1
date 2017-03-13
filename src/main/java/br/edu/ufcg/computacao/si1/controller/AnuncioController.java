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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@Controller
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

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Anuncio> cadastroAnuncio(@Valid AnuncioForm anuncioForm, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<Anuncio>(HttpStatus.BAD_REQUEST);
        }

        Anuncio anuncio = this.anuncioService.create(anuncioForm);

        return new ResponseEntity<Anuncio>(anuncioService.create(anuncioForm), HttpStatus.OK);
    }


}
