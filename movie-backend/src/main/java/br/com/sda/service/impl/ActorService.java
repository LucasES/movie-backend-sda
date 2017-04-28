package br.com.sda.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.sda.model.Actor;
import br.com.sda.repository.ActorRepository;
import br.com.sda.service.IActorService;

/**
 * Classe responsável em fornecer serviços para manipulação de dados da classe Actor.
 * 
 * @author Lucas Araújo
 */
@Service
@Transactional
public class ActorService implements IActorService{

	@Autowired
	private ActorRepository repository;
	
	@Override
	public List<Actor> findAll() {
		return repository.findAll();
	}

	@Override
	public Actor findOne(Long id) {
		return findOne(id);
	}

	@Override
	public Actor save(Actor actor) {
		return repository.save(actor);
	}

	@Override
	public Actor update(Actor actor) {
		if(!(repository.exists(actor.getId()))) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(actor);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

}
