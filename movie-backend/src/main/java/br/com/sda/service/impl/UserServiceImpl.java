package br.com.sda.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.sda.model.User;
import br.com.sda.repository.RoleRepository;
import br.com.sda.repository.UserRepository;
import br.com.sda.service.IUserService;

/**
 * Classe responsável em fornecer serviços para manipulação de dados da classe Actor.
 * 
 * @author Lucas Araújo
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
    private RoleRepository roleRepository;
    
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public User save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        user.setCreationDate(new Date());
        user.setCreationUser(user.getName());
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		
		if(!(repository.exists(user.getId()))) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(user);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);		
	}

	@Override
	public User findByUsername(String username) {
		return repository.findByUsername(username);
	}

}
