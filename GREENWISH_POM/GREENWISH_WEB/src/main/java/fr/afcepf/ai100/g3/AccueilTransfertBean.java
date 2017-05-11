package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai100.g3.entities.RepeatPaginator;

@ManagedBean(name = "mbAfficherTransfert")
@ViewScoped
public class AccueilTransfertBean {
	@ManagedProperty(value="#{mbCnx}")
	private ConnexionBean mbCnx;
	@EJB
	private IBusinessAjouterObjet proxyAjouterObjet;
	@EJB
	private IBusinessGestionEchange proxyAfficherEchange;
	@EJB
	private IDaoObjet proxyDaoAfficherImage;
	@EJB
	private IDaoEchange proxyTest;
	private List<Echange> echanges;
	private Participant participant;
	private RepeatPaginator paginator;
	private List<String> lesTypesDeRdv = new ArrayList<>();
	private String selectedTypeRdv;
	private List<String> etatsDesTransferts = new ArrayList<>();
	private String selectedEtatDesTransferts;
	private List<String> typesDeTransferts = new ArrayList<>();
	private String selectedTypesDesTransferts;
	

	

	@PostConstruct
	public void init(){
		participant = mbCnx.getParticipant();
		lesTypesDeRdv.add("Rendez-vous proposés");
		lesTypesDeRdv.add("Rendez-vous validés");
		lesTypesDeRdv.add("Rendez-vous terminés");
		lesTypesDeRdv.add("Tous");
		selectedTypeRdv = lesTypesDeRdv.get(0);
		
		etatsDesTransferts.add("Transferts en cours");
		etatsDesTransferts.add("Transferts terminés");
		etatsDesTransferts.add("Tous");
		selectedEtatDesTransferts = etatsDesTransferts.get(0).toString();
		
		typesDeTransferts.add("Tous");
		typesDeTransferts.add("Objets donnés");
		typesDeTransferts.add("Objets reçus");
		selectedTypesDesTransferts = typesDeTransferts.get(0);
		
		
		echanges = proxyAfficherEchange.afficherLesEchangesTries(selectedEtatDesTransferts, selectedTypesDesTransferts, participant.getIdparticipant());
		//echanges=proxyTest.rechercherTousLesEchangesDonnesDUnParticipant(participant.getIdparticipant());		
		paginator = new RepeatPaginator(echanges);
	}
	
	public void chargerLesTransferts(){
//		selectedEtatDesTransferts = etatsDesTransferts.get(0);
//		selectedTypesDesTransferts = typesDeTransferts.get(0);
		
		echanges = proxyAfficherEchange.afficherLesEchangesTries(selectedEtatDesTransferts, selectedTypesDesTransferts, participant.getIdparticipant());
		paginator = new RepeatPaginator(echanges);
	}
	
	public String test(){
		return "success-color";
	}


	public IBusinessAjouterObjet getProxyAjouterObjet() {
		return proxyAjouterObjet;
	}


	public void setProxyAjouterObjet(IBusinessAjouterObjet proxyAjouterObjet) {
		this.proxyAjouterObjet = proxyAjouterObjet;
	}


	public IBusinessGestionEchange getProxyAfficherEchange() {
		return proxyAfficherEchange;
	}


	public void setProxyAfficherEchange(IBusinessGestionEchange proxyAfficherEchange) {
		this.proxyAfficherEchange = proxyAfficherEchange;
	}


	public List<Echange> getEchanges() {
		return echanges;
	}


	public void setEchanges(List<Echange> echanges) {
		this.echanges = echanges;
	}


	public Participant getParticipant() {
		return participant;
	}


	public void setParticipant(Participant participant) {
		this.participant = participant;
	}


	public RepeatPaginator getPaginator() {
		return paginator;
	}


	public void setPaginator(RepeatPaginator paginator) {
		this.paginator = paginator;
	}


	public List<String> getLesTypesDeRdv() {
		return lesTypesDeRdv;
	}


	public void setLesTypesDeRdv(List<String> lesTypesDeRdv) {
		this.lesTypesDeRdv = lesTypesDeRdv;
	}


	public String getSelectedTypeRdv() {
		return selectedTypeRdv;
	}


	public void setSelectedTypeRdv(String selectedTypeRdv) {
		this.selectedTypeRdv = selectedTypeRdv;
	}


	public List<String> getEtatsDesTransferts() {
		return etatsDesTransferts;
	}


	public void setEtatsDesTransferts(List<String> etatsDesTransferts) {
		this.etatsDesTransferts = etatsDesTransferts;
	}


	public String getSelectedEtatDesTransferts() {
		return selectedEtatDesTransferts;
	}


	public void setSelectedEtatDesTransferts(String selectedEtatDesTransferts) {
		this.selectedEtatDesTransferts = selectedEtatDesTransferts;
	}


	public List<String> getTypesDeTransferts() {
		return typesDeTransferts;
	}


	public void setTypesDeTransferts(List<String> typesDeTransferts) {
		this.typesDeTransferts = typesDeTransferts;
	}


	public String getSelectedTypesDesTransferts() {
		return selectedTypesDesTransferts;
	}


	public void setSelectedTypesDesTransferts(String selectedTypesDesTransferts) {
		this.selectedTypesDesTransferts = selectedTypesDesTransferts;
	}


	public IDaoObjet getProxyDaoAfficherImage() {
		return proxyDaoAfficherImage;
	}


	public void setProxyDaoAfficherImage(IDaoObjet proxyDaoAfficherImage) {
		this.proxyDaoAfficherImage = proxyDaoAfficherImage;
	}

	public ConnexionBean getMbCnx() {
		return mbCnx;
	}

	public void setMbCnx(ConnexionBean mbCnx) {
		this.mbCnx = mbCnx;
	}

	public IDaoEchange getProxyTest() {
		return proxyTest;
	}

	public void setProxyTest(IDaoEchange proxyTest) {
		this.proxyTest = proxyTest;
	}





	
	
	
	
	
}
