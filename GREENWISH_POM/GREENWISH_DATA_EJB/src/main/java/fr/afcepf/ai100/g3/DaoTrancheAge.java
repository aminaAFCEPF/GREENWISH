package fr.afcepf.ai100.g3;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Remote(IDaoTrancheAge.class)
@Singleton
public class DaoTrancheAge implements IDaoTrancheAge {

	@PersistenceContext(unitName="GREENWISH_DATA_EJB")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public TrancheAge ajouterTrancheAge(TrancheAge trancheAge) {
		em.persist(trancheAge);
		return trancheAge;
	}

}
