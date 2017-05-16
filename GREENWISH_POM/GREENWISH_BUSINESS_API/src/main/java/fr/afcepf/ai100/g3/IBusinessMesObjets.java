package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessMesObjets {
	
	List<Objet> AfficherObjetParIdParticipant(int idParticipant);
	void supprimerObjet(Objet objet);
	List<Objet> AfficherTousObjets();
}
