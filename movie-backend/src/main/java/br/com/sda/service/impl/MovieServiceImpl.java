package br.com.sda.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.sda.model.Movie;
import br.com.sda.repository.MovieRepository;
import br.com.sda.service.IMovieService;

/**
 * Classe responsável em fornecer serviços para manipulação de dados da classe Movie.
 * 
 * @author Lucas Araújo
 */
@Service
@Transactional
public class MovieServiceImpl implements IMovieService{

	@Autowired
	private MovieRepository repository;
	
	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public Movie findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Movie save(Movie movie) {
		movie.setCreationDate(new Date());
        movie.setCreationUser("ADMIN");
		return repository.save(movie);
	}

	@Override
	public Movie update(Movie movie) {
		
		if(!(repository.exists(movie.getId()))) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return repository.save(movie);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

}
