package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
@Remote(IBusinessAfficherEchange.class)
@Stateless
public class BusinessAfficherEchange implements IBusinessAfficherEchange {
	@EJB
	private IDaoEchange proxyAfficherEchange;
	private List<Echange>echanges;

	@Override
	public List<Echange> afficherTousLesEchangesDUnParticipant(int idParticipant) {
		try {
			echanges= proxyAfficherEchange.rechercherTousLesEchangesDUnParticipant(idParticipant);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return echanges;
	}

}
