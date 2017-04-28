package br.com.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sda.model.Movie;

/**
 * Interface de repositório da entidade Movie.
 * 
 * @author Lucas
 */
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
