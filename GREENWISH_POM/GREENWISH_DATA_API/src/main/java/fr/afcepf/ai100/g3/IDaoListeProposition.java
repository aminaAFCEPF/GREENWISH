package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoListeProposition {
	ListeProposition ajouterListeProposition(ListeProposition listeProposition);
	void supprimerListeProposition(ListeProposition listeProposition);
	List<ListeProposition> getAllListePropositions(Participant participant);
	

}
