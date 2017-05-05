package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoImage {

	Image ajouterImage(Image image);
	void deleteImage(Image image);
	List<Image> getImageByIdObjet(int id);
	Image updateImage(Image image);
}
