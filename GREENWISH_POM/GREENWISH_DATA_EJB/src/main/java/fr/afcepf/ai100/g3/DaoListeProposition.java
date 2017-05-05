package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoListeProposition.class)
@Singleton
public class DaoListeProposition implements IDaoListeProposition {
	@PersistenceContext(unitName="GREENWISH_DATA_EJB")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public ListeProposition ajouterListeProposition(ListeProposition listeProposition) {
		em.persist(listeProposition);
		return listeProposition;
	}

	@Override
	public void supprimerListeProposition(ListeProposition listeProposition) {
		em.remove(listeProposition);
	}

	@Override
	public List<ListeProposition> getAllListePropositions(Participant participant) {
		final String req = "SELECT l FROM ListeProposition l WHERE l.participant.id = :pid";
		Query query = em.createQuery(req).setParameter("pid", participant.getIdparticipant());
		return query.getResultList();
		
	}

}
