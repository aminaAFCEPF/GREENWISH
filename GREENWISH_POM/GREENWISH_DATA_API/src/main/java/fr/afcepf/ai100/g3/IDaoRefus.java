package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoRefus {

	Refus ajouterRefus(Refus refus);
	Refus updateRefus(Refus refus);
	void deleteRefus(Refus refus);
	Refus getRefusByIdEchange(int id);
	List<Refus> getAllRefus();
}
