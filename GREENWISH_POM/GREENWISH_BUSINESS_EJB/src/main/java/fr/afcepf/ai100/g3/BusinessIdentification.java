package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessIdentification.class)
@Stateless
public class BusinessIdentification implements IBusinessIdentification{

	@EJB
	private IDaoParticipant proxyParticipant;
	
	@Override
	public Participant identifier(String mail, String mdp) {
		proxyParticipant.identification(mail, mdp);
		return null;
	}

}
