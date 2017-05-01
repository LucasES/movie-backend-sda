package br.com.sda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entidade responsável pelos gêneros dos filmes do sistema.
 * 
 * @author lucas.araujo
 */
@Entity
@Table(name = "GENERO")
public class Genre implements Serializable{

	private static final long serialVersionUID = 2471727006630513546L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "O nome é obrigatório!")
	@Column(name = "NOME", nullable = false)
	private String name;

	public Genre() {
	}

	public Genre(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
