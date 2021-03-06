package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessAjouterObjet {

	void ajouterObjet(Objet objet,Participant participant);
	
	List<Domaine> rechercherDomaine();
	List<Categorie> rechercherCategorie();
	List<Souscategorie> rechercherSousCategorie();
	List<Categorie> rechercherCategorieParDomaine(Domaine domaine);
	List<Souscategorie> rechercherSousCategorieParCategorie(Categorie categorie);
	List<ListeProposition> rechercherListeProposition(Participant participant);
	Participant rechercherParticipantParId(int idParticipant);
	ListeProposition ajouterUneListe(ListeProposition listeProposition);
	Participant ajouterPointsAUnParticipant(Participant participant);
	String RemplirEspaces(Objet objet, String description);
	List<Valeur> rechercherValeur();
	List<TrancheAge> rechercherTrancheAge();
	
	
}
