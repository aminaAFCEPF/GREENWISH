package fr.afcepf.ai100.g3;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoMessagerie.class)
@Singleton
public class DaoMessagerie implements IDaoMessagerie{

	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	
	@Override
	public Messagerie getMessagerieByIdParticipant(int id) {
		final String req = "SELECT m FROM Messagerie m WHERE m.participant.idparticipant = :pidparticipant";
		Query query = em.createQuery(req).setParameter("pidparticipant", id);
		return (Messagerie) query.getSingleResult();
	}

	@Override
	public Messagerie getMessagerieById(int id) {
		final String req = "SELECT m FROM Messagerie m WHERE m.idmessagerie = :pidmessagerie";
		Query query = em.createQuery(req).setParameter("pidmessagerie", id);
		return (Messagerie) query.getSingleResult();
	}
	
}
