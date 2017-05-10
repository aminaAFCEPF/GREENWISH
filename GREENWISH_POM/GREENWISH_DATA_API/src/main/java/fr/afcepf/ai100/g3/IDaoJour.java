package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoJour {

	List<Jour> getJourByIdParticipant (int id);
	Jour getJourByIdJour (int id);
	Jour ajouterJour(Jour jour);
	void deleteJour(Jour jour);
	Jour updateJour(Jour jour);
}
