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
		final String req = "SELECT * FROM disponibilite d WHERE d.IDPARTICIPANT = :pid";
		Query query = em.createQuery(req);
		return (Disponibilite) query.getSingleResult();
	}

	@Override
	public Disponibilite getDisponibiliteById(int id) {
		final String req = "SELECT * FROM disponibilite d WHERE d.IDDISPO = :pid";
		Query query = em.createQuery(req).setParameter("pid", id);
		return (Disponibilite) query.getSingleResult();
	}

}
