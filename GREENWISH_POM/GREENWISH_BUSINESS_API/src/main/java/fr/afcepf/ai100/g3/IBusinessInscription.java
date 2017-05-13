package fr.afcepf.ai100.g3;

import fr.afcepf.ai100.g3.Participant;

public interface IBusinessInscription {

	Participant inscrire(Participant participant);
	
	ListeProposition creerListeProp(ListeProposition listeproposition);
	
}
