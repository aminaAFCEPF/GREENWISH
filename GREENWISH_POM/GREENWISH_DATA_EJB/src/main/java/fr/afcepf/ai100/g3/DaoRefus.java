package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoRefus.class)
@Singleton
public class DaoRefus implements IDaoRefus{

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Refus ajouterRefus(Refus refus) {
		em.persist(refus);
		return refus;
	}

	@Override
	public Refus updateRefus(Refus refus) {
		em.merge(refus);
		return refus;
	}

	@Override
	public void deleteRefus(Refus refus) {
		em.remove(refus);
	}

	@Override
	public Refus getRefusByIdEchange(int id) {
		String req = "SELECT r FROM Refus r WHERE echanges.idechange = :pid";
		Query query  = em.createQuery(req).setParameter("pid", id);
		return (Refus) query.getSingleResult();
	}

	@Override
	public List<Refus> getAllRefus() {
		String req = "SELECT r FROM Refus r";
		Query query = em.createQuery(req);
		return query.getResultList();
	}
	
	
	
}
