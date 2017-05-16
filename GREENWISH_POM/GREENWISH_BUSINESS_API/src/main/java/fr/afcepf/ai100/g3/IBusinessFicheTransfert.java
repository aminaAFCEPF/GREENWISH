package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessFicheTransfert {

	Disponibilite getDisponibiliteByIdParticipant (int idParticipant);
	Echange ajouterEchange(Echange echange);
	Rdv ajouterRdv(Rdv rdv);
	Objet updateObjet(Objet objet);
	Participant rechercherParticipantParId(int id);
	Message ajouterMessage(Message message);
	Participant modifierPoints(Participant participant);
	Echange MAJ(Echange echange);
	Rdv MAJ(Rdv rdv);
	List<Message> recupMessage(int idTransfert, int idParticipant);
	Participant recupProprio2(int idObjet);
	List<Image> recupImagesObjet(int idObjet);
}
