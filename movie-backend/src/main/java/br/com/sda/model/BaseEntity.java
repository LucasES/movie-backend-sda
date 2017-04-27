package br.com.sda.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Classe base das entidades, com atributos comuns a todas elas.
 *
 * @author Lucas Araújo
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 3643938226115217947L;

	@NotNull(message = "Data de criação obrigatória!")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE", updatable = false, nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
	@CreatedDate
	private Date creationDate;

	@NotNull(message = "Data de atualização obrigatória!")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LATEST_MODIFIED", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
	@LastModifiedDate
	private Date updateDate;

	@NotNull(message = "Usuário de criação é obrigatório!")
	@Size(min = 1, max = 50, message = "Usuário de criação deve ter entre 1 a 50 caracteres!")
	@Column(name = "CREATION_USER", length = 50, nullable = false)
	private String creationUser;

	@NotNull(message = "Usuário de atualização é obrigatório")
	@Size(min = 1, max = 50, message = "Usuário de atualização deve ter entre 1 a 50 caracteres!")
	@Column(name = "UPDATE_USER", length = 50, nullable = false)
	private String updateUser;

	public BaseEntity() {
	}

	@PrePersist
	void onPersist() {
		Date now = Calendar.getInstance().getTime();
		creationDate = now;
		updateDate = now;
	}

	@PreUpdate
	void onUpdate() {
		updateDate = Calendar.getInstance().getTime();
	}

	public BaseEntity(String creationUser) {
		this.creationUser = creationUser;
	}

	public BaseEntity(String creationUser, String updateUser) {
		this.creationUser = creationUser;
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public String getCreationUser() {
		return creationUser;
	}

}