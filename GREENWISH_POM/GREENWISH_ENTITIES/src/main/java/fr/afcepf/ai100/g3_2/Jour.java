package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the jour database table.
 * 
 */
@Entity
@NamedQuery(name="Jour.findAll", query="SELECT j FROM Jour j")
public class Jour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idjour;

	private String nomjour;

	//bi-directional many-to-one association to Horaire
	@OneToMany(mappedBy="jour")
	private List<Horaire> horaires;

	//bi-directional many-to-one association to Disponibilite
	@ManyToOne
	@JoinColumn(name="IDDISPO")
	private Disponibilite disponibilite;

	public Jour() {
	}

	public int getIdjour() {
		return this.idjour;
	}

	public void setIdjour(int idjour) {
		this.idjour = idjour;
	}

	public String getNomjour() {
		return this.nomjour;
	}

	public void setNomjour(String nomjour) {
		this.nomjour = nomjour;
	}

	public List<Horaire> getHoraires() {
		return this.horaires;
	}

	public void setHoraires(List<Horaire> horaires) {
		this.horaires = horaires;
	}

	public Horaire addHoraire(Horaire horaire) {
		getHoraires().add(horaire);
		horaire.setJour(this);

		return horaire;
	}

	public Horaire removeHoraire(Horaire horaire) {
		getHoraires().remove(horaire);
		horaire.setJour(null);

		return horaire;
	}

	public Disponibilite getDisponibilite() {
		return this.disponibilite;
	}

	public void setDisponibilite(Disponibilite disponibilite) {
		this.disponibilite = disponibilite;
	}

}