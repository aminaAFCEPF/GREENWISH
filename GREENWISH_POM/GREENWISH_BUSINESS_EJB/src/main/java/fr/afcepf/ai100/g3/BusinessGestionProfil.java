package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessGestionProfil.class)
@Stateless
public class BusinessGestionProfil implements IBusinessGestionProfil {
	@EJB
	IDaoParticipant proxyGestionProfil;
	@EJB
	IDaoVille proxyGestionVille;

	@Override
	public Participant rechercherParticipantById(int idParticipant) {
		Participant participant = proxyGestionProfil.rechercherParticipantParId(idParticipant);
		return participant;
	}
	

	public IDaoParticipant getProxyGestionProfil() {
		return proxyGestionProfil;
	}

	public void setProxyGestionProfil(IDaoParticipant proxyGestionProfil) {
		this.proxyGestionProfil = proxyGestionProfil;
	}



	
	
	

}
