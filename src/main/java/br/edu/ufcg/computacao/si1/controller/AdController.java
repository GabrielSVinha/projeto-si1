package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.service.AdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/anuncios")
public class AdController {

    @Autowired
    private AdServiceImpl adService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAllAds(){
        return new ResponseEntity<Collection<Ad>>(adService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAdByUser(@RequestParam(value="user") String user){
        return new ResponseEntity<Collection<Ad>>(adService.getByUser(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ad> deleteAd(@PathVariable long id){
        if(adService.delete(id)){
            return new ResponseEntity<Ad>(HttpStatus.OK);
        }
        return new ResponseEntity<Ad>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Ad> addAdvertisement(@RequestBody AdForm anuncioForm){
        if(this.adService.create(anuncioForm) == null){
            return new ResponseEntity<Ad>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Ad>(HttpStatus.OK);
    }

    @RequestMapping(value = "/sell/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<Ad> sell(@PathVariable long id, @RequestBody String time){
        try{
            if(adService.sellAd(id, time)){
                return new ResponseEntity<Ad>(HttpStatus.OK);
            }else{
                return new ResponseEntity<Ad>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Ad>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAdsByDate(@RequestParam(value="date") String date){
        return new ResponseEntity<Collection<Ad>>(adService.getByDate(date), HttpStatus.OK);
    }

    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAdsByType(@RequestParam(value="type") String type){
        return new ResponseEntity<Collection<Ad>>(adService.getByType(type), HttpStatus.OK);
    }
}
