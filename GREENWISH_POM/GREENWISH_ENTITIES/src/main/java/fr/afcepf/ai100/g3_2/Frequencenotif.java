package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the frequencenotif database table.
 * 
 */
@Entity
@NamedQuery(name="Frequencenotif.findAll", query="SELECT f FROM Frequencenotif f")
public class Frequencenotif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfrequence;

	private int frequence;

	//bi-directional many-to-one association to Reglage
	@OneToMany(mappedBy="frequencenotif")
	private List<Reglage> reglages;

	public Frequencenotif() {
	}

	public int getIdfrequence() {
		return this.idfrequence;
	}

	public void setIdfrequence(int idfrequence) {
		this.idfrequence = idfrequence;
	}

	public int getFrequence() {
		return this.frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}

	public List<Reglage> getReglages() {
		return this.reglages;
	}

	public void setReglages(List<Reglage> reglages) {
		this.reglages = reglages;
	}

	public Reglage addReglage(Reglage reglage) {
		getReglages().add(reglage);
		reglage.setFrequencenotif(this);

		return reglage;
	}

	public Reglage removeReglage(Reglage reglage) {
		getReglages().remove(reglage);
		reglage.setFrequencenotif(null);

		return reglage;
	}

}