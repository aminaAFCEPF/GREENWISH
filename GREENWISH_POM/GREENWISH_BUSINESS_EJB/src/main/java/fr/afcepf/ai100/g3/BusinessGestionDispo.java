package fr.afcepf.ai100.g3;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(IBusinessGestionDispo.class)
@Stateless
public class BusinessGestionDispo implements IBusinessGestionDispo{

	@EJB 
	IDaoHoraire proxyDaoHoraire;
	IDaoJour proxyDaoJour;
	IDaoDisponibilite proxyDaoDispo;
	
	private Horaire horaire;
	private Jour jour;
	private Disponibilite dispo;
	
	
	
	@Override
	public void ajouterDispo() {
		proxyDaoHoraire.ajouterHoraire(horaire);
		proxyDaoJour.ajouterJour(jour);
		proxyDaoDispo.ajouterDisponibilite(dispo);
	}


	public IDaoHoraire getProxyDaoHoraire() {
		return proxyDaoHoraire;
	}


	public void setProxyDaoHoraire(IDaoHoraire proxyDaoHoraire) {
		this.proxyDaoHoraire = proxyDaoHoraire;
	}


	public IDaoJour getProxyDaoJour() {
		return proxyDaoJour;
	}


	public void setProxyDaoJour(IDaoJour proxyDaoJour) {
		this.proxyDaoJour = proxyDaoJour;
	}


	public IDaoDisponibilite getProxyDaoDispo() {
		return proxyDaoDispo;
	}


	public void setProxyDaoDispo(IDaoDisponibilite proxyDaoDispo) {
		this.proxyDaoDispo = proxyDaoDispo;
	}


	public Horaire getHoraire() {
		return horaire;
	}


	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}


	public Jour getJour() {
		return jour;
	}


	public void setJour(Jour jour) {
		this.jour = jour;
	}


	public Disponibilite getDispo() {
		return dispo;
	}


	public void setDispo(Disponibilite dispo) {
		this.dispo = dispo;
	}
	
	

}
