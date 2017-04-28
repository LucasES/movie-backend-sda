package br.com.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sda.model.User;

/**
 * Interface de repositório da entidade User.
 * 
 * @author Lucas
 */
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByLogin(String login);
}
