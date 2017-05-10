package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessFavoris {
	
	void ajouterFavoris(Favoris favoris);
	List<Favoris> afficherFavorisByIdParticipant(int idParticipant);
	List<Souhait> afficherSouhaitsByIdParticipant(int idParticipant);
	String AfficherNomListeByIdObjet(int idObjet);
	Image AfficherPremiereImageParIdObjet(int idObjet);
	
}
