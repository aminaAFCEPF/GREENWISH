package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoObjet {
	
	Objet ajouterObjet (Objet objet);
	Objet updateObjet (Objet objet);
	void supprimerObjet (Objet objet);
	
	List<Objet> getAllObjets();
	List<Objet> rechercherObjetsParDomaine(Domaine domaine);
	List<Objet> getObjetDisponible();
	Objet getObjetById(int idObjet);
	List<Objet> rechercherObjetsParCategorie(Categorie categorie);
	List<Objet> rechercherObjetsParSousCategorie(Souscategorie souscategorie);
	List<Objet> rechercherObjetParIntitule(String intitule);
	List<Objet> rechercherObjetParValeur(int valeur);
	List<Objet> rechercherObjetParAge(int age);
	String getNomListePropositionByIdObjet(int idObjet);
	List<Image> getAllImageByIdObjet(int idObjet);
	Image getFirstImageByIdObjet(int idObjet);
	
	List<Objet> rechercherObjetByAlgo(String rDomaine, String rCategorie, String rSousCategorie, String rValeur, String rIntitule);
  
}
