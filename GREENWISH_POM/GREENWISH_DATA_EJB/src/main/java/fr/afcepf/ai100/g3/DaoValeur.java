package fr.afcepf.ai100.g3;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Remote(IDaoValeur.class)
@Singleton
public class DaoValeur implements IDaoValeur {

	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Valeur ajouterValeur(Valeur valeur) {
		em.persist(valeur);
		return valeur;
	}
	
	

}
