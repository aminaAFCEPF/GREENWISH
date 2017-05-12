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

	@ManagedProperty(value = "#{mbCnx}")
	private ConnexionBean cnxBean;

	private List<Favoris> favoris = new ArrayList<>();
	private List<Souhait> souhaits = new ArrayList<>();

	private RepeatPaginator paginatorFavoris;
	private RepeatPaginator paginatorSouhaits;

	private Date dateAjout;
	private String dateAjoutFormat;
	private Image premiereImage;

	@PostConstruct
	public void init(){
		favoris = proxyFavoris.afficherFavorisByIdParticipant(cnxBean.getParticipant().getIdparticipant());
		cnxBean.getParticipant().setfavoris(favoris);
		paginatorFavoris = new RepeatPaginator(favoris);
		souhaits = proxyFavoris.afficherSouhaitsByIdParticipant(cnxBean.getParticipant().getIdparticipant());
		paginatorSouhaits = new RepeatPaginator(souhaits);
		setDateAjout(favoris.get(0).getObjet().getDateajout());
		DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
		setDateAjoutFormat(outputFormatter.format(dateAjout));
		setPremiereImage(proxyFavoris.AfficherPremiereImageParIdObjet(favoris.get(0).getObjet().getIdobjet()));
	}
	
	public void removeFavori(Favoris favoris){
		proxyFavoris.effacerFavori(favoris);
	}

	public String afficherMonCompte(){
		return "/AccueilAdh.xhtml?faces-redirect=true";
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

	public RepeatPaginator getPaginatorFavoris() {
		return paginatorFavoris;
	}

	public void setPaginatorFavoris(RepeatPaginator paginatorFavoris) {
		this.paginatorFavoris = paginatorFavoris;
	}

	public RepeatPaginator getPaginatorSouhaits() {
		return paginatorSouhaits;
	}

	public void setPaginatorSouhaits(RepeatPaginator paginatorSouhaits) {
		this.paginatorSouhaits = paginatorSouhaits;
	}
	
	public List<Souhait> getSouhaits() {
		return souhaits;
	}

	public void setSouhaits(List<Souhait> souhaits) {
		this.souhaits = souhaits;
	}

	public Image getPremiereImage() {
		return premiereImage;
	}

	public void setPremiereImage(Image premiereImage) {
		this.premiereImage = premiereImage;
	}



}
