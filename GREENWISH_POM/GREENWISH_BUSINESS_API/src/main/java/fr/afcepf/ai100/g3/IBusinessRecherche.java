package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessRecherche {
	
	TrancheAge rechercherObjetParTrancheAge();
	Domaine rechercherObjetParDomaine();
	Categorie rechercherObjetParCategorie();
	Souscategorie rechercherObjetParSousCategorie();
	Valeur rechercherObjetParValeur();
	
	List<Souscategorie> rechercherSousCategorie();
	List<Souscategorie> rechercherSousCategorieParCategorie(Categorie categorie);
	List<Categorie> rechercherCategorieParDomaine(Domaine domaine);
	List<Categorie> rechercherCategorie();
	List<Domaine> rechercherDomaine();
	List<Valeur> rechercherValeur();
	List<TrancheAge> rechercherTrancheAge();
	
}
