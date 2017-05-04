package fr.afcepf.ai100.g3;

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
	
	private String nomObjet;
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

	@PostConstruct
	public void init(){
		participant = proxyAjouterObjet.rechercherParticipantParId(2);
		domaines = proxyAjouterObjet.rechercherDomaine();
		selectedDomaine = domaines.get(0);
		chargerCategories();
		categories = proxyAjouterObjet.rechercherCategorie();
		selectedCategorie = categories.get(0);
		chargerSousCategorie();
		selectedSousCategorie = sousCategories.get(0);
		chargerListeProposition();
		selectedListeProposition = listePropositions.get(0);
	}
	
	public void chargerCategories() {
		categories = proxyAjouterObjet.rechercherCategorieParDomaine(selectedDomaine);
	}
	
	public void chargerSousCategorie() {
		sousCategories = proxyAjouterObjet.rechercherSousCategorieParCategorie(selectedCategorie);
	}
	
	public void chargerListeProposition(){
		listePropositions = proxyAjouterObjet.rechercherListeProposition(participant);
System.out.println(listePropositions);
	}
	
	public void ajouterUneListe(Participant participant ){
		nouvelleListeProposition = proxyAjouterObjet.ajouterUneListe(nouvelleListeProposition);
	}

	public IBusinessAjouterObjet getProxyAjouterObjet() {
		return proxyAjouterObjet;
	}

	public void setProxyAjouterObjet(IBusinessAjouterObjet proxyAjouterObjet) {
		this.proxyAjouterObjet = proxyAjouterObjet;
	}
	
	

	public String getNomObjet() {
		return nomObjet;
	}

	public void setNomObjet(String nomObjet) {
		this.nomObjet = nomObjet;
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

	public void setCategories(List<Categorie> categorie) {
		this.categories = categorie;
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
	
	
	
	
	
}
