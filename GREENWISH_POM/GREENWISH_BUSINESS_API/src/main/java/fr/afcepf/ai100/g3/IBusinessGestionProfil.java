package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessGestionProfil {
	Participant rechercherParticipantById(int idParticipant);
	void updateParticipant(Participant participant);
	
	List<Ville> rechercherVille(String codePostal);

	

}
