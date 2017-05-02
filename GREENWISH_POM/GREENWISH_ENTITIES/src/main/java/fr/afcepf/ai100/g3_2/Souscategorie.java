package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the souscategorie database table.
 * 
 */
@Entity
@NamedQuery(name="Souscategorie.findAll", query="SELECT s FROM Souscategorie s")
public class Souscategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsouscategorie;

	private String intitule;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="IDCATEGORIE")
	private Categorie categorie;

	public Souscategorie() {
	}

	public int getIdsouscategorie() {
		return this.idsouscategorie;
	}

	public void setIdsouscategorie(int idsouscategorie) {
		this.idsouscategorie = idsouscategorie;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}