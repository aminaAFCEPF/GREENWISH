package fr.afcepf.ai100.g3;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote
@Singleton
public class DaoMessagerie implements IDaoMessagerie{

	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	
	@Override
	public Messagerie getMessagerieByIdParticipant(int id) {
		final String req = "SELECT * FROM messagerie m WHERE m.IDPARTICIPANT = :pidparticipant";
		Query query = em.createQuery(req).setParameter("pidparticipant", id);
		return (Messagerie) query.getSingleResult();
	}

	@Override
	public Messagerie getMessagerieById(int id) {
		final String req = "SELECT * FROM messagerie m WHERE m.IDMESSAGERIE = :pidmessagerie";
		Query query = em.createQuery(req).setParameter("pidActualite", id);
		return (Messagerie) query.getSingleResult();
	}
	
}
