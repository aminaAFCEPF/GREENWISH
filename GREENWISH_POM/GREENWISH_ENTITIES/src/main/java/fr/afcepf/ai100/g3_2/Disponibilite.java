package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the disponibilite database table.
 * 
 */
@Entity
@NamedQuery(name="Disponibilite.findAll", query="SELECT d FROM Disponibilite d")
public class Disponibilite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddispo;

	//bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name="IDPARTICIPANT")
	private Participant participant;

	//bi-directional many-to-one association to Jour
	@OneToMany(mappedBy="disponibilite")
	private List<Jour> jours;

	//bi-directional many-to-one association to Participant
	@OneToMany(mappedBy="disponibilite")
	private List<Participant> participants;

	public Disponibilite() {
	}

	public int getIddispo() {
		return this.iddispo;
	}

	public void setIddispo(int iddispo) {
		this.iddispo = iddispo;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public List<Jour> getJours() {
		return this.jours;
	}

	public void setJours(List<Jour> jours) {
		this.jours = jours;
	}

	public Jour addJour(Jour jour) {
		getJours().add(jour);
		jour.setDisponibilite(this);

		return jour;
	}

	public Jour removeJour(Jour jour) {
		getJours().remove(jour);
		jour.setDisponibilite(null);

		return jour;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Participant addParticipant(Participant participant) {
		getParticipants().add(participant);
		participant.setDisponibilite(this);

		return participant;
	}

	public Participant removeParticipant(Participant participant) {
		getParticipants().remove(participant);
		participant.setDisponibilite(null);

		return participant;
	}

}