package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
	private final String ETATTERMINE = "Transferts terminés";
	private final String ETATENCOURS = "Transferts en cours";
	private final String ETATTOUS = "Tous";
	private final String TYPERECU = "Objets reçus";
	private final String TYPEDONNE = "Objets donnés";
	private final String TYPETOUS = "Tous";

	@Override
	public List<Echange> afficherTousLesEchangesDUnParticipant(int idParticipant) {
		
		try {

			echangesDonnes = proxyDaoEchange.rechercherTousLesEchangesDonnesDUnParticipant(idParticipant);
			echangesRecus = proxyDaoEchange.rechercherTousLesEchangesRecusDUnParticipant(idParticipant);
			echanges.addAll(echangesDonnes);
			for(Echange echange:echangesRecus){
				if(!echanges.contains(echange)){
					echanges.add(echange);
				}
			}
			

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
	public List<Echange> trierTousLesEchangeParType(String type, int idParticipant) {
		List<Echange> echangesTriesParType = new ArrayList<>();
		switch (type) {
		case TYPEDONNE:
			echangesTriesParType = proxyDaoEchange.rechercherTousLesEchangesDonnesDUnParticipant(idParticipant);
		break;
		case TYPERECU:
			echangesTriesParType = proxyDaoEchange.rechercherTousLesEchangesRecusDUnParticipant(idParticipant);
		break;
		case TYPETOUS:
			echangesTriesParType = afficherTousLesEchangesDUnParticipant(idParticipant);
			break;
		}
		return echangesTriesParType;
	}
	
	@Override
	public List<Echange> trierEchangeEnCoursParType(String type, int idParticipant) {
		List<Echange> echangesEnCoursTriesParType = new ArrayList<>();
		switch (type) {
		case TYPEDONNE:
			echangesEnCoursTriesParType = proxyDaoEchange.rechercherTousLesEchangesDonnesEnCoursDUnParticipant(idParticipant);
		break;
		case TYPERECU:
			echangesEnCoursTriesParType = proxyDaoEchange.rechercherTousLesEchangesRecusEnCoursDUnParticipant(idParticipant);
		break;
		case TYPETOUS:
			echangesEnCoursTriesParType = proxyDaoEchange.rechercherTousLesEchangesEnCours();
			break;
		}
		return echangesEnCoursTriesParType;
	}
	
	@Override
	public List<Echange> trierEchangeTerminesParType(String type, int idParticipant) {
		List<Echange> echangesTerminesTriesParType = new ArrayList<>();
		switch (type) {
		case TYPEDONNE:
			echangesTerminesTriesParType = proxyDaoEchange.rechercherTousLesEchangesDonnesTerminesDUnParticipant(idParticipant);
		break;
		case TYPERECU:
			echangesTerminesTriesParType = proxyDaoEchange.rechercherTousLesEchangesRecusTerminesDUnParticipant(idParticipant);
		break;
		case TYPETOUS:
			echangesTerminesTriesParType = proxyDaoEchange.rechercherTousLesEchangesTermines();
			break;
		}
		return echangesTerminesTriesParType;
	}
	

	
	@Override
	public List<Echange> afficherLesEchangesTries(String etat,String type,int idParticipant){
		List<Echange> echangesTries = new ArrayList<>();
		if(etat.equalsIgnoreCase(ETATTOUS)){
			echangesTries=trierTousLesEchangeParType( type,idParticipant);
		}
		if(etat.equalsIgnoreCase(ETATENCOURS)){
			echangesTries=trierEchangeEnCoursParType(type, idParticipant);
		}
		if(etat.equalsIgnoreCase(ETATTERMINE)){
			echangesTries=trierEchangeTerminesParType(type,idParticipant);
		}
		return echangesTries;
	}

	@Override
	public List<Echange> afficherEchangesTries(String etat, String type, int Participant) {
		// TODO Auto-generated method stub
		return null;
	}

}
