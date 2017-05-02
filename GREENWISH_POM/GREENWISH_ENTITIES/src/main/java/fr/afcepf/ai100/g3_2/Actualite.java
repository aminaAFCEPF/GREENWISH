package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the actualite database table.
 * 
 */
@Entity
@NamedQuery(name="Actualite.findAll", query="SELECT a FROM Actualite a")
public class Actualite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idactu;

	private byte actif;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datearchivage;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datepublication;

	private String image;

	private String texte;

	private String titre;

	//bi-directional many-to-many association to Participant
	@ManyToMany
	@JoinTable(
		name="publie"
		, joinColumns={
			@JoinColumn(name="IDACTU")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDPARTICIPANT")
			}
		)
	private List<Participant> participants;

	public Actualite() {
	}

	public int getIdactu() {
		return this.idactu;
	}

	public void setIdactu(int idactu) {
		this.idactu = idactu;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public Date getDatearchivage() {
		return this.datearchivage;
	}

	public void setDatearchivage(Date datearchivage) {
		this.datearchivage = datearchivage;
	}

	public Date getDatepublication() {
		return this.datepublication;
	}

	public void setDatepublication(Date datepublication) {
		this.datepublication = datepublication;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTexte() {
		return this.texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

}