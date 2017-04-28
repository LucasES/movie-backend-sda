package br.com.sda.service;

import java.util.List;

import br.com.sda.model.User;

public interface IUserService {

	/**
	 * Retorna a lista com objetos do tipo User.
	 * 
	 * @return lista de User.
	 */
	public List<User> findAll();
	
	/**
	 * Retorna um objeto do tipo User pelo id fornecido.
	 * 
	 * @param id
	 * @return objeto do tipo User.
	 */
	public User findOne(Long id);
	
	/**
	 * Persiste um objeto do tipo User.
	 * 
	 * @param user
	 * @return objeto do tipo User criado.
	 */
	public User save(User user);
	
	/**
	 * Atualiza um objeto do tipo User.
	 * 
	 * @param user
	 * @return objeto do tipo User atualizado.
	 */
	public User update(User user);
	
	
	/**
	 * Deleta um objeto do tipo User pelo id fornecido.
	 * 
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * Busca um objeto do tipo User pelo username fornecido.
	 * 
	 * @param username
	 * @return objeto do tipo User.
	 */
	public User findByUsername(String username);
}
