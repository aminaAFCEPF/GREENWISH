package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoLitige {
	
	List<Litige> GetLitigeByIdEchange (int idEchange);
	List<Litige> GetAllLitige ();
	Litige ajouterLitige (Litige litige);
	Litige updateLitige (Litige litige);
	void deleteLitige (Litige litige);
}
