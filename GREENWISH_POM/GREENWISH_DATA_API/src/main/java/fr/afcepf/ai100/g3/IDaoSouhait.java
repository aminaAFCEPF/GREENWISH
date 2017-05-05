package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoSouhait {
	
	Souhait ajouterSouhait(Souhait souhait);
	void deleteSouhait(Souhait souhait);
	List<Souhait> getSouhaitByIdParticipant(int idParticipant);
}
