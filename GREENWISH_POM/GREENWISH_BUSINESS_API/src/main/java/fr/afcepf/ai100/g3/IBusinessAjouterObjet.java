package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessAjouterObjet {

	void ajouterObjet(Objet objet);
	
	List<Domaine> rechercherDomaine();
	List<Categorie> rechercherCategorie();
	List<Souscategorie> rechercherSousCategorie();
	List<Categorie> rechercherCategorieParDomaine(Domaine domaine);
	List<Souscategorie> rechercherSousCategorieParCategorie(Categorie categorie);
	List<ListeProposition> rechercherListeProposition(Participant participant);
	Participant rechercherParticipantParId(int idParticipant);
	ListeProposition ajouterUneListe(ListeProposition listeProposition);
}
