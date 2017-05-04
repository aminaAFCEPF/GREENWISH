package fr.afcepf.ai100.g3;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Remote(IDaoFavoris.class)
@Singleton
public class DaoFavoris implements IDaoFavoris {
	
	@PersistenceContext(unitName="GREENWISH_DATA_EJB")
	EntityManager em;
	@SuppressWarnings("unchecked")
	
	@Override
	public Favoris ajouterFavoris(Favoris favoris) {
			em.persist(favoris);
		return favoris;
	}
}
