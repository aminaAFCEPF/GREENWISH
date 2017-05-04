package fr.afcepf.ai100.g3;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbCatalogue")
@SessionScoped
public class CatalogueBean {

	@EJB
	private IBusinessCatalogue proxyCatalogue;
	private List<Objet> objets;
	
	@PostConstruct
	public void init(){
		objets = proxyCatalogue.afficherTousLesObjets();
	}
	
}
