package fr.afcepf.ai100.g3.testDao;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.ai100.g3.IDaoActivation;
import fr.afcepf.ai100.g3.Participant;

@ManagedBean(name = "mbActivation")
@ViewScoped
public class ActivationDaoBean {

	@EJB
	private IDaoActivation proxyActivation;
	private int idParticipant;
	private Date dateActivation;
	private Date dateDesactivation = new Date();
	@PersistenceContext(unitName = "GREENWISH_DATA_EJB")
	EntityManager em;
	
	public Participant recupererParticipant(){
		
		Participant p = em.find(Participant.class, idParticipant);
		return p;
	}
	
	public void activer() {
		Participant participant = recupererParticipant();
		proxyActivation.activer(participant, dateActivation);
		
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(Calendar.MONTH, 4);
	}
	
	
	
	
	

	public IDaoActivation getProxyActivation() {
		return proxyActivation;
	}

	public void setProxyActivation(IDaoActivation proxyActivation) {
		this.proxyActivation = proxyActivation;
	}

	public int getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	public Date getDateActivation() {
		return dateActivation;
	}

	public void setDateActivation(Date dateActivation) {
		this.dateActivation = dateActivation;
	}

	public Date getDateDesactivation() {
		return dateDesactivation;
	}

	public void setDateDesactivation(Date dateDesactivation) {
		this.dateDesactivation = dateDesactivation;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	
	
	
	
}
