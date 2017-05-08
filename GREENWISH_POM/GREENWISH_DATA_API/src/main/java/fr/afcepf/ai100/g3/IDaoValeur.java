package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoValeur {
	
	Valeur ajouterValeur(Valeur valeur);
	Valeur updateValeur(Valeur valeur);
	void deleteValeur(Valeur valeur);
	Valeur getValeurById(int idValeur);
	List<Valeur> getAllValeur();
}
