package br.com.sda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sda.model.Movie;
import br.com.sda.service.IMovieService;

/**
 * Controlador responsável em consumir e fornecer dados do client via JSON.
 * 
 * @author lucas.araujo
 */
@RestController
@RequestMapping("/sda/filme/")
public class MovieController {

	@Autowired
	private IMovieService service;
	
	/**
	 * Lista todos os filmes do sistema.
	 * 
	 * @return Se executado com sucesso, devolve uma respota HTTP com a lista de filmes
   	 *         e status 200.
	 */
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> findAll() {
        List<Movie> movieList = service.findAll();
        
        if(movieList.isEmpty()){
            return new ResponseEntity<List<Movie>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
    }
  
	/**
	 * Lista o filme por id.
	 * 
	 * @return Se executado com sucesso, devolve uma respota HTTP com o filme
   	 *         e status 200.
	 */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getUser(@PathVariable("id") long id) {
    	Movie movie = service.findById(id);
        
        if (movie == null) {
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
    
    /**
   	 * Salva um filme.
   	 * 
   	 * @param id
   	 * @param requestMovie
   	 * @return Se executado com sucesso, devolve uma respota HTTP com o filme
   	 *         e status 200.
   	 */
    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Movie> save(@RequestBody Movie requestMovie){
    	Movie movie = service.save(requestMovie);
		
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
    
    /**
	 * Atualiza um filme.
	 * 
	 * @param id
	 * @param requestMovie
	 * @return Se executado com sucesso, devolve uma respota HTTP com o filme
	 *         e status 200.
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Movie> update(@PathVariable int id, @RequestBody Movie requestMovie) {
		requestMovie.setId(Long.valueOf(id));

		Movie movie = service.update(requestMovie);

		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}
	
	/**
	 * Remove um filme por id.
	 * 
	 * @return Se executado com sucesso, devolve uma respota HTTP status 200.
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
