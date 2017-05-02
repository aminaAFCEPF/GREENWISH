package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the avis database table.
 * 
 */
@Entity
@Table(name="avis")
@NamedQuery(name="Avi.findAll", query="SELECT a FROM Avi a")
public class Avi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idavis;

	private String avis;

	private int note;

	//bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name="IDPARTICIPANT")
	private Participant participant;

	//bi-directional many-to-one association to Echange
	@OneToMany(mappedBy="avi")
	private List<Echange> echanges;

	public Avi() {
	}

	public int getIdavis() {
		return this.idavis;
	}

	public void setIdavis(int idavis) {
		this.idavis = idavis;
	}

	public String getAvis() {
		return this.avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public List<Echange> getEchanges() {
		return this.echanges;
	}

	public void setEchanges(List<Echange> echanges) {
		this.echanges = echanges;
	}

	public Echange addEchange(Echange echange) {
		getEchanges().add(echange);
		echange.setAvi(this);

		return echange;
	}

	public Echange removeEchange(Echange echange) {
		getEchanges().remove(echange);
		echange.setAvi(null);

		return echange;
	}

}