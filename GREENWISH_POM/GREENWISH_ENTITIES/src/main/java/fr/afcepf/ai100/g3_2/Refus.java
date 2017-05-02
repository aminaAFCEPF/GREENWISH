package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the refus database table.
 * 
 */
@Entity
@NamedQuery(name="Refus.findAll", query="SELECT r FROM Refus r")
public class Refus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrefus;

	private String motif;

	//bi-directional many-to-many association to Echange
	@ManyToMany
	@JoinTable(
		name="refuse"
		, joinColumns={
			@JoinColumn(name="IDREFUS")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDECHANGE")
			}
		)
	private List<Echange> echanges;

	public Refus() {
	}

	public int getIdrefus() {
		return this.idrefus;
	}

	public void setIdrefus(int idrefus) {
		this.idrefus = idrefus;
	}

	public String getMotif() {
		return this.motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public List<Echange> getEchanges() {
		return this.echanges;
	}

	public void setEchanges(List<Echange> echanges) {
		this.echanges = echanges;
	}

}