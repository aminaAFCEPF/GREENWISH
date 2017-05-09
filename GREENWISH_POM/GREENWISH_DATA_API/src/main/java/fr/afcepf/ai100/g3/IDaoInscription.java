package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoInscription {

	Inscription ajouterInscription (Inscription inscription);
	Inscription updateInscription (Inscription inscription);
	void deleteInscription (Inscription inscription);
	Inscription getInscriptionByIdParticipant (int idParticipant);
	List<Inscription> getAllInscription (); 
}
