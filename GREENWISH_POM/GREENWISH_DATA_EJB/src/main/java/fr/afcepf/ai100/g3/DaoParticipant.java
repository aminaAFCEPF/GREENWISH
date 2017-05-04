package fr.afcepf.ai100.g3;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai100.g3.Participant;

@Remote(IDaoParticipant.class)
@Singleton
public class DaoParticipant implements IDaoParticipant {

	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	EntityManager em;

	@SuppressWarnings("unchecked")

	@Override
	public Participant ajouter(Participant participant) {
		em.persist(participant);
		return participant;
	}

	@Override
	public Participant identification(String mail, String mdp) {
		final String req = "SELECT p FROM Participant p WHERE p.mail = :pmail AND p.password = :ppassword";
		Query query = em.createQuery(req).setParameter("pmail", mail).setParameter("ppassword", mdp);
		Participant retour = null;
		try {
			retour = (Participant) query.getSingleResult();
		} catch (Exception e) {
			// catch misère...
		}
		return retour;
	}
}