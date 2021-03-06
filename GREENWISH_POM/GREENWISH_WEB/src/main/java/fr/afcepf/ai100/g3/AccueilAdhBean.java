package fr.afcepf.ai100.g3;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "mbAcceuilAdh")
@ViewScoped
public class AccueilAdhBean {
	
	@ManagedProperty(value="#{mbCnx}")
	private ConnexionBean mbCnx;
	@EJB
	private IBusinessGestionAdh proxyBusinessGestionAdh;
	@EJB
	private IBusinessCatalogue proxyBusinessCatalogue;
	@EJB
	private IBusinessMesObjets proxyBusinessMesObjets;
	
	@EJB
	private IBusinessGestionEchange proxyBusinessEchange;

	private Participant participant;
	private List<Objet> suggestions = new ArrayList<>();
	private List<Objet> objets;
	
	@PostConstruct
	public void init(){
		participant = mbCnx.getParticipant();
		objets = proxyBusinessMesObjets.AfficherObjetParIdParticipant(mbCnx.getParticipant().getIdparticipant());
	}
	
	
	public int nbNotifsNonLues(){
		
		return proxyBusinessGestionAdh.rechercherNotificationNonLuesByParticipant(participant.getIdparticipant()).size();
	}
	
	public List<Objet> afficherSuggestions(int page){
		if(page == 1){
			return proxyBusinessCatalogue.afficherTousLesObjets().subList(0, 3);
		}
		else{
			return proxyBusinessCatalogue.afficherTousLesObjets().subList(4, 6);
		}
		
	}
	
	public double calculEcoCO(){
		double coeff = 3.5;
		int nbEchangesTermines = proxyBusinessEchange.afficherLesEchangesTerminesDUnParticipant(participant.getIdparticipant()).size();
		return coeff*nbEchangesTermines;
		
	}
	
	
	public String afficherProfil(){
		return "/ProfilAdh.xhtml?faces-redirect=true";
	}
	
	public String afficherObjets(){
		return "/MesObjets.xhtml?faces-redirect=true";
	}
	
	public String afficherTransferts(){
		return "/AccueilTransfert.xhtml?faces-redirect=true";
	}
	
	public String afficherFavoris(){
		return "/Favoris.xhtml?faces-redirect=true";
	}
	
	public ConnexionBean getMbCnx() {
		return mbCnx;
	}

	public void setMbCnx(ConnexionBean mbCnx) {
		this.mbCnx = mbCnx;
	}


	public Participant getParticipant() {
		return participant;
	}


	public void setParticipant(Participant participant) {
		this.participant = participant;
	}


	public IBusinessGestionAdh getProxyBusinessGestionAdh() {
		return proxyBusinessGestionAdh;
	}


	public void setProxyBusinessGestionAdh(IBusinessGestionAdh proxyBusinessGestionAdh) {
		this.proxyBusinessGestionAdh = proxyBusinessGestionAdh;
	}


	public IBusinessCatalogue getProxyBusinessCatalogue() {
		return proxyBusinessCatalogue;
	}


	public void setProxyBusinessCatalogue(IBusinessCatalogue proxyBusinessCatalogue) {
		this.proxyBusinessCatalogue = proxyBusinessCatalogue;
	}


	public List<Objet> getSuggestions() {
		return suggestions;
	}


	public void setSuggestions(List<Objet> suggestions) {
		this.suggestions = suggestions;
	}


	public IBusinessGestionEchange getProxyBusinessEchange() {
		return proxyBusinessEchange;
	}


	public void setProxyBusinessEchange(IBusinessGestionEchange proxyBusinessEchange) {
		this.proxyBusinessEchange = proxyBusinessEchange;
	}


	public List<Objet> getObjets() {
		return objets;
	}


	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}


	
	
	
	

}
