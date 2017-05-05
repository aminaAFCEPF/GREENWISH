package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoSouhait.class)
@Singleton
public class DaoSouhait implements IDaoSouhait{
	
	@PersistenceContext(unitName="GREENWISH_DATA_EJB")
	@SuppressWarnings("unchecked")
	EntityManager em;
	
	@Override
	public Souhait ajouterSouhait(Souhait souhait) {
		em.persist(souhait);
		return souhait;
	}

	@Override
	public void deleteSouhait(Souhait souhait) {
		em.remove(souhait);
	}

	@Override
	public List<Souhait> getSouhaitByIdParticipant(int idParticipant) {
		String req="SELECT s FROM Souhait s WHERE s.participant.idparticipant =:pidParticipant";
		Query query = em.createQuery(req).setParameter("pidParticipant", idParticipant);		
		return query.getResultList();
	}

}
