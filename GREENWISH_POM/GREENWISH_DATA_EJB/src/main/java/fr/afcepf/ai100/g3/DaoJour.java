package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoJour.class)
@Singleton
public class DaoJour implements IDaoJour {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Jour> getJourByIdParticipant(int id) {
		String req = "SELECT j FROM Jour j INNER JOIN Disponibilite d ON d.iddisponibilite = j.disponibilite.iddisponibilite WHERE d.participant.idparticipant = :pidparticipant";
		Query query = em.createNamedQuery(req).setParameter("pidparticipant", id);
		return query.getResultList();
	}

	@Override
	public Jour getJourByIdJour(int id) {
		String req = "SELECT j FROM Jour j WHERE j.idjour = :pid";
		Query query = em.createQuery(req).setParameter("pid", id);
		return (Jour)query.getSingleResult();
	}
	
	

	
	
	@Override
	public Jour ajouterJour(Jour jour) {
		em.persist(jour);
		return jour;
	}

	@Override
	public void deleteJour(Jour jour) {
		em.remove(jour);
	}

	@Override
	public Jour updateJour(Jour jour) {
		em.merge(jour);
		return jour;
	}
}
