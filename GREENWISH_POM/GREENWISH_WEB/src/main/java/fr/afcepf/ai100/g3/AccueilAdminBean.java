package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.Part;

@ManagedBean(name="mbAccueilAdmin")
@ViewScoped
public class AccueilAdminBean {
	
	@EJB
	private IBusinessGestionAdh proxyGestionAdh;
	
	public String redirectGestionAdh(){
		return "/GestionAdh.xhtml?faces-redirect=true";	
	}
	
	public String redirectGestionTransferts(){
		return "/GestionTransferts.xhtml?faces-redirect=true";	
	}
	
	public String redirectGestionActus(){
		return "/Actus.xhtml?faces-redirect=true";	
	}
	
	public String redirectGestionLitiges(){
		return "/GestionLitiges.xhtml?faces-redirect=true";	
	}
	
	public String redirectGestionObjets(){
		return "/GestionObjets.xhtml?faces-redirect=true";	
	}
	
	public String redirectAccueilAdmin(){
		return "/AccueilAdmin.xhtml?faces-redirect=true";	
	}
	
	public List<Participant> afficherTousParticipant(){
		return proxyGestionAdh.getAllParticipants();
		
	}
	
}
