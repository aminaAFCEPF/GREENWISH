package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@NamedQuery(name="Ville.findAll", query="SELECT v FROM Ville v")
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idville;

	@Column(name="CODE_POSTAL")
	private String codePostal;

	private String ville;

	//bi-directional many-to-one association to Participant
	@OneToMany(mappedBy="ville")
	private List<Participant> participants;

	//bi-directional many-to-one association to Rdv
	@OneToMany(mappedBy="ville")
	private List<Rdv> rdvs;

	public Ville() {
	}

	public int getIdville() {
		return this.idville;
	}

	public void setIdville(int idville) {
		this.idville = idville;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Participant addParticipant(Participant participant) {
		getParticipants().add(participant);
		participant.setVille(this);

		return participant;
	}

	public Participant removeParticipant(Participant participant) {
		getParticipants().remove(participant);
		participant.setVille(null);

		return participant;
	}

	public List<Rdv> getRdvs() {
		return this.rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public Rdv addRdv(Rdv rdv) {
		getRdvs().add(rdv);
		rdv.setVille(this);

		return rdv;
	}

	public Rdv removeRdv(Rdv rdv) {
		getRdvs().remove(rdv);
		rdv.setVille(null);

		return rdv;
	}

}