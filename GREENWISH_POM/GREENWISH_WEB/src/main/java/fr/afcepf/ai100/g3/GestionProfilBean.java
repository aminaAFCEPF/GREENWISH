package fr.afcepf.ai100.g3;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbAjouterObjet")
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
    
    public void AfficherProfil(int idParticipant){
    	
    }

}
