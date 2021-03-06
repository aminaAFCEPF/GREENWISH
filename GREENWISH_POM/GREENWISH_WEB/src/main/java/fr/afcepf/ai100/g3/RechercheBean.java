package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "mbRechercherObjet")
@SessionScoped
public class RechercheBean {

	@ManagedProperty(value = "#{mbCnx}")
	private ConnexionBean mbCnx;
	@EJB
	private IBusinessRecherche proxyBusinessRecherche;

	private Domaine selectedDomaine = new Domaine();
	private List<Domaine> domaines;
	private Categorie selectedCategorie = new Categorie();
	private List<Categorie> categories;
	private Souscategorie selectedSousCategorie = new Souscategorie();
	private List<Souscategorie> sousCategories;
	private Valeur selectedValeur = new Valeur();
	private List<Valeur> valeurs;
	private TrancheAge selectedTrancheAge = new TrancheAge();
	private List<TrancheAge> trancheAges;
	private List<Objet> resultatRecherche = new ArrayList<>();
	private String rDomaine = "%%";
	private String rCategorie = "%%";
	private String rSousCategorie = "%%";
	private String rValeur = selectedValeur.toString();
	private String rIntitule = "%%";
	private String selectedIntitule;

	@PostConstruct
	public void init() {
		domaines = proxyBusinessRecherche.rechercherDomaine();
		selectedDomaine = new Domaine();

		chargerCategories();
		categories = proxyBusinessRecherche.rechercherCategorie();

		chargerSousCategorie();
		selectedSousCategorie = new Souscategorie();

		valeurs = proxyBusinessRecherche.rechercherValeur();

		trancheAges = proxyBusinessRecherche.rechercherTrancheAge();
	}

	public void chargerCategories() {
		categories = proxyBusinessRecherche.rechercherCategorieParDomaine(selectedDomaine);
		selectedCategorie = new Categorie();
		sousCategories = proxyBusinessRecherche.rechercherSousCategorieParCategorie(selectedCategorie);
	}

	public void chargerSousCategorie() {
		sousCategories = proxyBusinessRecherche.rechercherSousCategorieParCategorie(selectedCategorie);
	}

	public String rechercherObjet() {
		
		String nav = "/Catalogue.xhtml?faces-redirect=true";

		rDomaine = "%%";
		rCategorie = "%%";
		rSousCategorie = "%%";
		rValeur = selectedValeur.toString();
		rIntitule = "%%";

		if (isSetDomaine(selectedDomaine.getIddomaine())) {
			rDomaine = selectedDomaine.getIddomaine().toString();
			System.out.println("je suis dans le domaine");
			System.out.println(rDomaine);
		}
		if (isSetCategorie(selectedCategorie.getIdcategorie())) {
			rCategorie = selectedCategorie.getIdcategorie().toString();
			System.out.println("je suis dans la categorie");
			System.out.println(rCategorie);
		}
		if (isSetSousCategorie(selectedSousCategorie.getIdsouscategorie())) {
			rSousCategorie = selectedSousCategorie.getIdsouscategorie().toString();
			System.out.println("je suis dans la sscategorie");
			System.out.println(rSousCategorie);
		}
		if (isSetValeur(selectedValeur.getIdvaleur())) {
			rValeur = selectedValeur.getIdvaleur().toString();
			System.out.println("je suis dans la valeur");
		}
		if (isSetIntitule(selectedIntitule)){
			rIntitule = selectedIntitule;
			System.out.println("Je suis dans l'intitule");
		}

		if (isSetDomaine(selectedDomaine.getIddomaine()) 
				|| isSetCategorie(selectedCategorie.getIdcategorie())
				|| isSetSousCategorie(selectedSousCategorie.getIdsouscategorie())
				|| isSetValeur(selectedValeur.getIdvaleur())
				|| isSetIntitule(selectedIntitule)) {

			System.out.println("Au moins un critère est rempli, je lance ma recherche!");
			resultatRecherche = proxyBusinessRecherche.rechercherObjet(rDomaine, rCategorie, rSousCategorie, rValeur, rIntitule);
		}
		System.out.println("taille du resultat : " + resultatRecherche.size());
		for (Objet objet : resultatRecherche) {
			System.out.println(objet.getIntitule());
		}
		System.out.println("coucou méthode BEAN!!!");
		return nav;
	}

	public String getrDomaine() {
		return rDomaine;
	}

	public void setrDomaine(String rDomaine) {
		this.rDomaine = rDomaine;
	}

	public String getrCategorie() {
		return rCategorie;
	}

	public void setrCategorie(String rCategorie) {
		this.rCategorie = rCategorie;
	}

