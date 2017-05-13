package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessRecherche.class)
@Stateless
public class BusinessRecherche implements IBusinessRecherche {

	@EJB
	IDaoObjet proxyDaoObjet;
	@EJB
	IDaoDomaine proxyDaoDomaine;
	@EJB
	IDaoCategorie proxyDaoCategorie;
	@EJB
	IDaoSousCategorie proxyDaoSousCategorie;
	@EJB
	IDaoValeur proxyDaoValeur;
	@EJB
	IDaoTrancheAge proxyDaoTrancheAge;
	
	
	
	@Override
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
	public List<Valeur> rechercherValeur() {
		List<Valeur> valeurs;
		valeurs = proxyDaoValeur.getAllValeur();
		return valeurs;
	}

	@Override
	public List<TrancheAge> rechercherTrancheAge() {
		List<TrancheAge> trancheAges;
		trancheAges = proxyDaoTrancheAge.getAllTrancheAge();
		return trancheAges;
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

	@Override
	public List<Objet> rechercherObjet(String rDomaine, String rCategorie, String rSousCategorie, String rValeur) {
		List<Objet> objets;
		
		if(!rDomaine.equals("%%")){
			rDomaine = proxyDaoDomaine.getIntituleById(Integer.parseInt(rDomaine));
			System.out.println("Le critère Domaine est rempli, je recupere l'intitulé");
			}
		
		if(!rCategorie.equals("%%")){
			rCategorie = proxyDaoCategorie.getIntituleById(Integer.parseInt(rCategorie));
			System.out.println("Le critère Categorie est rempli, je recupere l'intitulé");
			}
		
		if(!rSousCategorie.equals("%%")){
			rSousCategorie = proxyDaoSousCategorie.getIntituleById(Integer.parseInt(rSousCategorie));
			System.out.println("Le critère Sous-Categorie est rempli, je recupere l'intitulé");
			}
		
		objets = proxyDaoObjet.rechercherObjetByAlgo(rDomaine, rCategorie, rSousCategorie, rValeur);
		System.out.println("coucou Business");
		return objets;
	}
	
	public String getIntituleDomaineById(int idDomaine){
		String retour = proxyDaoDomaine.getIntituleById(idDomaine);
		return retour;
	}

}
