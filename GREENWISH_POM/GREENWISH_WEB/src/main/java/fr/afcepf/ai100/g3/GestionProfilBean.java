package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbGestionProfil")
@SessionScoped
public class GestionProfilBean {
	
	@EJB
	private IBusinessGestionProfil proxyGestionProfil;
	
	@ManagedProperty(value="#{mbCnx}")
	private ConnexionBean mbCnx;
	
    private Participant participant;
    private String msgConfirmModif = "Modifications effectuées avec succès";
    
	private List<Ville> villes;
	private Ville selectedville = new Ville();
	
	private List<Disponibilite> listeDispos = new ArrayList<>();
    
    public List<Disponibilite> getListeDispos() {
		return listeDispos;
	}

	public void setListeDispos(List<Disponibilite> listeDispos) {
		this.listeDispos = listeDispos;
	}

	public ConnexionBean getMbCnx() {
		return mbCnx;
	}

    public void rechercherVilles(){
		villes = proxyGestionProfil.rechercherVille(participant.getVille().getCodePostal()); 
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

	public void setMbCnx(ConnexionBean mbCnx) {
		this.mbCnx = mbCnx;
	}



	public String getMsgConfirmModif() {
		return msgConfirmModif;
	}



	public void setMsgConfirmModif(String msgConfirmModif) {
		this.msgConfirmModif = msgConfirmModif;
	}



	@PostConstruct
    public void init(){
    	participant = mbCnx.getParticipant();
    }    
    
    

	public IBusinessGestionProfil getProxyGestionProfil() {
		return proxyGestionProfil;
	}

	public void setProxyGestionProfil(IBusinessGestionProfil proxyGestionProfil) {
		this.proxyGestionProfil = proxyGestionProfil;
	}

	public Participant getParticipant() {	
		return proxyGestionProfil.rechercherParticipantById(2);
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
    
	
    

}
