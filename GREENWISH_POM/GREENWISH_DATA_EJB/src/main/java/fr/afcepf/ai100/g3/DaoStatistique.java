package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoStatistique.class)
@Singleton
public class DaoStatistique implements IDaoStatistique {

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	
	@Override
	public List<Statistique> getAllStatistique() {
		String req = "SELECT s FROM Statistique s";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public Statistique getStatistiqueById(int idStatistique) {
		String req = "SELECT s from Statistique s WHERE s.idstat = :pid";
		Query query =em.createQuery(req).setParameter("pid", idStatistique);
		return (Statistique) query.getSingleResult();
	}
}
