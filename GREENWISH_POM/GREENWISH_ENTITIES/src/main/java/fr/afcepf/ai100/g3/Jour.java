package fr.afcepf.ai100.g3;
// Generated 28 avr. 2017 11:29:33 by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Jour generated by hbm2java
 */
@Entity
@Table(name = "jour", catalog = "greenwish")
public class Jour implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Integer idjour;
	private Disponibilite disponibilite;
	private String nomjour;
	private List<Horaire> horaires = new ArrayList<>();

	public Jour() {
	}

	public Jour(Disponibilite disponibilite, String nomjour) {
		this.disponibilite = disponibilite;
		this.nomjour = nomjour;
	}

	public Jour(Disponibilite disponibilite, String nomjour, List<Horaire> horaires) {
		this.disponibilite = disponibilite;
		this.nomjour = nomjour;
		this.horaires = horaires;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "IDJOUR", unique = true, nullable = false)
	public Integer getIdjour() {
		return this.idjour;
	}

	public void setIdjour(Integer idjour) {
		this.idjour = idjour;
	}

	@ManyToOne
	@JoinColumn(name = "IDDISPO", nullable = false)
	public Disponibilite getDisponibilite() {
		return this.disponibilite;
	}

	public void setDisponibilite(Disponibilite disponibilite) {
		this.disponibilite = disponibilite;
	}

	@Column(name = "NOMJOUR", nullable = false, length = 50)
	public String getNomjour() {
		return this.nomjour;
	}

	public void setNomjour(String nomjour) {
		this.nomjour = nomjour;
	}

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "jour")
	public List<Horaire> getHoraires() {
		return this.horaires;
	}

	public void setHoraires(List<Horaire> horaires) {
		this.horaires = horaires;
	}

}
