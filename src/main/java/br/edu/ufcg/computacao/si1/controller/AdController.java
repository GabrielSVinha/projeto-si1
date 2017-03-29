package br.edu.ufcg.computacao.si1.controller;

import br.edu.ufcg.computacao.si1.model.ad.Ad;
import br.edu.ufcg.computacao.si1.model.form.AdForm;
import br.edu.ufcg.computacao.si1.service.AdServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/ad")
public class AdController {

    @Autowired
    private AdServiceImpl adService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAllAds(){
        return new ResponseEntity<Collection<Ad>>(adService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> searchAnuncios(@QueryParam(value="searchContent") String searchContent, @QueryParam(value="searchType") String searchType){
        return new ResponseEntity<Collection<Ad>>(adService.search(searchContent, searchType), HttpStatus.OK);
        //return Response.status(Response.Status.ACCEPTED).entity(adService.search(searchContent, searchType)).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ad> deleteAd(@PathVariable long id){
        if (adService.delete(id)) {
            return new ResponseEntity<Ad>(HttpStatus.OK);
        }
        return new ResponseEntity<Ad>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Ad> cadastroAnuncio(@RequestBody AdForm anuncioForm) {
        System.out.println(anuncioForm);

        Ad adCriado = adService.create(anuncioForm);

        if (adCriado == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
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
}
