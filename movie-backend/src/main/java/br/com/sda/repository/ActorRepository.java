package br.com.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sda.model.Actor;

/**
 * Interface de repositório da entidade Actor.
 * 
 * @author Lucas
 */
public interface ActorRepository extends JpaRepository<Actor, Long>{

}
