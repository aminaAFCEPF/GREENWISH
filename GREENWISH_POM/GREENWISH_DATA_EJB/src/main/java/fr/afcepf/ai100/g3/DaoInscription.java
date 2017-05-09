package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoInscription.class)
@Singleton
public class DaoInscription implements IDaoInscription {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Inscription ajouterInscription(Inscription inscription) {
		em.persist(inscription);
		return inscription;
	}

	@Override
	public Inscription updateInscription(Inscription inscription) {
		em.merge(inscription);
		return inscription;
	}

	@Override
	public void deleteInscription(Inscription inscription) {
		em.remove(inscription);
	}

	@Override
	public Inscription getInscriptionByIdParticipant(int idParticipant) {
		String req = "SELECT i FROM Inscription i WHERE i.participant.idparticipant = :pid";
		Query query = em.createQuery(req).setParameter("pid", idParticipant);
		return (Inscription) query.getSingleResult();
	}

	@Override
	public List<Inscription> getAllInscription() {
		String req = "SELECT i FROM Inscription i";
		Query query = em.createQuery(req);
		return query.getResultList();
	}
	
	
	
}
