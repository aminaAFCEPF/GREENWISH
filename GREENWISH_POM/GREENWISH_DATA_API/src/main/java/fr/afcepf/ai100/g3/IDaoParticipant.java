package fr.afcepf.ai100.g3;

import java.util.List;

import fr.afcepf.ai100.g3.Participant;

public interface IDaoParticipant {

	Participant  ajouter(Participant participant);
	
	Participant identification(String mail, String mdp);
	
	Participant rechercherParticipantParId(int idParticipant);
	
	Participant updateParticipant(Participant participant);
	
	void deleteParticipant(Participant participant);
	
	List<Notification> rechercherNotifByIdParticipant(int idParticipant);
	
	List<Objet> getAllObjetByIdParticipant(int idParticipant);

	Participant recupProprio(int Idobjet);
	
	List<Objet> recupObjetsParticipant(int idParticipant);


}
