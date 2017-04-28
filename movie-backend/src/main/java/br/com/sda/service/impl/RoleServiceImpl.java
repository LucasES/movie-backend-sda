package br.com.sda.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sda.model.Role;
import br.com.sda.repository.RoleRepository;
import br.com.sda.service.IRoleService;

/**
 * Classe responsável em fornecer serviços para manipulação de dados da classe Actor.
 * 
 * @author Lucas Araújo
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private RoleRepository repository;
	
	@Override
	public List<Role> findAll() {
		return repository.findAll();
	}

	
}
