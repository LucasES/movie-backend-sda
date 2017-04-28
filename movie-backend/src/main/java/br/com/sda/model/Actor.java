package br.com.sda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entidade responsável pelos atores dos filmes.
 * 
 * @author lucas.araujo
 */
@Entity
@Table(name = "ATOR")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "O nome é obrigatório!")	
	@Column(name = "NOME", nullable=false)
	private String name;
	
	public Actor() {
	}

	public Actor(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
