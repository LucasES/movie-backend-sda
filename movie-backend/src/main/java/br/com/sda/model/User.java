package br.com.sda.model;

import java.util.Collection;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entidade responsável pelos usuários do sistema.
 * 
 * @author lucas.araujo
 */
@Entity
@Table(name = "USUARIO")
public class User extends BaseEntity implements UserDetails {
	

	private static final long serialVersionUID = 1030725599920704230L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "O nome é obrigatório")
	@NotEmpty
	@Column(name = "NOME", nullable = false)
	private String name;

	@NotEmpty
	@Size(min = 4, max = 32, message = "O username deve ter entre 4 a 32 carácteres!")
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;

	@NotEmpty
	@Column(name = "SENHA")
	private String password;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USUARIO_PAPEL", joinColumns = { @JoinColumn(name = "USUARIO_ID") }, inverseJoinColumns = { @JoinColumn(name = "PAPEL_ID") })
	private Set<Role> roles = new HashSet<Role>();

	public User() {
	}

	public User(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.roles = user.getRoles();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
