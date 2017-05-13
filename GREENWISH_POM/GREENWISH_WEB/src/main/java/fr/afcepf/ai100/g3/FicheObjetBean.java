package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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

	@ManagedProperty(value="#{mbCnx}")
	private ConnexionBean cnxBean;
	
	private Objet objet;
	private List<Image> images;
	private String valeur;
	private String idAge;
	private boolean isConnecte;
	private boolean NotMyObjet = true;
	private boolean connecteAndNotMyObjetCptPointsOk = false;
	private boolean cptPointsOk = true;
	private Disponibilite disponibilite;
	private Horaire h = new Horaire();
	private Jour j = new Jour();
	private String Message;
	private List<Participant> participants = new ArrayList<>();
	private Participant participantDonneur;

	

	public Participant getParticipantDonneur() {
		return participantDonneur;
	}

	public void setParticipantDonneur(Participant participantDonneur) {
		this.participantDonneur = participantDonneur;
	}

	public Horaire getH() {
		return h;
	}

	public void setH(Horaire h) {
		this.h = h;
	}

	public Jour getJ() {
		return j;
	}

	public void setJ(Jour j) {
		this.j = j;
	}


	public Disponibilite getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Disponibilite disponibilite) {
		this.disponibilite = disponibilite;
	}

	public ConnexionBean getCnxBean() {
		return cnxBean;
	}

	public void setCnxBean(ConnexionBean cnxBean) {
		this.cnxBean = cnxBean;
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

	public boolean isconnecteAndNotMyObjetCptPointsOk() {
		return connecteAndNotMyObjetCptPointsOk;
	}

	public void setconnecteAndNotMyObjetCptPointsOk(boolean connecteAndNotMyObjetCptPointsOk) {
		this.connecteAndNotMyObjetCptPointsOk = connecteAndNotMyObjetCptPointsOk;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public boolean isCptPointsOk() {
		return cptPointsOk;
	}

	public void setCptPointsOk(boolean cptPointsOk) {
		this.cptPointsOk = cptPointsOk;
	}
	
	public String afficherObjet(Objet objet){
		this.objet = objet;
		this.images = proxyFicheObjet.getImageByIdObjet(objet.getIdobjet());
		this.valeur = objet.getValeur().toString();
		this.setIdAge(objet.getTrancheAge().getIdage().toString());
		
		this.disponibilite = proxyFicheObjet.recupProprio(objet.getIdobjet()).getDisponibilite();
		participantDonneur = proxyFicheObjet.recupProprio(objet.getIdobjet());
		this.participants.add(participantDonneur);
		
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
				connecteAndNotMyObjetCptPointsOk=false;
				NotMyObjet=false;
				cptPointsOk=true;
			}
			else if (cnxBean.getParticipant().getSolde() < objet.getValeur().getValeur()){
				connecteAndNotMyObjetCptPointsOk=false;
				NotMyObjet=true;
				cptPointsOk=false;
			}else{
				connecteAndNotMyObjetCptPointsOk=true;
				NotMyObjet=true;
				cptPointsOk=true;
				this.participants.add(cnxBean.getParticipant());

			}
			ConfigurableNavigationHandler  nav =
					(ConfigurableNavigationHandler)
					FacesContext.getCurrentInstance()
					.getApplication()
					.getNavigationHandler();
			nav.performNavigation("/FicheObjet.xhtml?faces-redirect=true");

		}
	}
	
	public String redirectionReinitia(String redirection){
		String bla = "http://localhost:8080/GreenWish/faces/";
		bla = bla.concat(redirection);
		this.connecteAndNotMyObjetCptPointsOk=false;
		this.NotMyObjet=true;
		this.cptPointsOk=true;
	return redirection;
	}
	
	public String ajoutLigneTabHTML () {
		StringBuilder sb = new StringBuilder();
		Disponibilite dispo = participantDonneur.getDisponibilite();
		List<Jour> jours = dispo.getJours();
		for(Jour j:jours){
			for(Horaire h : j.getHoraires()){
				sb.append("<tr>").append("<td>").append(j.getNomjour()).append("</td>").append("<td>").append(h.getHeuredebut()).append(" - ").append(h.getHeurefin()).append("</td>").append("</tr>");
			}
		}
		return sb.toString();
	}
	
	public void setUneDispoRdv(Jour j, Horaire h ){
		this.j = j;
		this.h = h;
		System.out.println(j.getNomjour());
		System.out.println(h.getHeuredebut());
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
}
