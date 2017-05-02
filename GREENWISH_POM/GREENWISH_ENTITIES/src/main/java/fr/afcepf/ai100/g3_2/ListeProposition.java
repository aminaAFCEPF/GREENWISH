package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the liste_proposition database table.
 * 
 */
@Entity
@Table(name="liste_proposition")
@NamedQuery(name="ListeProposition.findAll", query="SELECT l FROM ListeProposition l")
public class ListeProposition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idlisteobjet;

	private byte actif;

	private String nom;

	//bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name="IDPARTICIPANT")
	private Participant participant;

	//bi-directional many-to-one association to Objet
	@OneToMany(mappedBy="listeProposition")
	private List<Objet> objets;

	public ListeProposition() {
	}

	public int getIdlisteobjet() {
		return this.idlisteobjet;
	}

	public void setIdlisteobjet(int idlisteobjet) {
		this.idlisteobjet = idlisteobjet;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public List<Objet> getObjets() {
		return this.objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}

	public Objet addObjet(Objet objet) {
		getObjets().add(objet);
		objet.setListeProposition(this);

		return objet;
	}

	public Objet removeObjet(Objet objet) {
		getObjets().remove(objet);
		objet.setListeProposition(null);

		return objet;
	}

}