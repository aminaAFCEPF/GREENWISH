package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbInscription")
@SessionScoped
public class InscriptionBean {

	@EJB
	private IBusinessInscription proxyInscription;
	@EJB
	private IDaoVille proxyDaoVille;
	private String adresse = "rue des marins";
	private Date datenaissance = new Date();
	private String mail;
	private String nom;
	private String password;
	private String prenom;
	private String telephone;
	private Ville ville;
	
	public String inscrire(){
		List<Inscription> inscriptions = new ArrayList<>();
		Inscription inscription = new Inscription();
		inscriptions.add(inscription);
		inscription.setDateinscription(new Date());
		ville = new Ville();
		ville.setIdville(4);
		
		Participant participant = new Participant(ville, nom, prenom, datenaissance, adresse, mail, 0, password, false);
		proxyInscription.inscrire(participant);
		return null;
	}

	public IBusinessInscription getProxyInscription() {
		return proxyInscription;
	}

	public void setProxyInscription(IBusinessInscription proxyInscription) {
		this.proxyInscription = proxyInscription;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	
	
	
}
