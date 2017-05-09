package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoEchange.class)
@Singleton
public class DaoEchange implements IDaoEchange{

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Echange ajouterEchange(Echange echange) {
		em.persist(echange);
		return echange;
	}

	@Override
	public Echange updateEchange(Echange echange) {
		em.merge(echange);
		return echange;
	}

	@Override
	public void supprimerEchange(Echange echange) {
		em.remove(echange);
		
	}

	@Override
	public Echange rechercherEchangeParIdEchange(int idEchange) {
		final String req ="SELECT e FROM Echange e WHERE idechange = :pidEchange";
		Query query = em.createQuery(req).setParameter("pidEchange", idEchange);
		return (Echange)query.getSingleResult();
	}

	@Override
	public Echange rechercherEchangeParIdObjet(int idObjet) {
		final String req = "SELECT e FROM Echange e WHERE e.objet.idobjet = :pidObjet";
		Query query = em.createQuery(req).setParameter("pidObjet", idObjet);
		return (Echange)query.getSingleResult();
	}

	@Override
	public List<Echange> rechercherEchangeEnCours(int idParticipant) {

		final String req = "SELECT e FROM Echange e INNER JOIN Objet o ON o.objet.idobjet = e.objet.idobjet "
				+ " INNER JOIN ListeProposition lp ON lp.objet.idobjet = e.objet.idobjet "
				+ "WHERE lp.participant.idparticipant = :pidParticipant "
				+ "AND e.datefin IS NULL";
		Query query = em.createQuery(req).setParameter("pidParticipant", idParticipant);
		return query.getResultList();

	}

	@Override
	public List<Echange> rechercherEchangeTerminés(int idParticipant) {
		final String req = "SELECT e FROM Echange e INNER JOIN Objet o ON o.objet.idobjet = e.objet.idobjet "
				+ "INNER JOIN ListeProposition lp ON lp.objet.idobjet = e.objet.idobjet "
				+ "WHERE lp.participant.idparticipant = :pidParticipant "
				+ "AND e.datefin IS NOT NULL";
		Query query = em.createQuery(req).setParameter("pidParticipant", idParticipant);
		return query.getResultList();
	}

	@Override
	public List<Echange> rechercherTousLesEchanges() {
		final String req = "SELECT e FROM Echange e";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Echange> rechercherEchangesRefuses(int idParticipant) {
		final String req = "SELECT e FROM Echange e INNER JOIN Objet o ON o.objet.idobjet = e.objet.idobjet AND INNER JOIN ListeProposition lp ON lp.objet.idobjet = e.objet.idobjet WHERE lp.participant.idparticipant = :pidParticipant AND e.daterefus IS NOT NULL";
		Query query = em.createQuery(req).setParameter("pidParticipant", idParticipant);
		return query.getResultList();
	}

	@Override
	public List<Echange> rechercherEchangesLitiges(int idParticipant) {
		final String req = "SELECT e FROM Echange e INNER JOIN Objet o ON o.objet.idobjet = e.objet.idobjet AND INNER JOIN ListeProposition lp ON lp.objet.idobjet = e.objet.idobjet WHERE lp.participant.idparticipant = :pidParticipant AND e.datelitige IS NOT NULL";
		Query query = em.createQuery(req).setParameter("pidParticipant", idParticipant);
		return query.getResultList();
	}

	@Override
	public List<Echange> rechercherTousLesEchangesEnCours() {
		final String req = "SELECT e FROM Echange e WHERE e.datefin IS NULL";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Echange> rechercherTousLesEchangesTermines() {
		final String req = "SELECT e FROM Echange e WHERE e.datefin IS NOT NULL";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Echange> rechercherTousLesEchangesRefuses() {
		final String req = "SELECT e FROM Echange e WHERE e.daterefus IS NOT NULL";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Echange> rechercherTousLesEchangesLitiges() {
		final String req = "SELECT e FROM Echange e WHERE e.datelitige IS NOT NULL";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Echange> rechercherTousLesEchangesDUnParticipant(int idParticipant) {
		final String req = "SELECT e FROM Echange e WHERE e.objet.listeProposition.participant.idparticipant = :pid";
		Query query = em.createQuery(req).setParameter("pid", idParticipant);
		return query.getResultList();
	}

}
