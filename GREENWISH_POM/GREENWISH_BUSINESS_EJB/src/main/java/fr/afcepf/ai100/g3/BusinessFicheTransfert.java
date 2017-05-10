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
}
