package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessFavoris.class)
@Stateless
public class BusinessFavoris implements IBusinessFavoris {
	
	@EJB
	IDaoFavoris proxyDaoFavoris;
	@EJB
	IDaoSouhait proxyDaoSouhaits;
	@EJB
	IDaoObjet proxyDaoObjet;
	
	@Override
	public void ajouterFavoris(Favoris favoris) {
		
		proxyDaoFavoris.ajouterFavoris(favoris);
	}
	@Override
	public List<Favoris> afficherFavorisByIdParticipant(int idParticipant) {
		return proxyDaoFavoris.rechercherFavorisParIdParticipant(idParticipant);
	}
	@Override
	public String AfficherNomListeByIdObjet(int idObjet) {
		return proxyDaoObjet.getNomListePropositionByIdObjet(idObjet);
	}
	@Override
	public Image AfficherPremiereImageParIdObjet(int idObjet) {
		return proxyDaoObjet.getFirstImageByIdObjet(idObjet);
	}
	@Override
	public List<Souhait> afficherSouhaitsByIdParticipant(int idParticipant) {
		return proxyDaoSouhaits.getSouhaitByIdParticipant(idParticipant);
	}	
}
