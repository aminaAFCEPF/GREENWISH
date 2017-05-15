package fr.afcepf.ai100.g3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai100.g3.entities.RepeatPaginator;

@ManagedBean(name="mbFavoris")
@SessionScoped
public class FavorisBean {

	@EJB
	private IBusinessCatalogue proxyCatalogue;

	@EJB
	private IBusinessFavoris proxyFavoris;
	
	@EJB
	private IBusinessFicheObjet proxyBusinessObjet;

	@ManagedProperty(value = "#{mbCnx}")
	private ConnexionBean cnxBean;

	private List<Favoris> favoris = new ArrayList<>();
	private List<Souhait> souhaits = new ArrayList<>();
	
	private Date dateAjout;
	private String dateAjoutFormat;

	@PostConstruct
	public void init(){
		this.favoris = proxyFavoris.afficherFavorisByIdParticipant(cnxBean.getParticipant().getIdparticipant());
		cnxBean.getParticipant().setFavoris(favoris);
		souhaits = proxyFavoris.afficherSouhaitsByIdParticipant(cnxBean.getParticipant().getIdparticipant());
	}
	
	public void removeFavori(Favoris favoris){
		proxyFavoris.effacerFavori(favoris);
	}

	public String afficherMonCompte(){
		return "/AccueilAdh.xhtml?faces-redirect=true";
	}
	
	public String formatDate(Date date){
		this.dateAjout = date;
		DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
		String dateAjoutFormat = outputFormatter.format(dateAjout);
		return dateAjoutFormat;
	}
	
	public Image afficherImage(Objet objet){
		return proxyBusinessObjet.getFirstImageByIdObjet(objet.getIdobjet());	
	}

	public IBusinessCatalogue getProxyCatalogue() {
		return proxyCatalogue;
	}

	public void setProxyCatalogue(IBusinessCatalogue proxyCatalogue) {
		this.proxyCatalogue = proxyCatalogue;
	}

	public IBusinessFavoris getProxyFavoris() {
		return proxyFavoris;
	}

	public void setProxyFavoris(IBusinessFavoris proxyFavoris) {
		this.proxyFavoris = proxyFavoris;
	}

	public List<Favoris> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<Favoris> favoris) {
		this.favoris = favoris;
	}

	public ConnexionBean getCnxBean() {
		return cnxBean;
	}

	public void setCnxBean(ConnexionBean cnxBean) {
		this.cnxBean = cnxBean;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public String getDateAjoutFormat() {
		return dateAjoutFormat;
	}

	public void setDateAjoutFormat(String dateAjoutFormat) {
		this.dateAjoutFormat = dateAjoutFormat;
	}
	
	public List<Souhait> getSouhaits() {
		return souhaits;
	}

	public void setSouhaits(List<Souhait> souhaits) {
		this.souhaits = souhaits;
	}
	


}
