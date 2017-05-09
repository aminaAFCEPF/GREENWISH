package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessGestionProfil.class)
@Stateless
public class BusinessGestionProfil implements IBusinessGestionProfil {
	@EJB
	IDaoParticipant proxyDaoParticipant;
	@EJB
	IDaoVille proxyDaoVille;

	@Override
	public Participant rechercherParticipantById(int idParticipant) {
		Participant participant = proxyDaoParticipant.rechercherParticipantParId(idParticipant);
		return participant;
	}
	

	public IDaoParticipant getProxyGestionProfil() {
		return proxyDaoParticipant;
	}

	public void setProxyGestionProfil(IDaoParticipant proxyDaoParticipant) {
		this.proxyDaoParticipant = proxyDaoParticipant;
	}
	
	public void updateParticipant(Participant participant){
		proxyDaoParticipant.updateParticipant(participant);
		
	}
	@Override
	public List<Ville> rechercherVille(String codePostal){
		return proxyDaoVille.rechercherVille(codePostal);
	}



	
	
	

}
