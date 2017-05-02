package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the domaine database table.
 * 
 */
@Entity
@NamedQuery(name="Domaine.findAll", query="SELECT d FROM Domaine d")
public class Domaine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddomaine;

	private String domaine;

	//bi-directional many-to-one association to Categorie
	@OneToMany(mappedBy="domaine")
	private List<Categorie> categories;

	//bi-directional many-to-one association to Objet
	@OneToMany(mappedBy="domaine")
	private List<Objet> objets;

	//bi-directional many-to-one association to Souhait
	@OneToMany(mappedBy="domaine")
	private List<Souhait> souhaits;

	public Domaine() {
	}

	public int getIddomaine() {
		return this.iddomaine;
	}

	public void setIddomaine(int iddomaine) {
		this.iddomaine = iddomaine;
	}

	public String getDomaine() {
		return this.domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public List<Categorie> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Categorie addCategory(Categorie category) {
		getCategories().add(category);
		category.setDomaine(this);

		return category;
	}

	public Categorie removeCategory(Categorie category) {
		getCategories().remove(category);
		category.setDomaine(null);

		return category;
	}

	public List<Objet> getObjets() {
		return this.objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}

	public Objet addObjet(Objet objet) {
		getObjets().add(objet);
		objet.setDomaine(this);

		return objet;
	}

	public Objet removeObjet(Objet objet) {
		getObjets().remove(objet);
		objet.setDomaine(null);

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
		souhait.setDomaine(this);

		return souhait;
	}

	public Souhait removeSouhait(Souhait souhait) {
		getSouhaits().remove(souhait);
		souhait.setDomaine(null);

		return souhait;
	}

}