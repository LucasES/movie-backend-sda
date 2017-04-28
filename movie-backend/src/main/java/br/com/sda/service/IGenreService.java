package br.com.sda.service;

import java.util.List;

import br.com.sda.model.Genre;

public interface IGenreService {

	/**
	 * Retorna a lista de objetos do tipo Genre.
	 * 
	 * @return lista com objetos do tipo Genre.
	 */
	public List<Genre> findAll();
	
	/**
	 * Retorna a um objeto do tipo Genre pelo ID fornecido.
	 * 
	 * @param id
	 * @return objeto do tipo Genre.
	 */
	public Genre findById(Long id);
}
