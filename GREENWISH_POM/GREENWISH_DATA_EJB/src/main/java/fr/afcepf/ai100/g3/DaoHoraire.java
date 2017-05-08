package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoHoraire.class)
@Singleton
public class DaoHoraire implements IDaoHoraire{
	
	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")

	@Override
	public List<Horaire> getHoraireByIdParticipant(int id) {
		String req ="SELECT h FROM Horaire h INNER JOIN Jour j ON j.idjour = h.jour.idjour AND INNER JOIN Disponibilite d ON d.iddisponibilite = j.disponibilite.iddisponibilite WHERE d.participant.idparticipant = :pidParticipant";
		Query query = em.createQuery(req).setParameter("pidParticipant", id);
		return query.getResultList();
	}

	@Override
	public List<Horaire> getHoraireByIdJour(int id) {
		String req ="SELECT h FROM Horaire h WHERE h.jour.idjour = :pidJour";
		Query query = em.createQuery(req).setParameter("pidJour", id);
		return query.getResultList();
	}

	@Override
	public Horaire ajouterHoraire(Horaire horaire) {
		em.persist(horaire);
		return horaire;
	}

	@Override
	public void deleteHoraire(Horaire horaire) {
		em.remove(horaire);
	}

	@Override
	public Horaire updateHoraire(Horaire horaire) {
		em.merge(horaire);
		return horaire;
	}
	
	
	
	

}
