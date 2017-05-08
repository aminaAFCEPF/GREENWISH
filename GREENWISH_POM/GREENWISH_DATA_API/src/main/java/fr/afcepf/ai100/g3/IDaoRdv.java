package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoRdv {

	Rdv ajouterRdv (Rdv rdv);
	Rdv updateRdv (Rdv rdv);
	void deleteRdv (Rdv rdv);
	Rdv getRdvByIdEchange (int idEchange);
	List<Rdv> getAllRdv ();
}
