package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the statistique database table.
 * 
 */
@Entity
@NamedQuery(name="Statistique.findAll", query="SELECT s FROM Statistique s")
public class Statistique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idstat;

	private byte actif;

	private String code;

	//bi-directional many-to-many association to Participant
	@ManyToMany(mappedBy="statistiques")
	private List<Participant> participants;

	public Statistique() {
	}

	public int getIdstat() {
		return this.idstat;
	}

	public void setIdstat(int idstat) {
		this.idstat = idstat;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

}