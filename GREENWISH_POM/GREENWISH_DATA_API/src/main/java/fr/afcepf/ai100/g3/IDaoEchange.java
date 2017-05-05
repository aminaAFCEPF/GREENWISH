package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoEchange {
	
	Echange ajouterEchange(Echange echange);
	Echange updateEchange(Echange echange);
	void supprimerEchange(Echange echange);
	Echange rechercherEchangeParIdEchange(int idEchange);
	Echange rechercherEchangeParIdObjet(int idObjet);
	List<Echange> rechercherEchangeEnCours(int idParticipant);
	List<Echange> rechercherEchangeTerminés(int idParticipant);
	List<Echange> rechercherTousLesEchanges();
	List<Echange> rechercherEchangesRefuses(int idParticipant);
	List<Echange> rechercherEchangesLitiges(int idParticipant);
	List<Echange> rechercherTousLesEchangesEnCours();
	List<Echange> rechercherTousLesEchangesTermines();
	List<Echange> rechercherTousLesEchangesRefuses();
	List<Echange> rechercherTousLesEchangesLitiges();
	
}
