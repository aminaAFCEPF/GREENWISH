package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoSousCategorie {
	
	List<Souscategorie> getAllSousCategorie();
	List<Souscategorie> rechercherSousCategorieByCategorie(Categorie categorie);

}
