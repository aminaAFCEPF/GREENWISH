package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the favoris database table.
 * 
 */
@Entity
@Table(name="favoris")
@NamedQuery(name="Favori.findAll", query="SELECT f FROM Favori f")
public class Favori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfavoris;

	//bi-directional many-to-many association to Participant
	@ManyToMany
	@JoinTable(
		name="appartient"
		, joinColumns={
			@JoinColumn(name="IDFAVORIS")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDPARTICIPANT")
			}
		)
	private List<Participant> participants;

	//bi-directional many-to-one association to Objet
	@ManyToOne
	@JoinColumn(name="IDOBJET")
	private Objet objet;

	public Favori() {
	}

	public int getIdfavoris() {
		return this.idfavoris;
	}

	public void setIdfavoris(int idfavoris) {
		this.idfavoris = idfavoris;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Objet getObjet() {
		return this.objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

}