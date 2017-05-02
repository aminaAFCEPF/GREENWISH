package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tranche_age database table.
 * 
 */
@Entity
@Table(name="tranche_age")
@NamedQuery(name="TrancheAge.findAll", query="SELECT t FROM TrancheAge t")
public class TrancheAge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idage;

	@Column(name="AGE_MAXI")
	private int ageMaxi;

	@Column(name="AGE_MINI")
	private int ageMini;

	//bi-directional many-to-one association to Objet
	@OneToMany(mappedBy="trancheAge")
	private List<Objet> objets;

	//bi-directional many-to-one association to Souhait
	@OneToMany(mappedBy="trancheAge")
	private List<Souhait> souhaits;

	public TrancheAge() {
	}

	public int getIdage() {
		return this.idage;
	}

	public void setIdage(int idage) {
		this.idage = idage;
	}

	public int getAgeMaxi() {
		return this.ageMaxi;
	}

	public void setAgeMaxi(int ageMaxi) {
		this.ageMaxi = ageMaxi;
	}

	public int getAgeMini() {
		return this.ageMini;
	}

	public void setAgeMini(int ageMini) {
		this.ageMini = ageMini;
	}

	public List<Objet> getObjets() {
		return this.objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}

	public Objet addObjet(Objet objet) {
		getObjets().add(objet);
		objet.setTrancheAge(this);

		return objet;
	}

	public Objet removeObjet(Objet objet) {
		getObjets().remove(objet);
		objet.setTrancheAge(null);

		return objet;
	}

	public List<Souhait> getSouhaits() {
		return this.souhaits;
	}

	public void setSouhaits(List<Souhait> souhaits) {
		this.souhaits = souhaits;
	}

	public Souhait addSouhait(Souhait souhait) {
		getSouhaits().add(souhait);
		souhait.setTrancheAge(this);

		return souhait;
	}

	public Souhait removeSouhait(Souhait souhait) {
		getSouhaits().remove(souhait);
		souhait.setTrancheAge(null);

		return souhait;
	}

}