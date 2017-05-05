package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoActualite {

	Actualite ajouterActualite (Actualite actualite);
	Actualite publicationActualite (Actualite actualite, boolean actif);
	Actualite updateActualite (Actualite actualite, String image, String texte, String titre);
	void deleteActualite (Actualite actualite);
	Actualite getActualiteById (int id);
	List<Actualite> getAllActualite();
}
