package fr.afcepf.ai100.g3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai100.g3.entities.RepeatPaginator;

@ManagedBean(name = "mbAfficherTransfert")
@SessionScoped
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
	@EJB
	private IDaoRdv proxyDaoRdv;
	private List<Echange> echanges;
	private Participant participant = new Participant();
	private RepeatPaginator paginator;
	private List<String> lesTypesDeRdv = new ArrayList<>();
	private String selectedTypeRdv;
	private List<String> etatsDesTransferts = new ArrayList<>();
	private String selectedEtatDesTransferts;
	private List<String> typesDeTransferts = new ArrayList<>();
	private String selectedTypesDesTransferts;
	private Rdv rdv = new Rdv();
	

	

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
		System.out.println(participant.getIdparticipant());
		
	}
	
	public void chargerLesTransferts(){
//		selectedEtatDesTransferts = etatsDesTransferts.get(0);
//		selectedTypesDesTransferts = typesDeTransferts.get(0);
		participant = mbCnx.getParticipant();
		echanges.clear();
		echanges = proxyAfficherEchange.afficherLesEchangesTries(selectedEtatDesTransferts, selectedTypesDesTransferts, participant.getIdparticipant());
		paginator = new RepeatPaginator(echanges);
	}
	
	public String isRdvValide(Echange echange){
		String couleur ="";
		rdv=proxyDaoRdv.getRdvByIdEchange(echange.getIdechange());
		if(rdv.getDaterdv()!=null){
			couleur="success-color";
		}else{
			couleur = "no-color";
		}
		return couleur;
	}
	
	public String isRdvTermine(Echange echange){
		String couleur ="";
		
		if(rdv.getDaterdv().before(new Date())){
			couleur="success-color";
		}else{
			couleur = "no-color";
		}
		return couleur;
	}
	
	public String isTransfertTermine(Echange echange){
		String couleur ="";
		if(echange.getDateFin()!=null){
			couleur="success-color";
		}else{
			couleur = "no-color";
		}
		return couleur;
	}
	
	public String remplirProgressBar(Echange echange){
		String remplissage = "10%";
		if( isRdvValide(echange).equals("success-color")){
			remplissage = "35%";
		}
		if( isRdvTermine(echange).equals("success-color")){
			remplissage = "60%";
		}
		if( isTransfertTermine(echange).equals("success-color")){
			remplissage = "100%";
		}
		return remplissage;
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

	public IDaoRdv getProxyDaoRdv() {
		return proxyDaoRdv;
	}

	public void setProxyDaoRdv(IDaoRdv proxyDaoRdv) {
		this.proxyDaoRdv = proxyDaoRdv;
	}

	public Rdv getRdv() {
		return rdv;
	}

	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}





	
	
	
	
	
}
