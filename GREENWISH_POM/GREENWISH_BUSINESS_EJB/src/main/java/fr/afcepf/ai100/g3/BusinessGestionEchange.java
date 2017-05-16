

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

	private final String ETATTERMINE = "Transferts terminés";
	private final String ETATENCOURS = "Transferts en cours";
	private final String ETATTOUS = "Tous";
	private final String TYPERECU = "Objets reçus";
	private final String TYPEDONNE = "Objets donnés";
	private final String TYPETOUS = "Tous";
	private List<Echange> echanges;
	private List<Echange> echangesDonnes;
	private List<Echange> echangesRecus;

	@Override
	public List<Echange> afficherTousLesEchangesDUnParticipant(int idParticipant) {
		echanges = new ArrayList<>();
		echangesDonnes = new ArrayList<>();
		echangesRecus = new ArrayList<>();
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
		List<Echange> echanges = new ArrayList<>();
		List<Echange> echangesTermines = new ArrayList<>();
		echangesDonnes = proxyDaoEchange.rechercherTousLesEchangesDonnesDUnParticipant(idParticipant);
		echangesRecus = proxyDaoEchange.rechercherTousLesEchangesRecusDUnParticipant(idParticipant);
		echanges.addAll(echangesDonnes);
		for(Echange echange:echangesRecus){
			if(!echanges.contains(echange)){
				echanges.add(echange);
			}
		}
		
		
		for (Echange e : echanges) {
			if (e.getDateFin() != null) {
				echangesTermines.add(e);
			}
		}
		
		return echangesTermines;
	}

	@Override
	public List<Echange> afficherLesEchangesEnCoursDUnParticipant(int idParticipant) {
		List<Echange> echanges = new ArrayList<>();
		echangesDonnes = proxyDaoEchange.rechercherTousLesEchangesDonnesEnCoursDUnParticipant(idParticipant);
		echangesRecus = proxyDaoEchange.rechercherTousLesEchangesRecusEnCoursDUnParticipant(idParticipant);
		echanges.addAll(echangesDonnes);
		for(Echange echange:echangesRecus){
			if(!echanges.contains(echange)){
				echanges.add(echange);
			}
		}
		
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
			echangesEnCoursTriesParType = afficherLesEchangesEnCoursDUnParticipant(idParticipant);
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
			echangesTerminesTriesParType = afficherLesEchangesTerminesDUnParticipant(idParticipant);
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
	public List<Echange> afficherTousEchanges() {
		return proxyDaoEchange.rechercherTousLesEchanges();
	}



}
