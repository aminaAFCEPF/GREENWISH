package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoVille {

	Ville ajouterVille(Ville ville);
	List<Ville> getAllVilles();
	List<Ville> rechercherVille(String codePostal);
}
