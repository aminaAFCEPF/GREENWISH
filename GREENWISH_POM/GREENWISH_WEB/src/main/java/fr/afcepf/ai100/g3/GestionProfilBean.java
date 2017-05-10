package fr.afcepf.ai100.g3;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "mbGestionProfil")
@SessionScoped
public class GestionProfilBean {
	
	
	@EJB
	private IBusinessGestionProfil proxyGestionProfil;
	
	@EJB
	IDaoHoraire proxyDaoHoraire;
	@EJB
	IDaoJour proxyDaoJour;
	@EJB
	IDaoDisponibilite proxyDaoDispo;
	
	@ManagedProperty(value="#{mbCnx}")
	private ConnexionBean mbCnx;
	
    private Participant participant;
    private String msgConfirmModif = "Modifications effectuées avec succès";
    
	private List<Ville> villes;
	private Ville selectedville = new Ville();
	
	@PostConstruct
    public void init(){
    	participant = mbCnx.getParticipant();
    }
	
	
    
	public void majInformationsParticipant() {
		StringBuilder sb = new StringBuilder("resultat : ");
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String[] jours = request.getParameterValues("day");
		String[] h1 = request.getParameterValues("h1");
		String[] m1 = request.getParameterValues("m1");
		String[] h2 = request.getParameterValues("h2");
		String[] m2 = request.getParameterValues("m2");
		int taille = h1.length;
		Disponibilite disponibilite = participant.getDisponibilite();
		for (int i = 0; i < taille; i++) {
			Time t1 = new Time(Integer.parseInt(h1[i]), Integer.parseInt(m1[i]), 0);
			Time t2 = new Time(Integer.parseInt(h2[i]), Integer.parseInt(m2[i]), 0);
			System.out.println("times créés");
			Jour jour = new Jour();
			jour.setDisponibilite(disponibilite);
			jour.setNomjour(jours[i]);
			System.out.println("jour créé");
			jour = proxyDaoJour.ajouterJour(jour);
			System.out.println("jour persisté");
			Horaire horaire = new Horaire(jour, t1, t2);
			System.out.println("horaire créé");
			horaire = proxyDaoHoraire.ajouterHoraire(horaire);
			System.out.println("horaire persisté");
			jour.getHoraires().add(horaire);
			System.out.println("horaire ajouté a jour");
			
			disponibilite.getJours().add(jour);
			System.out.println("jour ajouté a la disponibilité du participant");

			sb.append(jours[i]).append(", ").append(h1[i]).append(" - ").append(m1[i])
				.append(" à ").append(h2[i]).append(" - ").append(m2[i]).append("\r\n");
		}
		System.out.println(sb);
		proxyGestionProfil.updateParticipant(participant);
		
	}
	public String ajoutLigneTabHTML () {
		StringBuilder sb = new StringBuilder();
		sb.append("<tr>").append("<td>coucou</td>").append("<td>toto</td>").append("</tr>");
		return sb.toString();
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
