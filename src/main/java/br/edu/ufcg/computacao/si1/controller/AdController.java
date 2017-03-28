package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/ad")
public class AdController {

    @Autowired
    private AdService adService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAllAds() {
        return new ResponseEntity<Collection<Ad>>(adService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getUserAds(@RequestParam String user) {
        return new ResponseEntity<Collection<Ad>>(adService.getByUsername(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ad> deleteAd(@PathVariable long id) {
        if (adService.delete(id)) {
            return new ResponseEntity<Ad>(HttpStatus.OK);
        }

        return new ResponseEntity<Ad>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Ad> registerAd(@RequestBody AdForm anuncioForm) {
        if (this.adService.create(anuncioForm) == null) {
            return new ResponseEntity<Ad>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Ad>(HttpStatus.OK);
    }
}
