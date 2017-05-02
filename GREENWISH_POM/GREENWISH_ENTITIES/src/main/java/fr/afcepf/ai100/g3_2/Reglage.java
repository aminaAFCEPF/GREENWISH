package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reglage database table.
 * 
 */
@Entity
@NamedQuery(name="Reglage.findAll", query="SELECT r FROM Reglage r")
public class Reglage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idreglage;

	//bi-directional many-to-one association to Participant
	@OneToMany(mappedBy="reglage")
	private List<Participant> participants;

	//bi-directional many-to-one association to Taillepolice
	@ManyToOne
	@JoinColumn(name="IDTAILLEPOLICE")
	private Taillepolice taillepolice;

	//bi-directional many-to-one association to Prioriterecherche
	@ManyToOne
	@JoinColumn(name="IDPRIORITE")
	private Prioriterecherche prioriterecherche;

	//bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name="IDPARTICIPANT")
	private Participant participant;

	//bi-directional many-to-one association to Frequencenotif
	@ManyToOne
	@JoinColumn(name="IDFREQUENCE")
	private Frequencenotif frequencenotif;

	//bi-directional many-to-one association to Theme
	@ManyToOne
	@JoinColumn(name="IDTHEME")
	private Theme theme;

	public Reglage() {
	}

	public int getIdreglage() {
		return this.idreglage;
	}

	public void setIdreglage(int idreglage) {
		this.idreglage = idreglage;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Participant addParticipant(Participant participant) {
		getParticipants().add(participant);
		participant.setReglage(this);

		return participant;
	}

	public Participant removeParticipant(Participant participant) {
		getParticipants().remove(participant);
		participant.setReglage(null);

		return participant;
	}

	public Taillepolice getTaillepolice() {
		return this.taillepolice;
	}

	public void setTaillepolice(Taillepolice taillepolice) {
		this.taillepolice = taillepolice;
	}

	public Prioriterecherche getPrioriterecherche() {
		return this.prioriterecherche;
	}

	public void setPrioriterecherche(Prioriterecherche prioriterecherche) {
		this.prioriterecherche = prioriterecherche;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Frequencenotif getFrequencenotif() {
		return this.frequencenotif;
	}

	public void setFrequencenotif(Frequencenotif frequencenotif) {
		this.frequencenotif = frequencenotif;
	}

	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}