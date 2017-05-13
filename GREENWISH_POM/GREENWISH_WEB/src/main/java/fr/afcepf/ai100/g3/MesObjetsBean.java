package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="mbMesObjet")
@SessionScoped
public class MesObjetsBean {

	@EJB
	private IBusinessFicheObjet proxyBusinessObjet;
	
	private Objet objet;
	private String intitule;
	private Image image;
	private String valeur;
	private String domaine;
	private String categorie;
	private String ssCategorie;
	private String date;
	private String description;
	private String liste;
	
	public String afficherObjet(Objet objet){
		this.objet = objet;
		this.intitule = objet.getIntitule();
		this.image = proxyBusinessObjet.getFirstImageByIdObjet(objet.getIdobjet());
		this.valeur = objet.getValeur().toString();
		this.domaine = objet.getDomaine().getDomaine();
		this.categorie = objet.getCategorie().getIntitule();
		this.ssCategorie = objet.getSouscategorie().getIntitule();
		this.date = objet.getDateajout().toString();
		this.description = objet.getDescription();
		this.liste = objet.getListeProposition().getNom();
		
		
		return "/mesObjet.xhtml?faces-redirect=true";
	}
	
}
