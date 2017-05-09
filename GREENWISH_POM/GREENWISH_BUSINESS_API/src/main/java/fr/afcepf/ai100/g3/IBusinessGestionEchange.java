package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessGestionEchange {
	List<Echange> afficherTousLesEchangesDUnParticipant(int idParticipant);
	List<Echange> afficherLesEchangesTerminesDUnParticipant(int idParticipant);

}
