package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@javax.faces.bean.ManagedBean(name="mbFicheObjet")
@SessionScoped
public class FicheObjetBean {
	
	@EJB
	private IBusinessCatalogue proxyCatalogue;
	
	private Objet objet;
	
	
	public String afficherObjet(Objet objet){
		this.objet = objet;
		System.out.println(objet.getIntitule());
		return "/FicheObjet.xhtml?faces-redirect=true";
	}
	
	
	public IBusinessCatalogue getProxyCatalogue() {
		return proxyCatalogue;
	}

	public void setProxyCatalogue(IBusinessCatalogue proxyCatalogue) {
		this.proxyCatalogue = proxyCatalogue;
	}




	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

	
	
	
	
}
