package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.ai100.g3_2.Participant;

@Remote(IBusinessInscription.class)
@Stateless
public class BusinessInscription implements IBusinessInscription{

	@EJB
	IDaoParticipant proxyDaoParticipant;
	
	@Override
	public void inscrire(Participant participant) {
		proxyDaoParticipant.ajouter(participant);
		
	}

}
