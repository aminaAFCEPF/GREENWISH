package fr.afcepf.ai100.g3;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbAjouterObjet")
@SessionScoped
public class AjouterObjetBean {

	
	@EJB
	private IBusinessAjouterObjet proxyAjouterObjet;
	@EJB
	private IDaoListeProposition proxyDaoAjouterListe;
	@EJB
	private IDaoValeur proxyDaoValeur;
	@EJB
	private IDaoObjet proxyDaoAjouterObjet;
	private String intitule;
	private String description;
	private Domaine selectedDomaine = new Domaine();
	private List<Domaine> domaines;
	private Categorie selectedCategorie = new Categorie();
	private List<Categorie> categories;
	private Souscategorie selectedSousCategorie = new Souscategorie();
	private List<Souscategorie> sousCategories;
	private List<ListeProposition> listePropositions;
	private ListeProposition selectedListeProposition = new ListeProposition();
	private Participant participant;
	private ListeProposition nouvelleListeProposition = new ListeProposition();
	private String nom;
	private Valeur valeur;
	private boolean actif;
	private Objet objetNouveau = new Objet();
	
	
	@PostConstruct
	public void init(){
		participant = proxyAjouterObjet.rechercherParticipantParId(2);
		domaines = proxyAjouterObjet.rechercherDomaine();
		selectedDomaine = new Domaine();
		selectedDomaine.setIddomaine(domaines.get(0).getIddomaine());
		chargerCategories();
		categories = proxyAjouterObjet.rechercherCategorie();
		chargerSousCategorie();
		selectedSousCategorie = new Souscategorie();
		selectedSousCategorie.setIdsouscategorie(sousCategories.get(0).getIdsouscategorie());
		chargerListeProposition();
		selectedListeProposition = new ListeProposition();
		selectedListeProposition.setIdlisteobjet(listePropositions.get(0).getIdlisteobjet());
	}
	
	
	public void chargerCategories() {
		categories = proxyAjouterObjet.rechercherCategorieParDomaine(selectedDomaine);
		selectedCategorie = new Categorie();
		selectedCategorie.setIdcategorie(categories.get(0).getIdcategorie());
		sousCategories = proxyAjouterObjet.rechercherSousCategorieParCategorie(selectedCategorie);
	}
	
	public void chargerSousCategorie() {
		sousCategories = proxyAjouterObjet.rechercherSousCategorieParCategorie(selectedCategorie);
	}
	
	public void chargerListeProposition(){
		listePropositions = proxyAjouterObjet.rechercherListeProposition(participant);
		System.out.println(listePropositions);
	}
	
	public ListeProposition ajouterUneListe(){
		nouvelleListeProposition.setParticipant(participant);
		nouvelleListeProposition.setActif(true);
		proxyDaoAjouterListe.ajouterListeProposition(nouvelleListeProposition);
		listePropositions.add(nouvelleListeProposition);
		return null;
	}
	
	public Objet ajouterObjet(){
		valeur = new Valeur(10);
		valeur = proxyDaoValeur.ajouterValeur(valeur);
		objetNouveau.setActif(true);
		objetNouveau.setCategorie(selectedCategorie);
		objetNouveau.setDateajout(new Date());
		objetNouveau.setDomaine(selectedDomaine);
		objetNouveau.setListeProposition(selectedListeProposition);
		objetNouveau.setSouscategorie(selectedSousCategorie);
		objetNouveau.setTrancheAge(null);
		objetNouveau.setValeur(valeur);
		proxyDaoAjouterObjet.ajouterObjet(objetNouveau);
		return null;
	}

	public IDaoValeur getProxyDaoValeur() {
		return proxyDaoValeur;
	}

	public void setProxyDaoValeur(IDaoValeur proxyDaoValeur) {
		this.proxyDaoValeur = proxyDaoValeur;
	}

	public IDaoObjet getProxyDaoAjouterObjet() {
		return proxyDaoAjouterObjet;
	}

	public void setProxyDaoAjouterObjet(IDaoObjet proxyDaoAjouterObjet) {
		this.proxyDaoAjouterObjet = proxyDaoAjouterObjet;
	}

	public IBusinessAjouterObjet getProxyAjouterObjet() {
		return proxyAjouterObjet;
	}

	public void setProxyAjouterObjet(IBusinessAjouterObjet proxyAjouterObjet) {
		this.proxyAjouterObjet = proxyAjouterObjet;
	}

	public IDaoListeProposition getProxyDaoAjouterListe() {
		return proxyDaoAjouterListe;
	}

	public void setProxyDaoAjouterListe(IDaoListeProposition proxyDaoAjouterListe) {
		this.proxyDaoAjouterListe = proxyDaoAjouterListe;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Domaine getSelectedDomaine() {
		return selectedDomaine;
	}

	public void setSelectedDomaine(Domaine selectedDomaine) {
		System.out.println(selectedDomaine);
		System.out.println(selectedDomaine.getIddomaine());
		
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

	public List<ListeProposition> getListePropositions() {
		return listePropositions;
	}

	public void setListePropositions(List<ListeProposition> listePropositions) {
		this.listePropositions = listePropositions;
	}

	public ListeProposition getSelectedListeProposition() {
		return selectedListeProposition;
	}

	public void setSelectedListeProposition(ListeProposition selectedListeProposition) {
		this.selectedListeProposition = selectedListeProposition;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public ListeProposition getNouvelleListeProposition() {
		return nouvelleListeProposition;
	}

	public void setNouvelleListeProposition(ListeProposition nouvelleListeProposition) {
		this.nouvelleListeProposition = nouvelleListeProposition;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Valeur getValeur() {
		return valeur;
	}

	public void setValeur(Valeur valeur) {
		this.valeur = valeur;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Objet getObjetNouveau() {
		return objetNouveau;
	}

	public void setObjetNouveau(Objet objetNouveau) {
		this.objetNouveau = objetNouveau;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
