package fr.afcepf.ai100.g3;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Remote(IDaoVille.class)
@Singleton
public class DaoVille implements IDaoVille{

	
	@PersistenceContext(unitName="GREENWISH_DATA_EJB")
	EntityManager em;
	@SuppressWarnings("unchecked")
	
	
	@Override
	public Ville ajouterVille(Ville ville) {
		em.persist(ville);
		return ville;
	}

}
