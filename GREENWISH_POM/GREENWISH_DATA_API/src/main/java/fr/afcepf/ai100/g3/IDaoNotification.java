package fr.afcepf.ai100.g3;

public interface IDaoNotification {

	Notification ajouterNotification(Notification notification);
	Notification updateNotification(Notification notifcation);
	void deleteNotification(Notification notification);
	
}
