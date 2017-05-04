package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoDomaine.class)
@Singleton
public class DaoDomaine implements IDaoDomaine{

	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Domaine> getAllDomaine() {
		String req = "SELECT d FROM Domaine d";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

}
