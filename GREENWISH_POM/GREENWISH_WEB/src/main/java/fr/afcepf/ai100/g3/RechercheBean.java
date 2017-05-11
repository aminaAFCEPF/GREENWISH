package fr.afcepf.ai100.g3;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "mbRechercherObjet")
@ViewScoped
public class RechercheBean {
	
	@ManagedProperty(value="#{mbCnx}")
	private ConnexionBean mbCnx;
	@EJB
	private IDaoObjet proxyDaoObjet;
	@EJB
	private IBusinessRecherche proxyBusinessRecherche;
	@EJB
	private IDaoValeur proxyDaoValeur;
	@EJB
	private IDaoTrancheAge proxyDaoTrancheAge;
	
	
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
	
	
	
	@PostConstruct
	public void init(){
		domaines = proxyBusinessRecherche.rechercherDomaine();
		selectedDomaine = new Domaine();
		//selectedDomaine.setIddomaine(domaines.get(0).getIddomaine());
		
		chargerCategories();
		categories = proxyBusinessRecherche.rechercherCategorie();
		//selectedCategorie.setIdcategorie(categories.get(0).getIdcategorie());
		
		chargerSousCategorie();
		selectedSousCategorie = new Souscategorie();
		//selectedSousCategorie.setIdsouscategorie(sousCategories.get(0).getIdsouscategorie());
		
		valeurs = proxyBusinessRecherche.rechercherValeur();
		
		trancheAges = proxyBusinessRecherche.rechercherTrancheAge();
	}
	
	public void chargerCategories() {
		categories = proxyBusinessRecherche.rechercherCategorieParDomaine(selectedDomaine);
		selectedCategorie = new Categorie();
		//selectedCategorie.setIdcategorie(categories.get(0).getIdcategorie());
		sousCategories = proxyBusinessRecherche.rechercherSousCategorieParCategorie(selectedCategorie);
	}

	public void chargerSousCategorie() {
		sousCategories = proxyBusinessRecherche.rechercherSousCategorieParCategorie(selectedCategorie);
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

	public IDaoObjet getProxyDaoObjet() {
		return proxyDaoObjet;
	}

	public void setProxyDaoObjet(IDaoObjet proxyDaoObjet) {
		this.proxyDaoObjet = proxyDaoObjet;
	}

	public IBusinessRecherche getProxyBusinessRecherche() {
		return proxyBusinessRecherche;
	}

	public void setProxyBusinessRecherche(IBusinessRecherche proxyBusinessRecherche) {
		this.proxyBusinessRecherche = proxyBusinessRecherche;
	}

	public IDaoValeur getProxyDaoValeur() {
		return proxyDaoValeur;
	}

	public void setProxyDaoValeur(IDaoValeur proxyDaoValeur) {
		this.proxyDaoValeur = proxyDaoValeur;
	}

	public IDaoTrancheAge getProxyDaoTrancheAge() {
		return proxyDaoTrancheAge;
	}

	public void setProxyDaoTrancheAge(IDaoTrancheAge proxyDaoTrancheAge) {
		this.proxyDaoTrancheAge = proxyDaoTrancheAge;
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
	
	
	
}
