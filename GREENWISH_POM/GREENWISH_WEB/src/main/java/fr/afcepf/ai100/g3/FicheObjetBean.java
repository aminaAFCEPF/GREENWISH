package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="mbFicheObjet")
@SessionScoped
public class FicheObjetBean {

	@EJB
	private IBusinessCatalogue proxyCatalogue;

	@EJB
	private IBusinessFicheObjet proxyFicheObjet;

	private Objet objet;
	private List<Image> images;
	private String valeur;
	public ConnexionBean getCnxBean() {
		return cnxBean;
	}

	public void setCnxBean(ConnexionBean cnxBean) {
		this.cnxBean = cnxBean;
	}

	private String idAge;
	private boolean isConnecte;
	private boolean NotMyObjet = true;
	private boolean ConnecteAndNotMyObjet;


	@ManagedProperty(value="#{mbCnx}")
	private ConnexionBean cnxBean;

	public String afficherObjet(Objet objet){
		this.objet = objet;
		this.images = proxyFicheObjet.getImageByIdObjet(objet.getIdobjet());
		this.valeur = objet.getValeur().toString();
		this.setIdAge(objet.getTrancheAge().getIdage().toString());
		return "/FicheObjet.xhtml?faces-redirect=true";
	}

	public boolean estVide(String str){
		boolean estVide;
		if(str.isEmpty()){
			estVide=true;
		}
		else{
			estVide=false;
		}
		return estVide;

	}

	public void estConnecte() {
		if(cnxBean.getParticipant() == null) {
			ConfigurableNavigationHandler  nav =
					(ConfigurableNavigationHandler)
					FacesContext.getCurrentInstance()
					.getApplication()
					.getNavigationHandler();
			isConnecte = true;
			cnxBean.setPageRedirection("/FicheObjet.xhtml?faces-redirect=true");
			nav.performNavigation("/Connexion.xhtml?faces-redirect=true&amp;callback=focus");
		}else{
			if(cnxBean.getParticipant().getIdparticipant() == proxyFicheObjet.recupProprio(objet.getIdobjet()).getIdparticipant()){
				ConnecteAndNotMyObjet=false;
				NotMyObjet=false;
			}
			else{
				ConnecteAndNotMyObjet=true;
				NotMyObjet=true;
			}
			ConfigurableNavigationHandler  nav =
					(ConfigurableNavigationHandler)
					FacesContext.getCurrentInstance()
					.getApplication()
					.getNavigationHandler();
			nav.performNavigation("/FicheObjet.xhtml?faces-redirect=true");

		}
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


	public IBusinessFicheObjet getProxyFicheObjet() {
		return proxyFicheObjet;
	}


	public void setProxyFicheObjet(IBusinessFicheObjet proxyFicheObjet) {
		this.proxyFicheObjet = proxyFicheObjet;
	}


	public List<Image> getImages() {
		return images;
	}


	public void setImages(List<Image> images) {
		this.images = images;
	}


	public String getValeur() {
		return valeur;
	}


	public void setValeur(String valeur) {
		this.valeur = valeur;
	}


	public String getIdAge() {
		return idAge;
	}


	public void setIdAge(String idAge) {
		this.idAge = idAge;
	}



	public boolean isConnecte() {
		return isConnecte;
	}

	public void setConnecte(boolean isConnecte) {
		this.isConnecte = isConnecte;
	}

	public boolean isNotMyObjet() {
		return NotMyObjet;
	}

	public void setNotMyObjet(boolean notMyObjet) {
		NotMyObjet = notMyObjet;
	}

	public boolean isConnecteAndNotMyObjet() {
		return ConnecteAndNotMyObjet;
	}

	public void setConnecteAndNotMyObjet(boolean connecteAndNotMyObjet) {
		ConnecteAndNotMyObjet = connecteAndNotMyObjet;
	}








}
