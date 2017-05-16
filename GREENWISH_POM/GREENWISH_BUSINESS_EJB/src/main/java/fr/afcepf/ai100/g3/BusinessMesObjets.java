package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessMesObjets.class)
@Stateless
public class BusinessMesObjets implements IBusinessMesObjets{
	
	@EJB
	private IDaoParticipant proxyDaoParticipant;
	
	@EJB
	private IDaoObjet proxyDaoObjet;
	
	@Override
	public List<Objet> AfficherObjetParIdParticipant(int idParticipant) {
		return proxyDaoParticipant.getAllObjetByIdParticipant(idParticipant);
	}

	@Override
	public void supprimerObjet(Objet objet) {
		proxyDaoObjet.supprimerObjet(objet);
	}

	@Override
	public List<Objet> AfficherTousObjets() {
		return proxyDaoObjet.getAllObjets();
	}
	
	
}
