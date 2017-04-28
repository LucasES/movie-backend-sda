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

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
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

	private static final long serialVersionUID = 4673266351142021796L;

	@NotNull(message = "Data de criação obrigatória!")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CRIACAO", updatable = false, nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
	@CreatedDate
	private Date creationDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ULTIMA_MODIFICACAO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
	@LastModifiedDate
	private Date updateDate;

	@NotNull(message = "Usuário de criação é obrigatório!")
	@Size(min = 1, max = 50, message = "Usuário de criação deve ter entre 1 a 50 caracteres!")
	@Column(name = "USUARIO_CRIACAO", length = 50, nullable = false)
	@CreatedBy
	private String creationUser;

	@Size(min = 1, max = 50, message = "Usuário de atualização deve ter entre 1 a 50 caracteres!")
	@Column(name = "USUARIO_MODIFICACAO", length = 50)
	@LastModifiedBy
	private String updateUser;

	public BaseEntity() {
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}