	public String getrSousCategorie() {
		return rSousCategorie;
	}

	public void setrSousCategorie(String rSousCategorie) {
		this.rSousCategorie = rSousCategorie;
	}

	public String getrValeur() {
		return rValeur;
	}

	public void setrValeur(String rValeur) {
		this.rValeur = rValeur;
	}

	public boolean isSetDomaine(Integer rDomaine) {
		boolean domaineIsSet = false;
		if (selectedDomaine.getIddomaine() != null) {
			domaineIsSet = true;
		}
		return domaineIsSet;
	}

	public boolean isSetCategorie(Integer rCategorie) {
		boolean categorieIsSet = false;
		if (selectedCategorie.getIdcategorie() != null) {
			categorieIsSet = true;
		}
		return categorieIsSet;
	}

	public boolean isSetSousCategorie(Integer rSousCategorie) {
		boolean sousCategorieIsSet = false;
		if (selectedSousCategorie.getIdsouscategorie() != null) {
			sousCategorieIsSet = true;
		}
		return sousCategorieIsSet;
	}

	public boolean isSetTrancheAge(Integer rTrancheAge) {
		boolean trancheAgeIsSet = false;
		if (selectedTrancheAge.getIdage() != null) {
			trancheAgeIsSet = true;
		}
		return trancheAgeIsSet;
	}

	public boolean isSetValeur(Integer rValeur) {
		boolean valeurIsSet = false;
		if (selectedValeur.getIdvaleur() != null) {
			valeurIsSet = true;
		}
		return valeurIsSet;
	}
	
	public boolean isSetIntitule(String rIntitule){
		boolean intituleIsSet = false;
		if(selectedIntitule != null){
			intituleIsSet = true;
		}
		return intituleIsSet;
	}

	public Domaine getSelectedDomaine() {
		return selectedDomaine;
	}

	public void setSelectedDomaine(Domaine selectedDomaine) {
		this.selectedDomaine = selectedDomaine;
	}

	public List<Domaine> getDomaines() {
		return domaines;
	}

	public void setDomaines(List<Domaine> domaines) {
		this.domaines = domaines;
	}

	public Categorie getSelectedCategorie() {
		return selectedCategorie;
	}

	public void setSelectedCategorie(Categorie selectedCategorie) {
		this.selectedCategorie = selectedCategorie;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Souscategorie getSelectedSousCategorie() {
		return selectedSousCategorie;
	}

	public void setSelectedSousCategorie(Souscategorie selectedSousCategorie) {
		this.selectedSousCategorie = selectedSousCategorie;
	}

	public List<Souscategorie> getSousCategories() {
		return sousCategories;
	}

	public void setSousCategories(List<Souscategorie> sousCategories) {
		this.sousCategories = sousCategories;
	}

	public ConnexionBean getMbCnx() {
		return mbCnx;
	}

	public void setMbCnx(ConnexionBean mbCnx) {
		this.mbCnx = mbCnx;
	}

	public IBusinessRecherche getProxyBusinessRecherche() {
		return proxyBusinessRecherche;
	}

	public void setProxyBusinessRecherche(IBusinessRecherche proxyBusinessRecherche) {
		this.proxyBusinessRecherche = proxyBusinessRecherche;
	}

	public Valeur getSelectedValeur() {
		return selectedValeur;
	}

	public void setSelectedValeur(Valeur selectedValeur) {
		this.selectedValeur = selectedValeur;
	}

	public List<Valeur> getValeurs() {
		return valeurs;
	}

	public void setValeurs(List<Valeur> valeurs) {
		this.valeurs = valeurs;
	}

	public TrancheAge getSelectedTrancheAge() {
		return selectedTrancheAge;
	}

	public void setSelectedTrancheAge(TrancheAge selectedTrancheAge) {
		this.selectedTrancheAge = selectedTrancheAge;
	}

	public List<TrancheAge> getTrancheAges() {
		return trancheAges;
	}

	public void setTrancheAges(List<TrancheAge> trancheAges) {
		this.trancheAges = trancheAges;
	}

	public List<Objet> getResultatRecherche() {
		return resultatRecherche;
	}

	public void setResultatRecherche(List<Objet> resultatRecherche) {
		this.resultatRecherche = resultatRecherche;
	}

	public String getrIntitule() {
		return rIntitule;
	}

	public void setrIntitule(String rIntitule) {
		this.rIntitule = rIntitule;
	}

	public String getSelectedIntitule() {
		return selectedIntitule;
	}

	public void setSelectedIntitule(String selectedIntitule) {
		this.selectedIntitule = selectedIntitule;
	}
	
	
	

}
