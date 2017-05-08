package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoLitige.class)
@Singleton
public class DaoLitige implements IDaoLitige{

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Litige> GetLitigeByIdEchange(int idEchange) {
		String req = "SELECT l FROM Litige l WHERE l.echange.idechange = :pid";
		Query query = em.createQuery(req).setParameter("pid", idEchange);
		return query.getResultList();
	}

	@Override
	public List<Litige> GetAllLitige() {
		String req = "SELECT l FROM Litige l";
		Query query = em.createQuery(req);
		return query.getResultList();
	}


	@Override
	public Litige ajouterLitige(Litige litige) {
		em.persist(litige);
		return litige;
	}

	@Override
	public Litige updateLitige(Litige litige) {
		em.merge(litige);
		return litige;
	}

	@Override
	public void deleteLitige(Litige litige) {
		em.remove(litige);
	}
}
