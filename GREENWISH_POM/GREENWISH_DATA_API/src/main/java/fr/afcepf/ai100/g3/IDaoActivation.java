package fr.afcepf.ai100.g3;

import java.util.Date;
import java.util.List;

public interface IDaoActivation {

	Participant activer(Participant participant, Date dateActivation);
	int desactiver(Participant participant, Date dateDesactivation);
	List<Participant> rechercherActives();
	List<Participant> rechercherDesactives();
	
	
}
