package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "mbInscription")
@ViewScoped
public class InscriptionBean {
	@ManagedProperty(value = "#{mbCnx}")
	ConnexionBean mbCnx;
	@EJB
	private IBusinessInscription proxyInscription;
	@EJB
	private IDaoVille proxyDaoVille;
	private String adresse;
	private Date datenaissance = new Date();
	private String mail;
	private String nom;
	private String password;
	private String prenom;
	private String telephone;
	private String codePostal;
	private List<Ville> villes;
	private Ville selectedville = new Ville();
	
	public void rechercherVilles(){
		villes = proxyDaoVille.rechercherVille(codePostal);
	}
	
	public String inscrire(){
		List<Inscription> inscriptions = new ArrayList<>();
		Inscription inscription = new Inscription();
		inscriptions.add(inscription);
		inscription.setDateinscription(new Date());
		
		Participant participant = new Participant(selectedville, nom, prenom, datenaissance, adresse, mail, 0, password, false);
		participant = proxyInscription.inscrire(participant);
		
	    proxyInscription.creerListeProp(new ListeProposition(participant, "Ma première liste", true));
		
		mbCnx.setMail(mail);
		mbCnx.setMdp(password);
		
		return mbCnx.seConnecter();
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

	public String getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public Ville getSelectedville() {
		return selectedville;
	}

	public void setSelectedville(Ville selectedville) {
		this.selectedville = selectedville;
	}

	public ConnexionBean getMbCnx() {
		return mbCnx;
	}

	public void setMbCnx(ConnexionBean mbCnx) {
		this.mbCnx = mbCnx;
	}

	public IDaoVille getProxyDaoVille() {
		return proxyDaoVille;
	}

	public void setProxyDaoVille(IDaoVille proxyDaoVille) {
		this.proxyDaoVille = proxyDaoVille;
	}
	
	public void remplirChamp(){
		setAdresse("53 rue mozart");
		setCodePostal("77220");
		setSelectedville(new Ville("Tournan en Brie", "77220"));
		setMail("Mowgli@Gmail.com");
		setNom("Jungle");
		setPrenom("Mowgli");
		setPassword("afcepf");
	}
	
}
