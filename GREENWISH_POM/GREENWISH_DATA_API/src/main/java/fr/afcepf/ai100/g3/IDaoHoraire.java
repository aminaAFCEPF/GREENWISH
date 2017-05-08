package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoHoraire {

	List<Horaire> getHoraireByIdParticipant (int id);
	List<Horaire> getHoraireByIdJour (int id);
	Horaire ajouterHoraire(Horaire horaire);
	void deleteHoraire(Horaire horaire);
	Horaire updateHoraire(Horaire horaire);
}
