package br.com.sda.service;

import java.util.List;

import br.com.sda.model.Actor;

/**
 * Interface de serviço para manipulação de dados da classe Actor. 
 * 
 * @author Lucas
 */
public interface IActorService {

	/**
	 * Retorna a lista com objetos do tipo Actor.
	 * 
	 * @return lista de Actor.
	 */
	public List<Actor> findAll();
	
	/**
	 * Retorna um objeto do tipo Actor pelo id fornecido.
	 * 
	 * @param id
	 * @return objeto do tipo Actor.
	 */
	public Actor findOne(Long id);
	
	/**
	 * Persiste um objeto do tipo Actor.
	 * 
	 * @param actor
	 * @return objeto do tipo Actor criado.
	 */
	public Actor save(Actor actor);
	
	/**
	 * Atualiza um objeto do tipo Actor.
	 * 
	 * @param actor
	 * @return objeto do tipo Actor atualizado.
	 */
	public Actor update(Actor actor);
	
	
	/**
	 * Deleta um objeto do tipo Actor pelo id fornecido.
	 * 
	 * @param id
	 */
	public void delete(Long id);
	
}
