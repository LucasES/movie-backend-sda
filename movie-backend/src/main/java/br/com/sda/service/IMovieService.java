package br.com.sda.service;

import java.util.List;

import br.com.sda.model.Movie;

/**
 * Interface de serviço para manipulação de dados da classe Movie. 
 * 
 * @author Lucas Araújo
 */
public interface IMovieService {

	/**
	 * Retorna a lista com objetos do tipo Movie.
	 * 
	 * @return lista de Movie.
	 */
	public List<Movie> findAll();
	
	/**
	 * Retorna um objeto do tipo Movie pelo id fornecido.
	 * 
	 * @param id
	 * @return objeto do tipo Movie.
	 */
	public Movie findById(Long id);
	
	/**
	 * Persiste um objeto do tipo Movie.
	 * 
	 * @param actor
	 * @return objeto do tipo Movie criado.
	 */
	public Movie save(Movie movie);
	
	/**
	 * Atualiza um objeto do tipo Movie.
	 * 
	 * @param movie
	 * @return objeto do tipo Movie atualizado.
	 */
	public Movie update(Movie movie);
	
	
	/**
	 * Deleta um objeto do tipo Movie pelo id fornecido.
	 * 
	 * @param id
	 */
	public void delete(Long id);
}
