package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessAjouterObjet.class)
@Stateless
public class BusinessAjouterObjet implements IBusinessAjouterObjet {

	@EJB
	IDaoObjet proxyDaoObjet;
	@EJB
	IDaoDomaine proxyDaoDomaine;
	@EJB
	IDaoCategorie proxyDaoCategorie;
	@EJB
	IDaoSousCategorie proxyDaoSousCategorie;
	@EJB
	IDaoListeProposition proxyDaoListeProposition;
	@EJB
	IDaoParticipant proxyDaoParticipant;
	
	
	//a ajouter
	public void ajouterObjet(Objet objet,Participant participant) {
		int valeur = objet.getValeur().getValeur();
		int solde = participant.getSolde();
		int nbEspace;
		int longueurDescription = objet.getDescription().length();
		String texteDescription = objet.getDescription();
		if(longueurDescription < 50) {
			nbEspace = 50 - longueurDescription;
			for(int i = 0; i < nbEspace ; i++){
				texteDescription = texteDescription + " ";
			}
		}
		participant.setSolde(solde+valeur);
		proxyDaoParticipant.updateParticipant(participant);
		proxyDaoObjet.ajouterObjet(objet);
	}
	
	public String RemplirEspaces(Objet objet, String description){
		int nbEspace;
		int longueurDescription = objet.getDescription().length();
		String texteDescription = objet.getDescription();
		if(longueurDescription < 50) {
			nbEspace = 50 - longueurDescription;
			for(int i = 0; i < nbEspace ; i++){
				texteDescription = texteDescription + " ";
			}
		}
		return texteDescription;
	}

	@Override
	public List<Domaine> rechercherDomaine() {
		List<Domaine> domaines;
		domaines = proxyDaoDomaine.getAllDomaine();
		return domaines;
	}

	@Override
	public List<Categorie> rechercherCategorie() {
		List<Categorie> categories;
		categories = proxyDaoCategorie.getAllCategorie();
		return categories;
	}
	
	@Override
	public List<ListeProposition> rechercherListeProposition(Participant participant) {
		List<ListeProposition> listePropositions = proxyDaoListeProposition.getAllListePropositions(participant);
		return listePropositions;
	}
	
	@Override
	public List<Categorie> rechercherCategorieParDomaine(Domaine domaine) {
		List<Categorie> categoriesParDomaine = proxyDaoCategorie.rechercherCategorieByDomaine(domaine);
		return categoriesParDomaine;
	}

	@Override
	public List<Souscategorie> rechercherSousCategorieParCategorie(Categorie categorie) {
		List<Souscategorie> sousCategorieParCategorie = proxyDaoSousCategorie.rechercherSousCategorieByCategorie(categorie);
		return sousCategorieParCategorie;
	}
	
	@Override
	public List<Souscategorie> rechercherSousCategorie() {
		List<Souscategorie> sousCategories;
		sousCategories = proxyDaoSousCategorie.getAllSousCategorie();
		return sousCategories;
	}
	
	@Override
	public Participant rechercherParticipantParId(int idParticipant) {
		Participant participant = proxyDaoParticipant.rechercherParticipantParId(idParticipant);
		return participant;
	}
	
	@Override
	public ListeProposition ajouterUneListe(ListeProposition listeProposition) {
		proxyDaoListeProposition.ajouterListeProposition(listeProposition);
		return listeProposition;
	}
	
	
	//a rajouter
	@Override
	public Participant ajouterPointsAUnParticipant(Participant participant) {
	
		return null;
	}
	
	

	public IDaoObjet getProxyDaoObjet() {
		return proxyDaoObjet;
	}

	public void setProxyDaoObjet(IDaoObjet proxyDaoObjet) {
		this.proxyDaoObjet = proxyDaoObjet;
	}

	public IDaoDomaine getProxyDaoDomaine() {
		return proxyDaoDomaine;
	}

	public void setProxyDaoDomaine(IDaoDomaine proxyDaoDomaine) {
		this.proxyDaoDomaine = proxyDaoDomaine;
	}

	public IDaoCategorie getProxyDaoCategorie() {
		return proxyDaoCategorie;
	}

	public void setProxyDaoCategorie(IDaoCategorie proxyDaoCategorie) {
		this.proxyDaoCategorie = proxyDaoCategorie;
	}

	public IDaoSousCategorie getProxyDaoSousCategorie() {
		return proxyDaoSousCategorie;
	}

	public void setProxyDaoSousCategorie(IDaoSousCategorie proxyDaoSousCategorie) {
		this.proxyDaoSousCategorie = proxyDaoSousCategorie;
	}

	

	

	

	

	

	


}
