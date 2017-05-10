package fr.afcepf.ai100.g3;

public interface IDaoDisponibilite {
	Disponibilite getDisponibiliteByIdParticipant (int id);
	Disponibilite getDisponibiliteById (int id);
	Disponibilite ajouterDisponibilite (Disponibilite disponibilite);
	Disponibilite updateDisponibilite (Disponibilite disponibilite);
	void deleteDisponibilite (Disponibilite disponibilite);

}
