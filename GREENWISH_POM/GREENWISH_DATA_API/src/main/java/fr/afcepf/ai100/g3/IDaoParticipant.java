package fr.afcepf.ai100.g3;

import fr.afcepf.ai100.g3.Participant;

public interface IDaoParticipant {

	Participant  ajouter(Participant participant);
	
	Participant identification(String mail, String mdp);
	
	Participant rechercherParticipantParId(int idParticipant);
	
	Participant updateParticipant(Participant participant);
	
	void deleteParticipant(Participant participant);
}
