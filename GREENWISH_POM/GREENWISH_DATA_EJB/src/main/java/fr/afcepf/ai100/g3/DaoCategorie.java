package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoCategorie.class)
@Singleton
public class DaoCategorie implements IDaoCategorie{

	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getAllCategorie() {
		String req = "SELECT c FROM Categorie c";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Categorie> rechercherCategorieByDomaine(Domaine domaine) {
		final String req = "SELECT c FROM Categorie c WHERE c.domaine.id = :pid";
		Query query = em.createQuery(req).setParameter("pid", domaine.getIddomaine());
		return query.getResultList();
	}

}
