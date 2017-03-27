package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.service.AdService;
import br.edu.ufcg.computacao.si1.service.AdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/anuncios")
public class AdController {

    @Autowired
    private AdServiceImpl anuncioService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAllAnuncios(){
        return new ResponseEntity<Collection<Ad>>(anuncioService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getUserAnuncios(@RequestParam(value="user") String user){
        return new ResponseEntity<Collection<Ad>>(anuncioService.getByUser(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ad> deleteAnuncio(@PathVariable long id){
        if(anuncioService.delete(id)){
            return new ResponseEntity<Ad>(HttpStatus.OK);
        }
        return new ResponseEntity<Ad>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Ad> cadastroAnuncio(@RequestBody AdForm anuncioForm){
        if(this.anuncioService.create(anuncioForm) == null){
            return new ResponseEntity<Ad>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Ad>(HttpStatus.OK);
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAnunciosByDate(@RequestParam(value="date") String date){
        return new ResponseEntity<Collection<Ad>>(anuncioService.getByDate(date), HttpStatus.OK);
    }

    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAnunciosByType(@RequestParam(value="type") String type){
        return new ResponseEntity<Collection<Ad>>(anuncioService.getByType(type), HttpStatus.OK);
    }
}
