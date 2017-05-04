package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoCategorie {

	List<Categorie> getAllCategorie();
	List<Categorie> rechercherCategorieByDomaine(Domaine domaine);
	
}
