package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.ai100.g3.Participant;

@Remote(IDaoParticipant.class)
@Singleton
public class DaoParticipant implements IDaoParticipant {

	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	EntityManager em;

	@SuppressWarnings("unchecked")

	@Override
	public Participant ajouter(Participant participant) {		
		em.persist(participant);
		return participant;
	}

	@Override
	public Participant identification(String mail, String mdp) {
		final String req = "SELECT p FROM Participant p INNER JOIN FETCH p.ville WHERE p.mail = :pmail AND p.password = :ppassword";
		Query query = em.createQuery(req).setParameter("pmail", mail).setParameter("ppassword", mdp);
		Participant retour = null;
		try {
			retour = (Participant) query.getSingleResult();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return retour;
	}

	@Override
	public Participant rechercherParticipantParId(int idParticipant) {
		Participant retour = null;
		final String req="SELECT p FROM Participant p WHERE p.id = :pid";
		Query query = em.createQuery(req).setParameter("pid", idParticipant);
		retour = (Participant)query.getSingleResult();
		retour.getAvis().size();
		return retour;
	}


	@Override
	public Participant updateParticipant(Participant participant) {
		em.merge(participant);
		return participant;
	}

	@Override
	public void deleteParticipant(Participant participant) {
		em.remove(participant);
	}


	@Override
	public List<Notification> rechercherNotifByIdParticipant(int idParticipant) {
		final String req = "SELECT p.notifications FROM Participant p WHERE p.idparticipant = :idParticipant";
		Query query = em.createQuery(req).setParameter("idParticipant", idParticipant);
		return query.getResultList();
	}


	@Override
	public Participant recupProprio(int Idobjet) {
		final String req="SELECT o.listeProposition.participant FROM Objet o WHERE o.idobjet = :pIdobjet";
		Query query = em.createQuery(req).setParameter("pIdobjet", Idobjet);
		Participant participantRetour = (Participant)query.getSingleResult();
		participantRetour.getAvis().size();
		return participantRetour;
	}

	@Override
	public List<Objet> getAllObjetByIdParticipant(int idParticipant) {
		final String req = "Select o FROM Objet o WHERE o.listeProposition.participant.idparticipant = :pidParticipant";
		
		Query query = em.createQuery(req).setParameter("pidParticipant", idParticipant);
		return query.getResultList();
	}
}

