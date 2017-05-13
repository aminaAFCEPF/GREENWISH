package fr.afcepf.ai100.g3;

import java.lang.reflect.Proxy;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai100.g3.Participant;

@Remote(IBusinessInscription.class)
@Stateless
public class BusinessInscription implements IBusinessInscription{

	@EJB
	IDaoParticipant proxyDaoParticipant;
	
	@EJB
	IDaoListeProposition proxyDaoListProp;
	
	@Override
	public Participant inscrire(Participant participant) {
		return proxyDaoParticipant.ajouter(participant);
		
	}

	@Override
	public ListeProposition creerListeProp(ListeProposition listeproposition) {
		return proxyDaoListProp.ajouterListeProposition(listeproposition);
	}

}
