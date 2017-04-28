package br.com.sda.service;

import java.util.List;

import br.com.sda.model.Role;

public interface IRoleService {

	/**
	 * Retorna a lista de objetos do tipo Role.
	 * 
	 * @return lista com objetos do tipo Role.
	 */
	public List<Role> findAll();
}
