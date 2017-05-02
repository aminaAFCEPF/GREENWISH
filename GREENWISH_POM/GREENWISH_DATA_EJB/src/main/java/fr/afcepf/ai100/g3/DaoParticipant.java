package fr.afcepf.ai100.g3;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai100.g3_2.Participant;

@Remote(IDaoParticipant.class)
@Singleton
public class DaoParticipant implements IDaoParticipant{

	@PersistenceContext(unitName="GREENWISH_DATA_EJB")
	EntityManager em;
	@SuppressWarnings("unchecked")
	
	@Override
	public Participant ajouter(Participant participant) {
		em.persist(participant);
		return participant;
	}

	
	
}
