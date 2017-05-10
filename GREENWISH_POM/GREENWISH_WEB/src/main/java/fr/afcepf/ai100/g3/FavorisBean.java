package fr.afcepf.ai100.g3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	
	private List<Favoris> favoris;
	private List<Souhait> souhaits;
	
	private RepeatPaginator paginatorFavoris;
	private RepeatPaginator paginatorSouhaits;
	
	private Date dateAjout;
	private String dateAjoutFormat;
	private Image PremiereImage;

	@PostConstruct
	public void init(){
		favoris = proxyFavoris.afficherFavorisByIdParticipant(cnxBean.getParticipant().getIdparticipant());
		setPaginatorFavoris(new RepeatPaginator(favoris));
		souhaits = proxyFavoris.afficherSouhaitsByIdParticipant(cnxBean.getParticipant().getIdparticipant());
		setPaginatorSouhaits(new RepeatPaginator(souhaits));
		setDateAjout(favoris.get(0).getObjet().getDateajout());
		DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
		setDateAjoutFormat(outputFormatter.format(dateAjout));
		setPremiereImage(proxyFavoris.AfficherPremiereImageParIdObjet(favoris.get(0).getObjet().getIdobjet()));
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

	public Image getPremiereImage() {
		return PremiereImage;
	}

	public void setPremiereImage(Image premiereImage) {
		PremiereImage = premiereImage;
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
	
	

}