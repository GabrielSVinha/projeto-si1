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
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/ad")
public class AdController {

    @Autowired
    private AdServiceImpl adService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAllAnuncios(){
        return new ResponseEntity<Collection<Ad>>(adService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> searchAnuncios(@QueryParam(value="searchContent") String searchContent, @QueryParam(value="searchType") String searchType){
        return new ResponseEntity<Collection<Ad>>(adService.search(searchContent, searchType), HttpStatus.OK);
        //return Response.status(Response.Status.ACCEPTED).entity(adService.search(searchContent, searchType)).build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Ad> deleteAnuncio(@PathVariable long id){
        if(adService.delete(id)){
            return new ResponseEntity<Ad>(HttpStatus.OK);
        }
        return new ResponseEntity<Ad>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public @ResponseBody Response cadastroAnuncio(@RequestBody AdForm anuncioForm){
        Ad adCriado = this.adService.create(anuncioForm);
        if(adCriado == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.CREATED).entity(adCriado).build();
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAnunciosByDate(@RequestParam(value="date") String date){
        return new ResponseEntity<Collection<Ad>>(adService.getByDate(date), HttpStatus.OK);
    }

    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public ResponseEntity<Collection<Ad>> getAnunciosByType(@RequestParam(value="type") String type){
        return new ResponseEntity<Collection<Ad>>(adService.getByType(type), HttpStatus.OK);
    }
}
