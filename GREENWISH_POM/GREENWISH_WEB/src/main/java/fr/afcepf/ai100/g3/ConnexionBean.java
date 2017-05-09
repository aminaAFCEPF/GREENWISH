package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "mbCnx")
@SessionScoped
public class ConnexionBean {
	@EJB
	private IBusinessIdentification proxyIdentification;
	private String mail;
	private String mdp;
	private Participant participant;
	private String pageRedirection = "/AccueilAdh.xhtml?faces-redirect=true";

	public String seConnecter() {
		participant = proxyIdentification.identifier(mail, mdp);
		String nav = "";
		if (participant.isStatutadmin()) {
			nav = "/AccueilAdmin.xhtml?faces-redirect=true";
		} else {
			nav = pageRedirection;
		}
		return nav;
	}

	public String seDeconnecter() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		return "/Accueil.xhtml?faces-redirect=true";
	}
	
	
	public void securePage() {
		if(participant == null) {
			ConfigurableNavigationHandler  nav =
					(ConfigurableNavigationHandler)
					FacesContext.getCurrentInstance()
					.getApplication()
					.getNavigationHandler();
			nav.performNavigation("/Connexion.xhtml?faces-redirect=true");
		}
	}

	public IBusinessIdentification getProxyIdentification() {
		return proxyIdentification;
	}

	public void setProxyIdentification(IBusinessIdentification proxyIdentification) {
		this.proxyIdentification = proxyIdentification;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public String getPageRedirection() {
		return pageRedirection;
	}

	public void setPageRedirection(String pageRedirection) {
		this.pageRedirection = pageRedirection;
	}

}
