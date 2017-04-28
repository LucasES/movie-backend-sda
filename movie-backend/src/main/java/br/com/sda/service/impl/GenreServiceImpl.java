package br.com.sda.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sda.model.Genre;
import br.com.sda.repository.GenreRepository;
import br.com.sda.service.IGenreRepository;

/**
 * Classe responsável em fornecer serviços para manipulação de dados da classe Genre.
 * 
 * @author Lucas Araújo
 */
@Service
@Transactional
public class GenreServiceImpl implements IGenreRepository{

	@Autowired
	private GenreRepository repository;
	
	@Override
	public List<Genre> findAll() {
		return repository.findAll();
	}

}
