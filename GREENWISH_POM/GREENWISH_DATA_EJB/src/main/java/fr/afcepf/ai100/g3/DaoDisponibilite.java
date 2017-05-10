package fr.afcepf.ai100.g3;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoDisponibilite.class)
@Singleton
public class DaoDisponibilite implements IDaoDisponibilite{

	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	
	@Override
	public Disponibilite getDisponibiliteByIdParticipant(int id) {
		final String req = "SELECT d FROM Disponibilite d WHERE d.participant.idparticipant = :pid";
		Query query = em.createQuery(req);
		return (Disponibilite) query.getSingleResult();
	}
	

	@Override
	public Disponibilite getDisponibiliteById(int id) {
		final String req = "SELECT d FROM Disponibilite d WHERE d.iddispo = :pid";
		Query query = em.createQuery(req).setParameter("pid", id);
		return (Disponibilite) query.getSingleResult();
	}


	@Override
	public Disponibilite ajouterDisponibilite(Disponibilite disponibilite) {
		em.persist(disponibilite);
		return disponibilite;
	}


	@Override
	public Disponibilite updateDisponibilite(Disponibilite disponibilite) {
		em.merge(disponibilite);
		return disponibilite;
	}


	@Override
	public void deleteDisponibilite(Disponibilite disponibilite) {
		em.remove(disponibilite);
	}

}
