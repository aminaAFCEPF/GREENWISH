package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbCatalogue")
@SessionScoped
public class CatalogueBean {

	@EJB
	private IBusinessCatalogue proxyCatalogue;
	
	private Domaine domaine;
	private Categorie categorie;
	private Souscategorie sousCategorie;
	private TrancheAge trancheAge;
	private Valeur valeur;
	
	
	public String rechercher(){
		
		return null;
	}
	
}
