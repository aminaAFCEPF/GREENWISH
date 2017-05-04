package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessFavoris.class)
@Stateless
public class BusinessFavoris implements IBusinessFavoris {
	
	@EJB
	IDaoFavoris proxyDaoFavoris;
	@Override
	public void ajouterFavoris(Favoris favoris) {
		
		proxyDaoFavoris.ajouterFavoris(favoris);
	}
	
	
}
