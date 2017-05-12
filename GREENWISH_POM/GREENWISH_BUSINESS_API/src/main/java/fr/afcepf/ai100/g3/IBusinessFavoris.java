package fr.afcepf.ai100.g3;

import java.util.List;

public interface IBusinessFavoris {
	
	Favoris ajouterFavoris(Favoris favoris);
	List<Favoris> afficherFavorisByIdParticipant(int idParticipant);
	List<Souhait> afficherSouhaitsByIdParticipant(int idParticipant);
	String AfficherNomListeByIdObjet(int idObjet);
	Image AfficherPremiereImageParIdObjet(int idObjet);
	void effacerFavori(Favoris favoris);
	
}
