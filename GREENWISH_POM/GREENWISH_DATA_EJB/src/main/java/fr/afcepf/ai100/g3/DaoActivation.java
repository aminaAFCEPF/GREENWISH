package fr.afcepf.ai100.g3;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoActivation.class)
@Stateless
public class DaoActivation implements IDaoActivation {

	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	private EntityManager em;

	@SuppressWarnings("unchecked")

	@Override
	public Participant activer(Participant participant, Date dateActivation) {
		Activation activation = new Activation(participant, dateActivation);
		em.persist(activation);
		participant.getActivations().add(activation);
		return participant;
	}

	@Override
	public int desactiver(Participant participant, Date dateDesactivation) {
		final String req = "UPDATE activation " + "SET DATEDESACTIVATION = :dateDesactivation "
				+ "WHERE IDPARTICIPANT = :idParticipant " + "AND DATEDESACTIVATION IS NULL";
		Query query = em.createQuery(req).setParameter("idParticipant", participant.getIdparticipant())
				.setParameter("dateDesactivation", dateDesactivation);
		int resultReq = query.executeUpdate();
		return resultReq;
	}

	@Override
	public List<Participant> rechercherActives() {
		final String req = "SELECT * FROM participant p INNER JOIN activation a ON a.IDPARTICIPANT = p.IDPARTICIPANT"
				+ " WHERE dateDesactivation IS NULL";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Participant> rechercherDesactives() {
		final String req = "SELECT * FROM participant p INNER JOIN activation a ON a.IDPARTICIPANT = p.IDPARTICIPANT"
				+ " WHERE dateDesactivation IS NOT NULL";
		Query query = em.createQuery(req);
		return query.getResultList();
	}
	


}


	
