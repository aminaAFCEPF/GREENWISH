package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessGestionAdh.class)
@Stateless
public class BusinessGestionAdh implements IBusinessGestionAdh {

	@EJB
	IDaoParticipant proxyDaoParticipant;
	
	@EJB
	IDaoObjet proxyDaoObjet;
	
	@Override
	public List<Notification> rechercherNotificationNonLuesByParticipant(int idParticipant) {
		List<Notification> notifs;
		List<Notification> notifsNonLues = new ArrayList<>();
		notifs = proxyDaoParticipant.rechercherNotifByIdParticipant(idParticipant);
		for (Notification notif : notifs){
			if (!notif.isLu()){
				notifsNonLues.add(notif);
			}
		}
		return notifsNonLues;
	}

	@Override
	public List<Objet> getAllObjetsByIdParticipant(int idParticipant) {
		
		return proxyDaoObjet.getAllObjetsByIdParticipant(idParticipant);
	}
	
	

}
