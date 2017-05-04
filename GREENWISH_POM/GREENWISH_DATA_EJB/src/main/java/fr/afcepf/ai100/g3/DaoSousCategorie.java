package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoSousCategorie.class)
@Singleton
public class DaoSousCategorie implements IDaoSousCategorie {

	@PersistenceContext(unitName ="GREENWISH_DATA_EJB")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Souscategorie> getAllSousCategorie() {
		String req = "SELECT s FROM Souscategorie s";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Souscategorie> rechercherSousCategorieByCategorie(Categorie categorie) {
		final String req = "SELECT s FROM Souscategorie s WHERE s.categorie.id = :pid";
		Query query = em.createQuery(req).setParameter("pid", categorie.getIdcategorie());
		return query.getResultList();
	}
	
	

}
