package br.com.sda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sda.model.Genre;
import br.com.sda.service.IGenreService;

/**
 * Controlador responsável em consumir e fornecer dados do client via JSON.
 * 
 * @author lucas.araujo
 */
@RestController
@RequestMapping("/sda/genero/")
public class GenreController {
	
	@Autowired
	private IGenreService service;

	/**
	 * Lista todos os gêneros do sistema.
	 * 
	 * @return Se executado com sucesso, devolve uma respota HTTP com a lista de gêneros
   	 *         e status 200.
	 */
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Genre>> findAll() {
        List<Genre> genreList = service.findAll();
        
        if(genreList.isEmpty()){
            return new ResponseEntity<List<Genre>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Genre>>(genreList, HttpStatus.OK);
    }
  
	/**
	 * Lista o gênero por id.
	 * 
	 * @return Se executado com sucesso, devolve uma respota HTTP com o gênero
   	 *         e status 200.
	 */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Genre> findById(@PathVariable("id") long id) {
        Genre genre = service.findById(id);
        
        if (genre == null) {
            return new ResponseEntity<Genre>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Genre>(genre, HttpStatus.OK);
	}
}
