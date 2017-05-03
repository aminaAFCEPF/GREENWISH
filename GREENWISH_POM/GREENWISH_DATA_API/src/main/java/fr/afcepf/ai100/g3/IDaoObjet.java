package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoObjet {
	
	Objet ajouterObjet (Objet objet);
	List<Objet> rechercherObjetsParDomaine(Domaine domaine);

}
