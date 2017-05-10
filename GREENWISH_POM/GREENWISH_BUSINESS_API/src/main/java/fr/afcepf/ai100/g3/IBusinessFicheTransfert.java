package fr.afcepf.ai100.g3;

public interface IBusinessFicheTransfert {

	Disponibilite getDisponibiliteByIdParticipant (int idParticipant);
	Echange ajouterEchange(Echange echange);
	Rdv ajouterRdv(Rdv rdv);
	Objet updateObjet(Objet objet);
}