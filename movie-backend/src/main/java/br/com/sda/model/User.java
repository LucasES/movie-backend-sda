package br.com.sda.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entidade responsável pelos usuários do sistema.
 * 
 * @author lucas.araujo
 */
@Entity
public class User extends BaseEntity{
	
	private static final long serialVersionUID = -9116268797213174728L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull(message = "O nome é obrigatório")
	@NotEmpty
	@Column(name = "NOME", nullable = false)
	private String name;

	@NotEmpty
	@Column(name = "LOGIN", unique = true, nullable = false)
	private String login;

	@NotEmpty
	@Column(name = "SENHA")
	private String password;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<Role>();

	public User() {
	}

	public User(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.roles = user.getRoles();
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
