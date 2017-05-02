package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prioriterecherche database table.
 * 
 */
@Entity
@NamedQuery(name="Prioriterecherche.findAll", query="SELECT p FROM Prioriterecherche p")
public class Prioriterecherche implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpriorite;

	private String priorite;

	//bi-directional many-to-one association to Reglage
	@OneToMany(mappedBy="prioriterecherche")
	private List<Reglage> reglages;

	public Prioriterecherche() {
	}

	public int getIdpriorite() {
		return this.idpriorite;
	}

	public void setIdpriorite(int idpriorite) {
		this.idpriorite = idpriorite;
	}

	public String getPriorite() {
		return this.priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}

	public List<Reglage> getReglages() {
		return this.reglages;
	}

	public void setReglages(List<Reglage> reglages) {
		this.reglages = reglages;
	}

	public Reglage addReglage(Reglage reglage) {
		getReglages().add(reglage);
		reglage.setPrioriterecherche(this);

		return reglage;
	}

	public Reglage removeReglage(Reglage reglage) {
		getReglages().remove(reglage);
		reglage.setPrioriterecherche(null);

		return reglage;
	}

}