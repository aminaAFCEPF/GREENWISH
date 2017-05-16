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

@ManagedBean(name="mbMesObjet")
@SessionScoped
public class MesObjetsBean {

	@EJB
	private IBusinessFicheObjet proxyBusinessObjet;

	@EJB
	private IBusinessMesObjets proxyBusinessMesObjets;

	@EJB
	private IBusinessCatalogue proxyBusinessCatalogue;

	@ManagedProperty(value = "#{mbCnx}")
	private ConnexionBean mbCnx;

	private List<Objet> objets;
	private List<Objet> tousObjets;
	private RepeatPaginator paginator;

	private String intitule;
	private Image image;
	private String valeur;
	private String domaine;
	private String categorie;
	private String ssCategorie;
	private Date dateAjout;
	private String description;
	private String liste;
	
	@PostConstruct
	public void init(){
		this.objets = proxyBusinessMesObjets.AfficherObjetParIdParticipant(mbCnx.getParticipant().getIdparticipant());
		this.setTousObjets(proxyBusinessMesObjets.AfficherTousObjets());
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
	
	public String RedirectAjouterObjet(){
		return "/AjouterObjet.xhtml?faces-redirect=true";
	}
	
	public String removeObjet(Objet objet){
		proxyBusinessMesObjets.supprimerObjet(objet);
		return "/MesObjets.xhtml?faces-redirect=true";	
	}
	
	public String modifyObjet(Objet objet){
		return "/AjouterObjet.xhtml?faces-redirect=true";
		
	}
	
	public IBusinessFicheObjet getProxyBusinessObjet() {
		return proxyBusinessObjet;
	}

	public void setProxyBusinessObjet(IBusinessFicheObjet proxyBusinessObjet) {
		this.proxyBusinessObjet = proxyBusinessObjet;
	}

	public IBusinessMesObjets getProxyBusinessMesObjets() {
		return proxyBusinessMesObjets;
	}

	public void setProxyBusinessMesObjets(IBusinessMesObjets proxyBusinessMesObjets) {
		this.proxyBusinessMesObjets = proxyBusinessMesObjets;
	}

	public ConnexionBean getMbCnx() {
		return mbCnx;
	}

	public void setMbCnx(ConnexionBean mbCnx) {
		this.mbCnx = mbCnx;
	}

	public List<Objet> getObjets() {
		return objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getSsCategorie() {
		return ssCategorie;
	}

	public void setSsCategorie(String ssCategorie) {
		this.ssCategorie = ssCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getListe() {
		return liste;
	}

	public void setListe(String liste) {
		this.liste = liste;
	}

	public RepeatPaginator getPaginator() {
		return paginator;
	}

	public void setPaginator(RepeatPaginator paginator) {
		this.paginator = paginator;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public List<Objet> getTousObjets() {
		return tousObjets;
	}

	public void setTousObjets(List<Objet> tousObjets) {
		this.tousObjets = tousObjets;
	}


}
