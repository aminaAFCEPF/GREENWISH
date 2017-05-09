package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoStatistique {

	List<Statistique> getAllStatistique();
	Statistique getStatistiqueById(int idStatistique);
	
}
