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

import br.com.sda.model.User;
import br.com.sda.service.IUserService;

/**
 * Controlador responsável em consumir e fornecer dados do client via JSON.
 * 
 * @author lucas.araujo
 */
@RestController
@RequestMapping("/sda/usuario/")
public class UserController {

	@Autowired
	private IUserService service;

	/**
	 * Lista todos os usuários do sistema.
	 * 
	 * @return Se executado com sucesso, devolve uma respota HTTP com a lista de usuários
   	 *         e status 200.
	 */
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
  
	/**
	 * Lista usuário por id.
	 * 
	 * @return Se executado com sucesso, devolve uma respota HTTP com o usuário
   	 *         e status 200.
	 */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        User user = service.findById(id);
        
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<User>(user, HttpStatus.OK);
	}
    
    /**
   	 * Salva um usuário.
   	 * 
   	 * @param id
   	 * @param requestUser
   	 * @return Se executado com sucesso, devolve uma respota HTTP com o usuário
   	 *         e status 200.
   	 */
    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User requestUser){
		User user = service.save(requestUser);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
    
    /**
	 * Atualiza um usuário.
	 * 
	 * @param id
	 * @param requestUser
	 * @return Se executado com sucesso, devolve uma respota HTTP com o usuário
	 *         e status 200.
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@PathVariable int id, @RequestBody User requestUser) {
		requestUser.setId(Long.valueOf(id));

		User user = service.update(requestUser);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/**
	 * Remove um usuário por id.
	 * 
	 * @return Se executado com sucesso, devolve uma respota HTTP status 200.
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
