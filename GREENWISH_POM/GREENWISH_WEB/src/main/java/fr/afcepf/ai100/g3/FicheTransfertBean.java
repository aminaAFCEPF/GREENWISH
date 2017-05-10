package fr.afcepf.ai100.g3;

import java.awt.SystemColor;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbFicheTransfert")
@SessionScoped
public class FicheTransfertBean {

	@EJB
	private IBusinessFicheTransfert proxyFicheTransfert;

	private Echange echange;
	private Rdv rdv;
	private Objet objet;
	private Participant participantDonneur;
	private Participant participantReceveur;
	private List<Message> messages;
	private String adresseDuRdv;
	private Ville villeDuRdv;
	private Date dateDuRdv;

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

	public String getAdresseDuRdv() {
		return adresseDuRdv;
	}

	public void setAdresseDuRdv(String adresseDuRdv) {
		this.adresseDuRdv = adresseDuRdv;
	}

	public Ville getVilleDuRdv() {
		return villeDuRdv;
	}

	public void setVilleDuRdv(Ville villeDuRdv) {
		this.villeDuRdv = villeDuRdv;
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

	public String creerEchange (Objet objet, Participant participantDonneur, Participant participantReceveur, List<Message> messages, String adresseDuRdv, Ville villeDuRdv, Date dateDuRdv){
		this.objet = objet;
		this.participantDonneur = participantDonneur;
		this.participantReceveur = participantReceveur;
		this.messages = messages;
		this.adresseDuRdv = adresseDuRdv;
		this.villeDuRdv = villeDuRdv;
		this.dateDuRdv = dateDuRdv;
				
		Echange echange = new Echange(null, null, objet, null, new Date(), null, null, genererCodeFin(), objet.getValeur().getValeur(), null, null);
		Rdv rdv = new Rdv(echange, villeDuRdv, dateDuRdv, adresseDuRdv, participantReceveur);
		echange.setRdv(rdv);
		rdv.setEchange(echange);
		this.echange = proxyFicheTransfert.ajouterEchange(echange);
		this.rdv = proxyFicheTransfert.ajouterRdv(rdv);
		
		return "/FicheTransfert.xhtml?faces-redirect=true";
	}
}


















