package br.com.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sda.model.Role;

/**
 * Interface de repositório da entidade Role.
 * 
 * @author Lucas
 */
public interface RoleRepository extends JpaRepository<Role, Long>{

}
