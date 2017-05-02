package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the inscription database table.
 * 
 */
@Entity
@NamedQuery(name="Inscription.findAll", query="SELECT i FROM Inscription i")
public class Inscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idinscription;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datedesinscription;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateinscription;

	//bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name="IDPARTICIPANT")
	private Participant participant;

	public Inscription() {
	}

	public int getIdinscription() {
		return this.idinscription;
	}

	public void setIdinscription(int idinscription) {
		this.idinscription = idinscription;
	}

	public Date getDatedesinscription() {
		return this.datedesinscription;
	}

	public void setDatedesinscription(Date datedesinscription) {
		this.datedesinscription = datedesinscription;
	}

	public Date getDateinscription() {
		return this.dateinscription;
	}

	public void setDateinscription(Date dateinscription) {
		this.dateinscription = dateinscription;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

}