package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
@Remote(IBusinessGestionEchange.class)
@Stateless
public class BusinessGestionEchange implements IBusinessGestionEchange {
	@EJB
	private IDaoEchange proxyDaoEchange;
	private List<Echange>echanges;

	@Override
	public List<Echange> afficherTousLesEchangesDUnParticipant(int idParticipant) {
		try {
			echanges= proxyDaoEchange.rechercherTousLesEchangesDUnParticipant(idParticipant);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return echanges;
	}

	@Override
	public List<Echange> afficherLesEchangesTerminesDUnParticipant(int idParticipant) {
		return proxyDaoEchange.rechercherEchangeTerminés(idParticipant);
	}

}
