package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the horaire database table.
 * 
 */
@Entity
@NamedQuery(name="Horaire.findAll", query="SELECT h FROM Horaire h")
public class Horaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idhoraire;

	@Temporal(TemporalType.TIMESTAMP)
	private Date heuredebut;

	@Temporal(TemporalType.TIMESTAMP)
	private Date heurefin;

	//bi-directional many-to-one association to Jour
	@ManyToOne
	@JoinColumn(name="IDJOUR")
	private Jour jour;

	public Horaire() {
	}

	public int getIdhoraire() {
		return this.idhoraire;
	}

	public void setIdhoraire(int idhoraire) {
		this.idhoraire = idhoraire;
	}

	public Date getHeuredebut() {
		return this.heuredebut;
	}

	public void setHeuredebut(Date heuredebut) {
		this.heuredebut = heuredebut;
	}

	public Date getHeurefin() {
		return this.heurefin;
	}

	public void setHeurefin(Date heurefin) {
		this.heurefin = heurefin;
	}

	public Jour getJour() {
		return this.jour;
	}

	public void setJour(Jour jour) {
		this.jour = jour;
	}

}