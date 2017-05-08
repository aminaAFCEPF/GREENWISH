package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoRdv.class)
@Singleton
public class DaoRdv implements IDaoRdv{

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Rdv ajouterRdv(Rdv rdv) {
		em.persist(rdv);
		return rdv;
	}

	@Override
	public Rdv updateRdv(Rdv rdv) {
		em.merge(rdv);
		return rdv;
	}

	@Override
	public void deleteRdv(Rdv rdv) {
		em.remove(rdv);
	}

	@Override
	public Rdv getRdvByIdEchange(int idEchange) {
		String req = "SELECT r FROM Rdv r WHERE r.echange.idechange = :pid";
		Query query = em.createQuery(req).setParameter("pid", idEchange);
		return (Rdv) query.getSingleResult();
	}

	@Override
	public List<Rdv> getAllRdv() {
		String req = "SELECT r FROM Rdv r";
		Query query = em.createQuery(req);
		return query.getResultList();
	}
	
	
}
