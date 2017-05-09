package fr.afcepf.ai100.g3;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbGestionProfil")
@SessionScoped
public class GestionProfilBean {
	
	@EJB
	private IBusinessGestionProfil proxyGestionProfil;
	
	
	private Disponibilite disponibilite;
    private Ville ville;
    private String nom;
    private String prenom;
    private Date datenaissance;
    private String adresse;
    private String mail;
    private String telephone;
    private String password;
    private Participant participant;
    private String msgConfirmModif = "Modifications effectuées avec succès";
    
    @PostConstruct
    public void AfficherProfil(int idParticipant){
    	
    	
    	
    }
    
    public Participant majInformationsParticipant(){
    	proxyGestionProfil.updateParticipant(participant);
    	participant = new Participant();
    	participant.setNom(nom);
    	participant.setPrenom(prenom);
    	participant.setMail(mail);
    	
    	participant.setVille(ville);
    	participant.setDisponibilite(disponibilite);
    	
    	return participant;
    }
    
    

	public IBusinessGestionProfil getProxyGestionProfil() {
		return proxyGestionProfil;
	}

	public void setProxyGestionProfil(IBusinessGestionProfil proxyGestionProfil) {
		this.proxyGestionProfil = proxyGestionProfil;
	}

	public Disponibilite getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Disponibilite disponibilite) {
		this.disponibilite = disponibilite;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Participant getParticipant() {	
		return proxyGestionProfil.rechercherParticipantById(2);
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
    
    

}
