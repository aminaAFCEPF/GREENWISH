package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoFavoris.class)
@Singleton
public class DaoFavoris implements IDaoFavoris {
	
	@PersistenceContext(unitName="GREENWISH_DATA_EJB")
	@SuppressWarnings("unchecked")
	EntityManager em;

	@Override
	public Favoris ajouterFavoris(Favoris favoris) {
			em.persist(favoris);
		return favoris;
	}
	@Override
	public Favoris updateFavoris(Favoris favoris) {
		em.merge(favoris);
		return favoris;
	}
	@Override
	public void supprimerFavoris(Favoris favoris) {
		em.remove(favoris);
		
	}
	@Override
	public Favoris rechercherFavorisParId(int idFavoris) {
		final String req = "SELECT f FROM Favoris f WHERE idfavoris = :pidFavoris";
		Query query = em.createQuery(req).setParameter("pidFavoris", idFavoris);
		return (Favoris)query.getSingleResult();
	}
	@Override
	public List<Favoris> getAllFavoris() {
		final String req = "SELECT f FROM Favoris f";
		Query query = em.createQuery(req);
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Favoris> rechercherFavorisParIdParticipant(int idParticipant) {
		final String req = "SELECT f FROM Favoris f inner join fetch f.objet o inner join fetch o.listeProposition l inner join fetch l.participant WHERE f.objet.listeProposition.participant.idparticipant = :pidParticipant";
		Query query = em.createQuery(req).setParameter("pidParticipant", idParticipant);
		return query.getResultList();
	}
}
