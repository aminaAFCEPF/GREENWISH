package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessGestionProfil.class)
@Stateless
public class BusinessGestionProfil implements IBusinessGestionProfil {
	@EJB
	IDaoParticipant proxyGestionProfil;

	@Override
	public Participant rechercherParticipantById(int idParticipant) {
		proxyGestionProfil.rechercherParticipantParId(idParticipant);
		return null;
	}

}
