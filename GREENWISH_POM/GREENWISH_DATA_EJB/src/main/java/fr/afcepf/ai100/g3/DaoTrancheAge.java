package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public List<TrancheAge> getAllTrancheAge() {
		String req ="SELECT t FROM TrancheAge t";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

}
