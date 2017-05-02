package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the litige database table.
 * 
 */
@Entity
@NamedQuery(name="Litige.findAll", query="SELECT l FROM Litige l")
public class Litige implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idlitige;

	private String motif;

	private String motifreceveur;

	private byte resolu;

	//bi-directional many-to-one association to Echange
	@OneToMany(mappedBy="litige")
	private List<Echange> echanges;

	//bi-directional many-to-one association to Echange
	@ManyToOne
	@JoinColumn(name="IDECHANGE")
	private Echange echange;

	public Litige() {
	}

	public int getIdlitige() {
		return this.idlitige;
	}

	public void setIdlitige(int idlitige) {
		this.idlitige = idlitige;
	}

	public String getMotif() {
		return this.motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getMotifreceveur() {
		return this.motifreceveur;
	}

	public void setMotifreceveur(String motifreceveur) {
		this.motifreceveur = motifreceveur;
	}

	public byte getResolu() {
		return this.resolu;
	}

	public void setResolu(byte resolu) {
		this.resolu = resolu;
	}

	public List<Echange> getEchanges() {
		return this.echanges;
	}

	public void setEchanges(List<Echange> echanges) {
		this.echanges = echanges;
	}

	public Echange addEchange(Echange echange) {
		getEchanges().add(echange);
		echange.setLitige(this);

		return echange;
	}

	public Echange removeEchange(Echange echange) {
		getEchanges().remove(echange);
		echange.setLitige(null);

		return echange;
	}

	public Echange getEchange() {
		return this.echange;
	}

	public void setEchange(Echange echange) {
		this.echange = echange;
	}

}