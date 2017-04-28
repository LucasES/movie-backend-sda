package br.com.sda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sda.model.Actor;
import br.com.sda.service.IActorService;

/**
 * Controlador responsável em consumir e fornecer dados do client via JSON.
 * 
 * @author lucas.araujo
 */
@RestController
@RequestMapping("/sda/ator/")
public class ActorController {
	
	@Autowired
	private IActorService service;
	
	/**
	 * Lista todos os atores do sistema.
	 * 
	 * @return Se executado com sucesso, devolve uma respota HTTP com a lista de atores
   	 *         e status 200.
	 */
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Actor>> findAll() {
        List<Actor> actorList = service.findAll();
        
        if(actorList.isEmpty()){
            return new ResponseEntity<List<Actor>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Actor>>(actorList, HttpStatus.OK);
    }
  
	/**
	 * Lista um ator por id.
	 * 
	 * @return Se executado com sucesso, devolve uma respota HTTP com o ator
   	 *         e status 200.
	 */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Actor> findById(@PathVariable("id") long id) {
        Actor actor = service.findById(id);
        
        if (actor == null) {
            return new ResponseEntity<Actor>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Actor>(actor, HttpStatus.OK);
	}

}
