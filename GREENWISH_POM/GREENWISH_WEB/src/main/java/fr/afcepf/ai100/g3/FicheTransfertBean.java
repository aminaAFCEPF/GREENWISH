package fr.afcepf.ai100.g3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	@ManagedProperty(value="#{mbCnx}")
	private ConnexionBean cnxBean;


	@EJB
	private IBusinessFicheTransfert proxyFicheTransfert;
	@EJB
	private IBusinessFicheObjet proxyFicheObjet;

	private Echange echange;
	private Rdv rdv;
	private Objet objet;
	private Participant participantDonneur;
	private Participant participantReceveur;
	private List<Message> messages = new ArrayList<>();
	private String dateDuRdvString;
	private Date dateDuRdv;
	private String message = "Bonjour, votre objet m'intéresse, je souhaiterais vous proposer un rendez-vous.";
	private int selectedIdParticipant;
	private Participant participant;
	private int annee;
	private List<Image> imagesObjet;
	private String displayDate;
	private String dateAjoutObjet;
	private boolean rdvPasse;
	private boolean rdvEnvoye;
	
	public FicheObjetBean getMbFicheObjet() {
		return mbFicheObjet;
	}

	public void setMbFicheObjet(FicheObjetBean mbFicheObjet) {
		this.mbFicheObjet = mbFicheObjet;
	}


	public IBusinessFicheObjet getProxyFicheObjet() {
		return proxyFicheObjet;
	}

	public void setProxyFicheObjet(IBusinessFicheObjet proxyFicheObjet) {
		this.proxyFicheObjet = proxyFicheObjet;
	}

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
	
	public String AnnulerEchange(){
		//this.echange.setDaterefus(new Date());
		return "/AccueilAdh.xhtml?faces-redirect=true";
	}
	public String envoyerMessage(){
		if(cnxBean.getParticipant() == participantDonneur){
			Message message1 = new Message(participantReceveur.getMessagerie(), this.message, echange, new Date());
			Message message2 = new Message(participantDonneur.getMessagerie(), this.message, echange, new Date());
			message1 = proxyFicheTransfert.ajouterMessage(message1);
			message2 = proxyFicheTransfert.ajouterMessage(message2);
			messages.add(message2);
		}
		else{
			Message message1 = new Message(participantReceveur.getMessagerie(), this.message, echange, new Date());
			Message message2 = new Message(participantDonneur.getMessagerie(), this.message, echange, new Date());
			message1 = proxyFicheTransfert.ajouterMessage(message1);
			message2 = proxyFicheTransfert.ajouterMessage(message2);
			messages.add(message1);
		}
		
		return "/FicheTransfert.xhtml?faces-redirect=true";
	}

	public String creerEchange (Objet objet, Participant participantReceveur){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		System.out.println(dateDuRdvString);
		try {
			dateDuRdv = sdf.parse(dateDuRdvString);
		} catch (ParseException e) {
			dateDuRdv = new Date();
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm");
		displayDate = sdf2.format(dateDuRdv)+ " à " + sdf3.format(getDateDuRdv());
		this.objet = objet;
		dateAjoutObjet = sdf2.format(objet.getDateajout());
		this.participantDonneur = proxyFicheObjet.recupProprio(objet.getIdobjet());
		this.participantReceveur = participantReceveur;
		this.participant = (proxyFicheTransfert.rechercherParticipantParId(this.selectedIdParticipant));
				
		echange = new Echange(null, null, objet, null, new Date(), null, null, genererCodeFin(), objet.getValeur().getValeur(), null, null);
		
		Rdv rdv = new Rdv(echange, participant.getVille(), this.dateDuRdv, participant.getAdresse(), participantReceveur);
		
		echange = proxyFicheTransfert.ajouterEchange(echange);
		rdv.setEchange(echange);
		this.rdv = proxyFicheTransfert.ajouterRdv(rdv);
		
		participantReceveur.setSolde(participantReceveur.getSolde()-objet.getValeur().getValeur());
		proxyFicheTransfert.modifierPoints(participantReceveur);
		
		Message message1 = new Message(participantReceveur.getMessagerie(), this.message, echange, new Date());
		Message message2 = new Message(participantDonneur.getMessagerie(), this.message, echange, new Date());
		message1 = proxyFicheTransfert.ajouterMessage(message1);
		message2 = proxyFicheTransfert.ajouterMessage(message2);
		messages.add(message1);
		message = "Bonjour";
		
		mbFicheObjet.getParticipants().clear(); 
		mbFicheObjet.setConnecte(true);
		mbFicheObjet.setconnecteAndNotMyObjetCptPointsOk(false);
		mbFicheObjet.setCptPointsOk(true);
		
		this.annee = objet.getDateajout().getYear() + 1901;
		this.imagesObjet = proxyFicheObjet.getImageByIdObjet(objet.getIdobjet());
		
		rdvPasse = false;
		rdvEnvoye = true;
		
		return "/FicheTransfert.xhtml?faces-redirect=true";
	}
	
	public boolean qui(){
		boolean qui;
		if(cnxBean.getParticipant() == getParticipantDonneur()){
			qui = true;
		}
		else{
			qui=false;
		}
		return qui;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getSelectedIdParticipant() {
		return selectedIdParticipant;
	}

	public void setSelectedIdParticipant(int selectedIdParticipant) {
		this.selectedIdParticipant = selectedIdParticipant;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public String getDateDuRdvString() {
		return dateDuRdvString;
	}

	public void setDateDuRdvString(String dateDuRdvString) {
		this.dateDuRdvString = dateDuRdvString;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public List<Image> getImagesObjet() {
		return imagesObjet;
	}

	public void setImagesObjet(List<Image> imagesObjet) {
		this.imagesObjet = imagesObjet;
	}

	public String getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

	public String getDateAjoutObjet() {
		return dateAjoutObjet;
	}

	public void setDateAjoutObjet(String dateAjoutObjet) {
		this.dateAjoutObjet = dateAjoutObjet;
	}

	public ConnexionBean getCnxBean() {
		return cnxBean;
	}

	public void setCnxBean(ConnexionBean cnxBean) {
		this.cnxBean = cnxBean;
	}

	public boolean isRdvPasse() {
		return rdvPasse;
	}

	public void setRdvPasse(boolean rdvPasse) {
		this.rdvPasse = rdvPasse;
	}

	public boolean isRdvEnvoye() {
		return rdvEnvoye;
	}

	public void setRdvEnvoye(boolean rdvEnvoye) {
		this.rdvEnvoye = rdvEnvoye;
	}
	
}


















