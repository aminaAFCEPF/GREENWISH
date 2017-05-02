package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rdv database table.
 * 
 */
@Entity
@NamedQuery(name="Rdv.findAll", query="SELECT r FROM Rdv r")
public class Rdv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrdv;

	private String adresse;

	@Temporal(TemporalType.TIMESTAMP)
	private Date daterdv;

	//bi-directional many-to-one association to Echange
	@OneToMany(mappedBy="rdv")
	private List<Echange> echanges;

	//bi-directional many-to-one association to Echange
	@ManyToOne
	@JoinColumn(name="IDECHANGE")
	private Echange echange;

	//bi-directional many-to-one association to Ville
	@ManyToOne
	@JoinColumn(name="IDVILLE")
	private Ville ville;

	public Rdv() {
	}

	public int getIdrdv() {
		return this.idrdv;
	}

	public void setIdrdv(int idrdv) {
		this.idrdv = idrdv;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDaterdv() {
		return this.daterdv;
	}

	public void setDaterdv(Date daterdv) {
		this.daterdv = daterdv;
	}

	public List<Echange> getEchanges() {
		return this.echanges;
	}

	public void setEchanges(List<Echange> echanges) {
		this.echanges = echanges;
	}

	public Echange addEchange(Echange echange) {
		getEchanges().add(echange);
		echange.setRdv(this);

		return echange;
	}

	public Echange removeEchange(Echange echange) {
		getEchanges().remove(echange);
		echange.setRdv(null);

		return echange;
	}

	public Echange getEchange() {
		return this.echange;
	}

	public void setEchange(Echange echange) {
		this.echange = echange;
	}

	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

}