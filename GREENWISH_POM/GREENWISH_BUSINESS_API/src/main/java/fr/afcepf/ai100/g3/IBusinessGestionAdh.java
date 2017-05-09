package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessGestionAdh {
	
	List<Notification> rechercherNotificationNonLuesByParticipant(int idParticipant);
	
	List<Objet> getAllObjetsByIdParticipant(int idParticipant);

}
