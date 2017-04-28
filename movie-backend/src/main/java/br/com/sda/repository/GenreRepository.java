package br.com.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sda.model.Genre;

/**
 * Interface de repositório da entidade Genre.
 * 
 * @author Lucas
 */
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
