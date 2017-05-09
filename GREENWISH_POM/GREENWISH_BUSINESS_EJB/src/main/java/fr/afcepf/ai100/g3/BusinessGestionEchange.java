package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
@Remote(IBusinessGestionEchange.class)
@Stateless
public class BusinessGestionEchange implements IBusinessGestionEchange {
	@EJB
	private IDaoEchange proxyDaoEchange;
	private List<Echange> echangesDonnes;
	private List<Echange> echangesRecus;
	private List<Echange>echanges;

	@Override
	public List<Echange> afficherTousLesEchangesDUnParticipant(int idParticipant) {
		try {
			
			
			echangesDonnes= proxyDaoEchange.rechercherTousLesEchangesDonnesDUnParticipant(idParticipant);
			echangesRecus = proxyDaoEchange.rechercherTousLesEchangesRecusDUnParticipant(idParticipant);
			echanges.addAll(echangesDonnes);
			echanges.addAll(echangesRecus);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return echanges;
	}

	@Override
	public List<Echange> afficherLesEchangesTerminesDUnParticipant(int idParticipant) {
		
		echangesDonnes= proxyDaoEchange.rechercherTousLesEchangesDonnesDUnParticipant(idParticipant);
		echangesRecus = proxyDaoEchange.rechercherTousLesEchangesRecusDUnParticipant(idParticipant);
		echanges.addAll(echangesDonnes);
		echanges.addAll(echangesRecus);
		List<Echange> echangesTermines = new ArrayList<>();
		for(Echange e : echanges){
			if(e.getDateFin() != null){
				echangesTermines.add(e);
			}
		}
		
		return echangesTermines;
	}

}
