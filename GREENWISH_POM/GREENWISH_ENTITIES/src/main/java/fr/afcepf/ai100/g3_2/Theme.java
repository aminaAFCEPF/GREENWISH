package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the theme database table.
 * 
 */
@Entity
@NamedQuery(name="Theme.findAll", query="SELECT t FROM Theme t")
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idtheme;

	private String theme;

	//bi-directional many-to-one association to Reglage
	@OneToMany(mappedBy="theme")
	private List<Reglage> reglages;

	public Theme() {
	}

	public int getIdtheme() {
		return this.idtheme;
	}

	public void setIdtheme(int idtheme) {
		this.idtheme = idtheme;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<Reglage> getReglages() {
		return this.reglages;
	}

	public void setReglages(List<Reglage> reglages) {
		this.reglages = reglages;
	}

	public Reglage addReglage(Reglage reglage) {
		getReglages().add(reglage);
		reglage.setTheme(this);

		return reglage;
	}

	public Reglage removeReglage(Reglage reglage) {
		getReglages().remove(reglage);
		reglage.setTheme(null);

		return reglage;
	}

}