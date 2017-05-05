package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoImage.class)
@Singleton
public class DaoImage implements IDaoImage{

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	
	@Override
	public Image ajouterImage(Image image) {
		em.persist(image);	
		return image;
	}

	@Override
	public void deleteImage(Image image) {
		em.remove(image);
	}

	@Override
	public List<Image> getImageByIdObjet(int id) {
		String req = "SELECT i FROM Image i WHERE i.objet.idobjet = :pidObjet";
		Query query = em.createQuery(req).setParameter("pidImage", id);
		return query.getResultList();
	}

	@Override
	public Image updateImage(Image image) {
		em.merge(image);
		return image;
	}
	

	
	
	
}
