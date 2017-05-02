package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idimage;

	private String image;

	//bi-directional many-to-one association to Objet
	@ManyToOne
	@JoinColumn(name="IDOBJET")
	private Objet objet;

	public Image() {
	}

	public int getIdimage() {
		return this.idimage;
	}

	public void setIdimage(int idimage) {
		this.idimage = idimage;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Objet getObjet() {
		return this.objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

}