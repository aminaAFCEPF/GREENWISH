package fr.afcepf.ai100.g3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	private boolean proprio;
	private boolean rdvAccepte;
	private boolean echangeTermine;
	private String code;
	private boolean codeBon;
	private boolean modifierRdv;
	
	
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
		echange.setDaterefus(new Date());
		proxyFicheTransfert.MAJ(echange);
		return "/AccueilAdh.xhtml?faces-redirect=true";
	}
	public String envoyerMessage(){
		if(cnxBean.getParticipant() == participantDonneur){
			String auteur = participantDonneur.getNom() + " " + participantDonneur.getPrenom();
			Message message1 = new Message(participantReceveur.getMessagerie(), this.message, echange, new Date(), auteur);
			Message message2 = new Message(participantDonneur.getMessagerie(), this.message, echange, new Date(), auteur);
			message1 = proxyFicheTransfert.ajouterMessage(message1);
			message2 = proxyFicheTransfert.ajouterMessage(message2);
			messages.add(message2);
		}
		else{
			String auteur = participantReceveur.getNom() + " " + participantReceveur.getPrenom();
			Message message1 = new Message(participantReceveur.getMessagerie(), this.message, echange, new Date(), auteur);
			Message message2 = new Message(participantDonneur.getMessagerie(), this.message, echange, new Date(), auteur);
			message1 = proxyFicheTransfert.ajouterMessage(message1);
			message2 = proxyFicheTransfert.ajouterMessage(message2);
			messages.add(message1);
		}
		
		return "/FicheTransfert.xhtml?faces-redirect=true";
	}
	
	public String recupEchange(Echange echange){
		this.objet = echange.getObjet();
		this.participantDonneur = proxyFicheObjet.recupProprio(objet.getIdobjet());
		this.participantReceveur = echange.getRdv().getParticipant();
		this.rdv = echange.getRdv();
		codeBon = true;
		modifierRdv = false;
		Date dateRdv = echange.getRdv().getDaterdv();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm");
		displayDate = sdf2.format(dateRdv)+ " à " + sdf3.format(dateRdv);
		
		if(cnxBean.getParticipant().getIdparticipant() == participantDonneur.getIdparticipant()){
			this.proprio = true;
		}else{
			this.proprio = false;
		}
		
		Date date = new Date();
		Date daterdv = echange.getRdv().getDaterdv();
		
		
		
		
		if(echange.getRdv().getDaterdv().before(date)){
			rdvPasse=true;
		}else{
			rdvPasse=false;
		}
		
		if(echange.getRdv().isRdvValide()){
			rdvAccepte = true;
		}else{
			rdvAccepte = false;
		}
		
		if(echange.getDateFin() == null){
			echangeTermine= false;
		}else{
			echangeTermine = true;
		}
		System.out.println(rdvPasse);
			
		return "/FicheTransfert.xhtml?faces-redirect=true";
	}

	public String creerEchange (Objet objet, Participant participantReceveur){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		try {
			dateDuRdv = sdf.parse(dateDuRdvString);
		} catch (ParseException e) {
			dateDuRdv = new Date();
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm");
		displayDate = sdf2.format(dateDuRdv)+ " à " + sdf3.format(dateDuRdv);
		this.objet = objet;
		dateAjoutObjet = sdf2.format(objet.getDateajout());
		this.participantDonneur = proxyFicheObjet.recupProprio(objet.getIdobjet());
		this.participantReceveur = participantReceveur;
		this.participant = (proxyFicheTransfert.rechercherParticipantParId(this.selectedIdParticipant));
				
		echange = new Echange(null, null, objet, null, new Date(), null, null, genererCodeFin(), objet.getValeur().getValeur(), null, null);
		
		Rdv rdv = new Rdv(echange, participant.getVille(), this.dateDuRdv, participant.getAdresse(), participantReceveur, false);
		
		echange = proxyFicheTransfert.ajouterEchange(echange);
		rdv.setEchange(echange);
		rdv = proxyFicheTransfert.ajouterRdv(rdv);
		echange.setRdv(rdv);
		echange = proxyFicheTransfert.MAJ(echange);
		
		participantReceveur.setSolde(participantReceveur.getSolde()-objet.getValeur().getValeur());
		proxyFicheTransfert.modifierPoints(participantReceveur);
		
		String auteur = participantReceveur.getNom() + " " + participantReceveur.getPrenom();
		
		Message message1 = new Message(participantReceveur.getMessagerie(), this.message, echange, new Date(), auteur);
		Message message2 = new Message(participantDonneur.getMessagerie(), this.message, echange, new Date(), auteur);
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
		rdvAccepte = false;
		echangeTermine= false;
		codeBon = true;
		modifierRdv = false;
		
		return "/FicheTransfert.xhtml?faces-redirect=true";
	}
	
	public void modifierDateRdv(){
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
		this.participant = (proxyFicheTransfert.rechercherParticipantParId(this.selectedIdParticipant));
		
		
		rdv.setDaterdv(dateDuRdv);
		rdv.setAdresse(participant.getAdresse());
		rdv.setVille(participant.getVille());
		proxyFicheTransfert.MAJ(rdv);
		
		if(cnxBean.getParticipant() == participantDonneur){
			String auteur = participantDonneur.getNom() + " " + participantDonneur.getPrenom();
			Message message1 = new Message(participantReceveur.getMessagerie(), this.message, echange, new Date(), auteur);
			Message message2 = new Message(participantDonneur.getMessagerie(), this.message, echange, new Date(), auteur);
			message1 = proxyFicheTransfert.ajouterMessage(message1);
			message2 = proxyFicheTransfert.ajouterMessage(message2);
			messages.add(message2);
		}
		else{
			String auteur = participantReceveur.getNom() + " " + participantReceveur.getPrenom();
			Message message1 = new Message(participantReceveur.getMessagerie(), this.message, echange, new Date(), auteur);
			Message message2 = new Message(participantDonneur.getMessagerie(), this.message, echange, new Date(), auteur);
			message1 = proxyFicheTransfert.ajouterMessage(message1);
			message2 = proxyFicheTransfert.ajouterMessage(message2);
			messages.add(message1);
		}
		
	}
	
    public void laisserUnAvis(){
		
	}

	public void accepterRdv(){
		rdv.setRdvValide(true);
		proxyFicheTransfert.MAJ(rdv);
		rdvAccepte = true;
	}
	
	public void finaliserEchange(){
		if(code == echange.getCodefin()){
			echange.setDateFin(new Date());
			echange = proxyFicheTransfert.MAJ(echange);
		}else{
			codeBon = false;
		}
	}
	
	public void modifierRdv(){
		setModifierRdv(true);
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

	public boolean isProprio() {
		return proprio;
	}

	public void setProprio(boolean proprio) {
		this.proprio = proprio;
	}

	public boolean isRdvAccepte() {
		return rdvAccepte;
	}

	public void setRdvAccepte(boolean rdvAccepte) {
		this.rdvAccepte = rdvAccepte;
	}

	public boolean isEchangeTermine() {
		return echangeTermine;
	}

	public void setEchangeTermine(boolean echangeTermine) {
		this.echangeTermine = echangeTermine;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isCodeBon() {
		return codeBon;
	}

	public void setCodeBon(boolean codeBon) {
		this.codeBon = codeBon;
	}

	public boolean isModifierRdv() {
		return modifierRdv;
	}

	public void setModifierRdv(boolean modifierRdv) {
		this.modifierRdv = modifierRdv;
	}

	
	
}


















