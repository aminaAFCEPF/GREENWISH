package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	@Override
	public List<Ville> getAllVilles() {
		final String req = "SELECT v FROM Ville v";
		Query query = em.createQuery(req);
		return query.getResultList();
	}
	@Override
	public List<Ville> rechercherVille(String codePostal) {
		final String req = "SELECT v FROM Ville v where v.codePostal LIKE :pcode";
		StringBuilder sb = new StringBuilder();
		sb.append(codePostal).append("%");
		Query query = em.createQuery(req).setParameter("pcode", sb.toString());
		return query.getResultList();
	}

}
