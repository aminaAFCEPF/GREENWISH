package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Remote(IDaoNotification.class)
@Singleton
public class DaoNotification implements IDaoNotification{

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	
	@Override
	public Notification ajouterNotification(Notification notification) {
		em.persist(notification);
		return notification;
	}

	@Override
	public Notification updateNotification(Notification notifcation) {
		em.merge(notifcation);
		return notifcation;
	}

	@Override
	public void deleteNotification(Notification notification) {
		em.remove(notification);
	}

	
	
	
}
