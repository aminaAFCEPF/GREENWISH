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
	private List<Echange> echangesDonnes = new ArrayList<>();
	private List<Echange> echangesRecus = new ArrayList<>();
	private List<Echange> echanges = new ArrayList<>();

	@Override
	public List<Echange> afficherTousLesEchangesDUnParticipant(int idParticipant) {
		try {

			echangesDonnes = proxyDaoEchange.rechercherTousLesEchangesDonnesDUnParticipant(idParticipant);
			echangesRecus = proxyDaoEchange.rechercherTousLesEchangesRecusDUnParticipant(idParticipant);
			echanges.addAll(echangesDonnes);
			echanges.addAll(echangesRecus);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return echanges;
	}

	@Override
	public List<Echange> afficherLesEchangesTerminesDUnParticipant(int idParticipant) {

		echangesDonnes = proxyDaoEchange.rechercherTousLesEchangesDonnesDUnParticipant(idParticipant);
		echangesRecus = proxyDaoEchange.rechercherTousLesEchangesRecusDUnParticipant(idParticipant);
		echanges.addAll(echangesDonnes);
		echanges.addAll(echangesRecus);
		System.out.println(echanges.size());
		List<Echange> echangesTermines = new ArrayList<>();
		for (Echange e : echanges) {
			if (e.getDateFin() != null) {
				echangesTermines.add(e);
			}
		}
		System.out.println(echangesTermines.size());
		return echangesTermines;
	}

	@Override
	public List<Echange> afficherLesEchangesEnCoursDUnParticipant(int idParticipant) {
		echangesDonnes = proxyDaoEchange.rechercherTousLesEchangesDonnesEnCoursDUnParticipant(idParticipant);
		echangesRecus = proxyDaoEchange.rechercherTousLesEchangesRecusEnCoursDUnParticipant(idParticipant);
		echanges.addAll(echangesDonnes);
		echanges.addAll(echangesRecus);
		return echanges;
	}

	@Override
	public List<Echange> trierEchangesParEtat(String etat, int idParticipant) {
		System.out.println(etat);
		List<Echange> echangesTriesParEtat = new ArrayList<>();
		switch (etat) {
		case "Transferts en cours":
			echangesTriesParEtat = afficherLesEchangesEnCoursDUnParticipant(idParticipant);
		break;
		case "Transferts terminés":
			echangesTriesParEtat = afficherLesEchangesTerminesDUnParticipant(idParticipant);
		break;

		default:
			echangesTriesParEtat = afficherTousLesEchangesDUnParticipant(idParticipant);
		break;
		}
		return echangesTriesParEtat;
	}

	@Override
	public List<Echange> trierEchangeParType(String type, int idParticipant) {
		List<Echange> echangesTriesParType = new ArrayList<>();
		switch (type) {
		case "Objets donnés":
			echangesTriesParType = proxyDaoEchange.rechercherTousLesEchangesDonnesDUnParticipant(idParticipant);
		break;
		case "Objets reçus":
			echangesTriesParType = proxyDaoEchange.rechercherTousLesEchangesRecusDUnParticipant(idParticipant);
		break;
		default:
			echangesTriesParType = afficherTousLesEchangesDUnParticipant(idParticipant);
			break;
		}
		return echangesTriesParType;
	}

	@Override
	public List<Echange> afficherEchangesTries(String etat,String type,int idParticipant) {
		List<Echange> echangesTries = new ArrayList<>();
		List<Echange> echangesTriesParType = new ArrayList<>();
		List<Echange> echangesTriesParEtat = new ArrayList<>();
		echangesTriesParEtat = trierEchangesParEtat(etat,idParticipant);
		echangesTriesParType = trierEchangeParType(type, idParticipant);
		
		for(Echange echange:echangesTriesParType){
			if(echangesTriesParEtat.contains(echange)){
				echangesTries.add(echange);
			}
		}
		
		return echangesTries;
	}

}
