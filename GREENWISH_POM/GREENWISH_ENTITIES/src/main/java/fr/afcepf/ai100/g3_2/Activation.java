package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the activation database table.
 * 
 */
@Entity
@NamedQuery(name="Activation.findAll", query="SELECT a FROM Activation a")
public class Activation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idactivation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateactivation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datedesactivation;

	//bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name="IDPARTICIPANT")
	private Participant participant;

	public Activation() {
	}

	public int getIdactivation() {
		return this.idactivation;
	}

	public void setIdactivation(int idactivation) {
		this.idactivation = idactivation;
	}

	public Date getDateactivation() {
		return this.dateactivation;
	}

	public void setDateactivation(Date dateactivation) {
		this.dateactivation = dateactivation;
	}

	public Date getDatedesactivation() {
		return this.datedesactivation;
	}

	public void setDatedesactivation(Date datedesactivation) {
		this.datedesactivation = datedesactivation;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

}