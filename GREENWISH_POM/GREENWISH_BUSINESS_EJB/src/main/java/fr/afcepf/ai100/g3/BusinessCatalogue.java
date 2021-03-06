package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessCatalogue.class)
@Stateless
public class BusinessCatalogue implements IBusinessCatalogue {

	@EJB
	IDaoObjet proxyDaoObjet;
	
	@Override
	public List<Objet> afficherTousLesObjets() {
		return proxyDaoObjet.getAllObjets();
	}

	@Override
	public Image getFirstImageByIdObjet(int idObjet) {
		return proxyDaoObjet.getFirstImageByIdObjet(idObjet);
	}


}
