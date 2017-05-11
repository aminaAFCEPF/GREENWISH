package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessGestionEchange {
	List<Echange> afficherTousLesEchangesDUnParticipant(int idParticipant);
	List<Echange> afficherLesEchangesTerminesDUnParticipant(int idParticipant);
	List<Echange> afficherLesEchangesEnCoursDUnParticipant(int idParticipant);
	
	List<Echange> trierTousLesEchangeParType(String type,int Participant);
	List<Echange> afficherEchangesTries(String etat,String type,int Participant);
	
	List<Echange> trierEchangeEnCoursParType(String type, int idParticipant);
	List<Echange> trierEchangeTerminesParType(String type, int idParticipant);
	List<Echange> afficherLesEchangesTries(String etat, String type, int idParticipant);
}
