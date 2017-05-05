package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoActualite.class)
@Singleton
public class DaoActualite implements IDaoActualite{

	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	
	@Override
	public Actualite ajouterActualite(Actualite actualite) {
		em.persist(actualite);
		return actualite;
	}

	@Override
	public void deleteActualite(Actualite actualite) {
		em.remove(actualite);
	}

	@Override
	public Actualite publicationActualite(Actualite actualite, boolean actif) {
		actualite.setActif(actif);
		em.merge(actualite);
		return actualite;
	}

	@Override
	public Actualite updateActualite(Actualite actualite, String image, String texte, String titre) {
		actualite.setImage(image);
		actualite.setTexte(texte);
		actualite.setTitre(titre);
		em.merge(actualite);
		return actualite;
	}

	@Override
	public Actualite getActualiteById(int id) {
		final String req = "SELECT * FROM actualite a WHERE a.IDACTU = :pidActualite";
		Query query = em.createQuery(req).setParameter("pidActualite", id);
		return (Actualite) query.getSingleResult();
	}

	@Override
	public List<Actualite> getAllActualite() {
		final String req = "SELECT * FROM actualite";
		Query query = em.createQuery(req);
		return query.getResultList();
	}
	
	

}
