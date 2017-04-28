package br.com.sda.model;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Entidade responsável pelos filmes do sistema.
 * 
 * @author lucas.araujo
 */
@Entity
@Table(name = "FILME")
public class Movie extends BaseEntity{
	
	private static final long serialVersionUID = 1519935778895718785L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GENERO_ID")
	private Genre genre;
	
	@NotNull(message = "O título é obrigatório!")	
	@Column(name = "TITULO", nullable=false)
	private String title;
	
	@Column(name = "ESTUDIO")
	private String studio;
	
	@NotNull(message = "Data de lançamento obrigatória!")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_LANCAMENTO")
	private Date releaseDate;
		
	@Column(name = "CLASSIFICACAO")
	private Integer rating;
	
	@Column(name = "IMDB_CLASSIFICACAO")
	private Double imdbRating;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "FILME_ATOR", joinColumns = { @JoinColumn(name = "FILME_ID") }, inverseJoinColumns = { @JoinColumn(name = "ATOR_ID") })
	private Set<Actor> actors = new HashSet<Actor>();

	public Movie() {
	}

	public Movie(Integer id, Genre genre, String title, String studio, Date releaseDate, Integer rating,
			Double imdbRating, Set<Actor> actors) {
		this.id = id;
		this.genre = genre;
		this.title = title;
		this.studio = studio;
		this.releaseDate = releaseDate;
		this.rating = rating;
		this.imdbRating = imdbRating;
		this.actors = actors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Double getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
	
}
