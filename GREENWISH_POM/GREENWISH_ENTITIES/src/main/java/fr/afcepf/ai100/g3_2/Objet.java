package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the objet database table.
 * 
 */
@Entity
@NamedQuery(name="Objet.findAll", query="SELECT o FROM Objet o")
public class Objet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idobjet;

	private byte actif;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateajout;

	@Temporal(TemporalType.DATE)
	private Date dategarantie;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datesuppression;

	private String description;

	private String intitule;

	//bi-directional many-to-one association to Echange
	@OneToMany(mappedBy="objet")
	private List<Echange> echanges;

	//bi-directional many-to-one association to Favori
	@OneToMany(mappedBy="objet")
	private List<Favori> favoris;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="objet")
	private List<Image> images;

	//bi-directional many-to-one association to Domaine
	@ManyToOne
	@JoinColumn(name="IDDOMAINE")
	private Domaine domaine;

	//bi-directional many-to-one association to ListeProposition
	@ManyToOne
	@JoinColumn(name="IDLISTEOBJET")
	private ListeProposition listeProposition;

	//bi-directional many-to-one association to Valeur
	@ManyToOne
	@JoinColumn(name="IDVALEUR")
	private Valeur valeur;

	//bi-directional many-to-one association to TrancheAge
	@ManyToOne
	@JoinColumn(name="IDAGE")
	private TrancheAge trancheAge;

	public Objet() {
	}

	public int getIdobjet() {
		return this.idobjet;
	}

	public void setIdobjet(int idobjet) {
		this.idobjet = idobjet;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public Date getDateajout() {
		return this.dateajout;
	}

	public void setDateajout(Date dateajout) {
		this.dateajout = dateajout;
	}

	public Date getDategarantie() {
		return this.dategarantie;
	}

	public void setDategarantie(Date dategarantie) {
		this.dategarantie = dategarantie;
	}

	public Date getDatesuppression() {
		return this.datesuppression;
	}

	public void setDatesuppression(Date datesuppression) {
		this.datesuppression = datesuppression;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Echange> getEchanges() {
		return this.echanges;
	}

	public void setEchanges(List<Echange> echanges) {
		this.echanges = echanges;
	}

	public Echange addEchange(Echange echange) {
		getEchanges().add(echange);
		echange.setObjet(this);

		return echange;
	}

	public Echange removeEchange(Echange echange) {
		getEchanges().remove(echange);
		echange.setObjet(null);

		return echange;
	}

	public List<Favori> getFavoris() {
		return this.favoris;
	}

	public void setFavoris(List<Favori> favoris) {
		this.favoris = favoris;
	}

	public Favori addFavori(Favori favori) {
		getFavoris().add(favori);
		favori.setObjet(this);

		return favori;
	}

	public Favori removeFavori(Favori favori) {
		getFavoris().remove(favori);
		favori.setObjet(null);

		return favori;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setObjet(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setObjet(null);

		return image;
	}

	public Domaine getDomaine() {
		return this.domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public ListeProposition getListeProposition() {
		return this.listeProposition;
	}

	public void setListeProposition(ListeProposition listeProposition) {
		this.listeProposition = listeProposition;
	}

	public Valeur getValeur() {
		return this.valeur;
	}

	public void setValeur(Valeur valeur) {
		this.valeur = valeur;
	}

	public TrancheAge getTrancheAge() {
		return this.trancheAge;
	}

	public void setTrancheAge(TrancheAge trancheAge) {
		this.trancheAge = trancheAge;
	}

}