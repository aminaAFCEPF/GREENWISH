package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoFavoris {
	
	Favoris ajouterFavoris(Favoris favoris);
	Favoris updateFavoris(Favoris favoris);
	void supprimerFavoris(Favoris favoris);
	Favoris rechercherFavorisParId(int idFavoris);
	List<Favoris> getAllFavoris();
	
}
