package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessFicheTransfert.class)
@Stateless
public class BusinessFicheTransfert implements IBusinessFicheTransfert {
	@EJB
	IDaoDisponibilite proxyDaoDisponibilite;
	@EJB
	IDaoEchange proxyDaoEchange;
	@EJB
	IDaoObjet proxyDaoObjet;
	@EJB
	IDaoRdv proxyDaoRdv;
	@EJB
	IDaoParticipant proxyParticipant;
	@EJB
	IDaoMessage proxyDaoMessage;

	@Override
	public Disponibilite getDisponibiliteByIdParticipant(int idParticipant) {
		return proxyDaoDisponibilite.getDisponibiliteByIdParticipant(idParticipant);
	}

	@Override
	public Echange ajouterEchange(Echange echange) {
		return proxyDaoEchange.ajouterEchange(echange);
	}

	@Override
	public Rdv ajouterRdv(Rdv rdv) {
		return proxyDaoRdv.ajouterRdv(rdv);
	}

	@Override
	public Objet updateObjet(Objet objet) {
		return proxyDaoObjet.updateObjet(objet);
	}

	@Override
	public Participant rechercherParticipantParId(int id) {
		
		return proxyParticipant.rechercherParticipantParId(id);
	}

	@Override
	public Message ajouterMessage(Message message) {
		return proxyDaoMessage.ajouterMessage(message);
	}

	@Override
	public Participant modifierPoints(Participant participant) {
		return proxyParticipant.updateParticipant(participant);
	}

	@Override
	public Echange MAJ(Echange echange) {
		return proxyDaoEchange.updateEchange(echange);
	}

	@Override
	public Rdv MAJ(Rdv rdv) {
		return proxyDaoRdv.updateRdv(rdv);
	}
}
