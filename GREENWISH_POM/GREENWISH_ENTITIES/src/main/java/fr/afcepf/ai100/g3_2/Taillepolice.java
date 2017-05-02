package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the taillepolice database table.
 * 
 */
@Entity
@NamedQuery(name="Taillepolice.findAll", query="SELECT t FROM Taillepolice t")
public class Taillepolice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtaillepolice;

	private String taillepolice;

	//bi-directional many-to-one association to Reglage
	@OneToMany(mappedBy="taillepolice")
	private List<Reglage> reglages;

	public Taillepolice() {
	}

	public int getIdtaillepolice() {
		return this.idtaillepolice;
	}

	public void setIdtaillepolice(int idtaillepolice) {
		this.idtaillepolice = idtaillepolice;
	}

	public String getTaillepolice() {
		return this.taillepolice;
	}

	public void setTaillepolice(String taillepolice) {
		this.taillepolice = taillepolice;
	}

	public List<Reglage> getReglages() {
		return this.reglages;
	}

	public void setReglages(List<Reglage> reglages) {
		this.reglages = reglages;
	}

	public Reglage addReglage(Reglage reglage) {
		getReglages().add(reglage);
		reglage.setTaillepolice(this);

		return reglage;
	}

	public Reglage removeReglage(Reglage reglage) {
		getReglages().remove(reglage);
		reglage.setTaillepolice(null);

		return reglage;
	}

}