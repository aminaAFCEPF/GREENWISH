package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessRecherche {
	
	List<Souscategorie> rechercherSousCategorie();
	List<Souscategorie> rechercherSousCategorieParCategorie(Categorie categorie);
	List<Categorie> rechercherCategorieParDomaine(Domaine domaine);
	List<Categorie> rechercherCategorie();
	List<Domaine> rechercherDomaine();
	List<Valeur> rechercherValeur();
	List<TrancheAge> rechercherTrancheAge();
	List<Objet> rechercherObjet(String rDomaine, String rCategorie, String rSousCategorie, String rValeur);
	String RemplirEspaces(Objet objet, String description);
}
