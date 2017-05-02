package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the valeur database table.
 * 
 */
@Entity
@NamedQuery(name="Valeur.findAll", query="SELECT v FROM Valeur v")
public class Valeur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idvaleur;

	private int valeur;

	//bi-directional many-to-one association to Objet
	@OneToMany(mappedBy="valeur")
	private List<Objet> objets;

	public Valeur() {
	}

	public int getIdvaleur() {
		return this.idvaleur;
	}

	public void setIdvaleur(int idvaleur) {
		this.idvaleur = idvaleur;
	}

	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public List<Objet> getObjets() {
		return this.objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}

	public Objet addObjet(Objet objet) {
		getObjets().add(objet);
		objet.setValeur(this);

		return objet;
	}

	public Objet removeObjet(Objet objet) {
		getObjets().remove(objet);
		objet.setValeur(null);

		return objet;
	}

}