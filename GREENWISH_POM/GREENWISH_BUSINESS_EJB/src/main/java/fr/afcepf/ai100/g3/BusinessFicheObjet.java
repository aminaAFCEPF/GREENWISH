package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessFicheObjet.class)
@Stateless
public class BusinessFicheObjet implements IBusinessFicheObjet {
	
	@EJB
	private IDaoObjet proxyDaoObjet;
	
	@EJB
	private IDaoParticipant proxyDaoParticipant;
	
	@Override
	public List<Image> getImageByIdObjet(int id) {
		return proxyDaoObjet.getAllImageByIdObjet(id);
	}

	@Override
	public Participant recupProprio(int Idobjet) {
		return proxyDaoParticipant.recupProprio(Idobjet);
	}

}
