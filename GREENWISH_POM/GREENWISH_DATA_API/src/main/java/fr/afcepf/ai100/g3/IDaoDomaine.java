package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoDomaine {
	
	List<Domaine> getAllDomaine();

	String getIntituleById(int id);

}
