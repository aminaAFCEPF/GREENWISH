package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the echange database table.
 * 
 */
@Entity
@NamedQuery(name="Echange.findAll", query="SELECT e FROM Echange e")
public class Echange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idechange;

	private String codefin;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateactivation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datelitige;

	@Temporal(TemporalType.TIMESTAMP)
	private Date daterefus;

	private int valeur;

	//bi-directional many-to-one association to Objet
	@ManyToOne
	@JoinColumn(name="IDOBJET")
	private Objet objet;

	//bi-directional many-to-one association to Avi
	@ManyToOne
	@JoinColumn(name="IDAVIS")
	private Avi avi;

	//bi-directional many-to-one association to Litige
	@ManyToOne
	@JoinColumn(name="IDLITIGE")
	private Litige litige;

	//bi-directional many-to-one association to Rdv
	@ManyToOne
	@JoinColumn(name="IDRDV")
	private Rdv rdv;

	//bi-directional many-to-one association to Litige
	@OneToMany(mappedBy="echange")
	private List<Litige> litiges;

	//bi-directional many-to-one association to Rdv
	@OneToMany(mappedBy="echange")
	private List<Rdv> rdvs;

	//bi-directional many-to-many association to Refus
	@ManyToMany(mappedBy="echanges")
	private List<Refus> refuses;

	public Echange() {
	}

	public int getIdechange() {
		return this.idechange;
	}

	public void setIdechange(int idechange) {
		this.idechange = idechange;
	}

	public String getCodefin() {
		return this.codefin;
	}

	public void setCodefin(String codefin) {
		this.codefin = codefin;
	}

	public Date getDateactivation() {
		return this.dateactivation;
	}

	public void setDateactivation(Date dateactivation) {
		this.dateactivation = dateactivation;
	}

	public Date getDatelitige() {
		return this.datelitige;
	}

	public void setDatelitige(Date datelitige) {
		this.datelitige = datelitige;
	}

	public Date getDaterefus() {
		return this.daterefus;
	}

	public void setDaterefus(Date daterefus) {
		this.daterefus = daterefus;
	}

	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Objet getObjet() {
		return this.objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

	public Avi getAvi() {
		return this.avi;
	}

	public void setAvi(Avi avi) {
		this.avi = avi;
	}

	public Litige getLitige() {
		return this.litige;
	}

	public void setLitige(Litige litige) {
		this.litige = litige;
	}

	public Rdv getRdv() {
		return this.rdv;
	}

	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}

	public List<Litige> getLitiges() {
		return this.litiges;
	}

	public void setLitiges(List<Litige> litiges) {
		this.litiges = litiges;
	}

	public Litige addLitige(Litige litige) {
		getLitiges().add(litige);
		litige.setEchange(this);

		return litige;
	}

	public Litige removeLitige(Litige litige) {
		getLitiges().remove(litige);
		litige.setEchange(null);

		return litige;
	}

	public List<Rdv> getRdvs() {
		return this.rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public Rdv addRdv(Rdv rdv) {
		getRdvs().add(rdv);
		rdv.setEchange(this);

		return rdv;
	}

	public Rdv removeRdv(Rdv rdv) {
		getRdvs().remove(rdv);
		rdv.setEchange(null);

		return rdv;
	}

	public List<Refus> getRefuses() {
		return this.refuses;
	}

	public void setRefuses(List<Refus> refuses) {
		this.refuses = refuses;
	}

}