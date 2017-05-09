package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessFicheObjet {
	
	
	List<Image> getImageByIdObjet(int id);
	Participant recupProprio(int Idobjet);
}
