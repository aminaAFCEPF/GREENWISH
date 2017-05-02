package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the souhait database table.
 * 
 */
@Entity
@NamedQuery(name="Souhait.findAll", query="SELECT s FROM Souhait s")
public class Souhait implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsouhait;

	private BigDecimal distance;

	private String intitule;

	private int valeur;

	//bi-directional many-to-one association to Domaine
	@ManyToOne
	@JoinColumn(name="IDDOMAINE")
	private Domaine domaine;

	//bi-directional many-to-one association to TrancheAge
	@ManyToOne
	@JoinColumn(name="IDAGE")
	private TrancheAge trancheAge;

	//bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name="IDPARTICIPANT")
	private Participant participant;

	public Souhait() {
	}

	public int getIdsouhait() {
		return this.idsouhait;
	}

	public void setIdsouhait(int idsouhait) {
		this.idsouhait = idsouhait;
	}

	public BigDecimal getDistance() {
		return this.distance;
	}

	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Domaine getDomaine() {
		return this.domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public TrancheAge getTrancheAge() {
		return this.trancheAge;
	}

	public void setTrancheAge(TrancheAge trancheAge) {
		this.trancheAge = trancheAge;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

}