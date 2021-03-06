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
public class DaoObjet implements IDaoObjet {

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
		final String req = "SELECT o FROM Objet o WHERE domaine = :pdomaine";
		Query query = em.createQuery(req).setParameter("pdomaine", domaine);
		return query.getResultList();
	}

	@Override
	public Objet updateObjet(Objet objet) {
		em.merge(objet);
		return objet;
	}

	@Override
	public void supprimerObjet(Objet objet) {
		em.remove(objet);
	}

	@Override
	public List<Objet> getAllObjets() {
		final String req = "Select o FROM Objet o inner join fetch o.valeur WHERE o.idobjet not in(SELECT e.objet.idobjet FROM Echange e)";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Objet> getObjetDisponible() {
		final String req = "Select o FROM Objet o WHERE actif is true";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public Objet getObjetById(int idObjet) {
		final String req = "Select o FROM Objet o WHERE idobjet = :pidObjet";
		Query query = em.createQuery(req).setParameter("pidObjet", idObjet);
		return (Objet) query.getSingleResult();
	}

	@Override
	public List<Objet> rechercherObjetsParCategorie(Categorie categorie) {
		final String req = "Select o FROM Objet o WHERE categorie = :pcategorie";
		Query query = em.createQuery(req).setParameter("pcategorie", categorie);
		return query.getResultList();
	}

	@Override
	public List<Objet> rechercherObjetsParSousCategorie(Souscategorie souscategorie) {
		final String req = "Select o FROM Objet o WHERE souscategorie = :psouscategorie";
		Query query = em.createQuery(req).setParameter("psouscategorie", souscategorie);
		return query.getResultList();
	}

	@Override
	public List<Objet> rechercherObjetParIntitule(String intitule) {
		final String req = "Select o FROM Objet o WHERE intitule = :pintitule";
		Query query = em.createQuery(req).setParameter("pintitule", intitule);
		return query.getResultList();
	}

	@Override
	public List<Objet> rechercherObjetParValeur(int valeur) {
		final String req = "Select o FROM Objet o WHERE valeur = :pvaleur";
		Query query = em.createQuery(req).setParameter("pvaleur", valeur);
		return query.getResultList();
	}

	@Override
	public List<Objet> rechercherObjetParAge(int age) {
		final String req = "Select o FROM Objet o WHERE trancheAge = :page";
		Query query = em.createQuery(req).setParameter("page", age);
		return query.getResultList();
	}

	@Override
	public String getNomListePropositionByIdObjet(int idObjet) {
		final String req = "Select o.listeProposition.nom FROM Objet o WHERE o.idobjet = :pidObjet";
		Query query = em.createQuery(req).setParameter("pidObjet", idObjet);
		return (String) query.getSingleResult();
	}

	public Image getFirstImageByIdObjet(int idObjet) {
		final String req = "SELECT o.images FROM Objet o WHERE o.idobjet = :pIdObjet";
		Query query = em.createQuery(req).setParameter("pIdObjet", idObjet);
		List<Image> liste = query.getResultList();
		Image img = new Image(null, "resources/img/Blank.png");
		if (!liste.isEmpty()) {
			img = (Image) query.getResultList().get(0);
		}
		return img;
	}

	@Override
	public List<Image> getAllImageByIdObjet(int idObjet) {
		final String req = "SELECT o.images FROM Objet o WHERE o.idobjet = :pIdObjet";
		Query query = em.createQuery(req).setParameter("pIdObjet", idObjet);
		List<Image> liste = query.getResultList();
		Image img = new Image(null, "resources/img/Blank.png");
		switch (liste.size()) {
		case 0:
			liste.add(img);
			liste.add(img);
			liste.add(img);
			liste.add(img);
			break;

		case 1:
			liste.add(img);
			liste.add(img);
			liste.add(img);
			break;

		case 2:
			liste.add(img);
			liste.add(img);
			break;

		case 3:
			liste.add(img);
			break;

		default:
			break;
		}
		return liste;
	}

	@Override
	public List<Objet> rechercherObjetByAlgo(String rDomaine, String rCategorie, String rSousCategorie, String rValeur,
			String rIntitule) {
		
		String req = "SELECT o FROM Objet o WHERE o.domaine.domaine LIKE :pDomaine AND o.categorie.intitule LIKE :pCategorie AND o.souscategorie.intitule LIKE :pSousCategorie AND o.valeur.valeur <= :pValeur AND o.intitule LIKE :pidObjetIntitule AND o.idobjet not in(SELECT e.objet.idobjet FROM Echange e)";

		Query query = em.createQuery(req).setParameter("pDomaine", rDomaine).setParameter("pCategorie", rCategorie)
				.setParameter("pSousCategorie", rSousCategorie).setParameter("pValeur", Integer.parseInt(rValeur))
				.setParameter("pidObjetIntitule", rIntitule);

		System.out.println(query.toString());
		System.out.println("coucou DAO");
		return query.getResultList();
	}
}
