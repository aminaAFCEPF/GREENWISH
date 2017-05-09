package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public Valeur updateValeur(Valeur valeur) {
		em.merge(valeur);
		return valeur;
	}

	@Override
	public void deleteValeur(Valeur valeur) {
		em.remove(valeur);
	}

	@Override
	public Valeur getValeurById(int idValeur) {
		String req = "SELECT v FROM Valeur v WHERE v.idvaleur = :pid";
		Query query = em.createQuery(req).setParameter("pid", idValeur);
		return (Valeur) query.getSingleResult();
	}

	@Override
	public List<Valeur> getAllValeur() {
		String req = "SELECT v FROM Valeur v";
		Query query = em.createQuery(req);
		return query.getResultList();
	}
	
	

}
