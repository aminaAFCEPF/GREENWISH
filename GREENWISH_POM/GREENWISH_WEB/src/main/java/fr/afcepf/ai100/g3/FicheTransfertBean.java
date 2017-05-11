package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.New;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbFicheTransfert")
@SessionScoped
public class FicheTransfertBean {

	
	
	@ManagedProperty(value="#{mbFicheObjet}")
	private FicheObjetBean mbFicheObjet;
	@EJB
	private IBusinessFicheTransfert proxyFicheTransfert;

	private Echange echange;
	private Rdv rdv;
	private Objet objet;
	private Participant participantDonneur;
	private Participant participantReceveur;
	private List<Message> messages = new ArrayList<>();
	private List<String> adresseDuRdvs = new ArrayList<>();
	private List<Ville> villeDuRdv;
	private Date dateDuRdv;
	private String message = "Bonjour, votre objet m'intéresse, je souhaiterais vous proposer un rendez-vous.";
	private String selectedAdresseDuRdv = "";
	private Ville selectedVilleDuRdv;

	@PostConstruct
	public void initFillAdresseRdv(){
		adresseDuRdvs.add(mbFicheObjet.getAdresseParticipantDonneur());
	adresseDuRdvs.add(mbFicheObjet.getAdresseParticipantReceveur());
		 for (String adresse : adresseDuRdvs){
			 System.out.println(adresse);
		 }
	}
	
	public FicheObjetBean getMbFicheObjet() {
		return mbFicheObjet;
	}

	public void setMbFicheObjet(FicheObjetBean mbFicheObjet) {
		this.mbFicheObjet = mbFicheObjet;
	}

	public List<Ville> getVilleDuRdv() {
		return villeDuRdv;
	}

	public List<String> getAdresseDuRdvs() {
		return adresseDuRdvs;
	}

	public void setAdresseDuRdvs(List<String> adresseDuRdvs) {
		this.adresseDuRdvs = adresseDuRdvs;
	}

	public String getSelectedAdresseDuRdv() {
		return selectedAdresseDuRdv;
	}

	public void setSelectedAdresseDuRdv(String selectedAdresseDuRdv) {
		this.selectedAdresseDuRdv = selectedAdresseDuRdv;
	}

	public Ville getSelectedVilleDuRdv() {
		return selectedVilleDuRdv;
	}

	public void setSelectedVilleDuRdv(Ville selectedVilleDuRdv) {
		this.selectedVilleDuRdv = selectedVilleDuRdv;
	}

	public IBusinessFicheObjet getProxyFicheObjet() {
		return proxyFicheObjet;
	}

	public void setProxyFicheObjet(IBusinessFicheObjet proxyFicheObjet) {
		this.proxyFicheObjet = proxyFicheObjet;
	}

	public void setVilleDuRdv(List<Ville> villeDuRdv) {
		this.villeDuRdv = villeDuRdv;
	}

	@EJB
	private IBusinessFicheObjet proxyFicheObjet;

	public Date getDateDuRdv() {
		return dateDuRdv;
	}

	public void setDateDuRdv(Date dateDuRdv) {
		this.dateDuRdv = dateDuRdv;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public IBusinessFicheTransfert getProxyFicheTransfert() {
		return proxyFicheTransfert;
	}

	public void setProxyFicheTransfert(IBusinessFicheTransfert proxyFicheTransfert) {
		this.proxyFicheTransfert = proxyFicheTransfert;
	}

	public Echange getEchange() {
		return echange;
	}

	public void setEchange(Echange echange) {
		this.echange = echange;
	}

	public Rdv getRdv() {
		return rdv;
	}

	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}

	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

	public Participant getParticipantDonneur() {
		return participantDonneur;
	}

	public void setParticipantDonneur(Participant participantDonneur) {
		this.participantDonneur = participantDonneur;
	}

	public Participant getParticipantReceveur() {
		return participantReceveur;
	}

	public void setParticipantReceveur(Participant participantReceveur) {
		this.participantReceveur = participantReceveur;
	}

	private String genererCodeFin() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
		String pass = "";
		for (int x = 0; x < 8; x++) {
			int i = (int) Math.floor(Math.random() * 62); // Si tu supprimes des lettres tu diminues ce nb
			pass += chars.charAt(i);
		}
		return pass;
	}

	public String creerEchange (Objet objet, Participant participantReceveur){
		this.objet = objet;
		this.participantDonneur = proxyFicheObjet.recupProprio(objet.getIdobjet());
		this.participantReceveur = participantReceveur;
		//this.messages = messages;
		
				
		Echange echange = new Echange(null, null, objet, null, new Date(), null, null, genererCodeFin(), objet.getValeur().getValeur(), null, null);
		Rdv rdv = new Rdv(echange, selectedVilleDuRdv, dateDuRdv, selectedAdresseDuRdv, participantReceveur);
		//echange.setRdv(rdv);
		
		
		echange = proxyFicheTransfert.ajouterEchange(echange);
		rdv.setEchange(echange);
		rdv.setDaterdv(new Date());
		this.rdv = proxyFicheTransfert.ajouterRdv(rdv);
		
		return "/FicheTransfert.xhtml?faces-redirect=true";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	
}


















