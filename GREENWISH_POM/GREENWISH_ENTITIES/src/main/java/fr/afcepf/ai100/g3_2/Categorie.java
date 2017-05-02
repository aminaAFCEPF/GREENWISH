package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcategorie;

	private String intitule;

	//bi-directional many-to-one association to Domaine
	@ManyToOne
	@JoinColumn(name="IDDOMAINE")
	private Domaine domaine;

	//bi-directional many-to-one association to Souscategorie
	@OneToMany(mappedBy="categorie")
	private List<Souscategorie> souscategories;

	public Categorie() {
	}

	public int getIdcategorie() {
		return this.idcategorie;
	}

	public void setIdcategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Domaine getDomaine() {
		return this.domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public List<Souscategorie> getSouscategories() {
		return this.souscategories;
	}

	public void setSouscategories(List<Souscategorie> souscategories) {
		this.souscategories = souscategories;
	}

	public Souscategorie addSouscategory(Souscategorie souscategory) {
		getSouscategories().add(souscategory);
		souscategory.setCategorie(this);

		return souscategory;
	}

	public Souscategorie removeSouscategory(Souscategorie souscategory) {
		getSouscategories().remove(souscategory);
		souscategory.setCategorie(null);

		return souscategory;
	}

}