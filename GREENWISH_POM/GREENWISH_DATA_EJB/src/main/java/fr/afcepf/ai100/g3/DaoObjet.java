package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoObjet.class)
@Singleton
public class DaoObjet implements IDaoObjet{

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Objet ajouterObjet(Objet objet) {
		em.persist(objet);
		return objet;
	}


	@Override
	public List<Objet> rechercherObjetsParDomaine(Domaine domaine) {
		final String req = "SELECT o FROM objet o WHERE domaine = :pdomaine";
		Query query = em.createQuery(req).setParameter("pdomaine", domaine);
		return query.getResultList();
	}


}
