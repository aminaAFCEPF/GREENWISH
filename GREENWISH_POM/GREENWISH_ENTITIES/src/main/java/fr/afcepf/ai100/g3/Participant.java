package fr.afcepf.ai100.g3;
// Generated 28 avr. 2017 11:29:33 by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Participant generated by hbm2java
 */
@Entity
@Table(name = "participant", catalog = "greenwish")
public class Participant implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Integer idparticipant;
	private Disponibilite disponibilite;
	private Messagerie messagerie;
	private Reglage reglage;
	private Ville ville;
	private String nom;
	private String prenom;
	private Date datenaissance;
	private String adresse;
	private Float longitude;
	private Float latitude;
	private String mail;
	private String telephone;
	private int solde;
	private Date dateradiation;
	private String commentaireradiation;
	private String password;
	private String image;
	private boolean statutadmin;
	private Date datederniercontact;
	private List<Avis> avis = new ArrayList<>();
	private List<Souhait> souhaits = new ArrayList<>();
	private List<Notification> notifications = new ArrayList<>();
	private List<Favoris> favoris = new ArrayList<>();
	private List<Reglage> reglages = new ArrayList<>();
	private List<Activation> activations = new ArrayList<>();
	private List<Actualite> actualites = new ArrayList<>();
	private List<ListeProposition> listePropositions = new ArrayList<>();
	private List<Statistique> statistiques = new ArrayList<>();
	private List<Inscription> inscriptions = new ArrayList<>();
	private List<Disponibilite> disponibilites = new ArrayList<>();
	private List<Rdv> rdvs = new ArrayList<>();

	public Participant() {
	}

	public Participant(Ville ville, String nom, String prenom, Date datenaissance, String adresse, String mail,
			int solde, String password, boolean statutadmin) {
		this.ville = ville;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.mail = mail;
		this.solde = solde;
		this.password = password;
		this.statutadmin = statutadmin;
	}
	
	

	public Participant(Disponibilite disponibilite, Messagerie messagerie, Reglage reglage, Ville ville, String nom,
			String prenom, Date datenaissance, String adresse, String mail, String telephone, int solde,
			Date dateradiation, String commentaireradiation, String password, String image, boolean statutadmin,
			Date datederniercontact, List<Avis> avis, List<Souhait> souhaits, List<Notification> notifications,
			List<Favoris> favoris, List<Reglage> reglages, List<Activation> activations, List<Actualite> actualites,
			List<ListeProposition> listePropositions, List<Statistique> statistiques, List<Inscription> inscriptions,
			List<Disponibilite> disponibilites) {
		this.disponibilite = disponibilite;
		this.messagerie = messagerie;
		this.reglage = reglage;
		this.ville = ville;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.mail = mail;
		this.telephone = telephone;
		this.solde = solde;
		this.dateradiation = dateradiation;
		this.commentaireradiation = commentaireradiation;
		this.password = password;
		this.image = image;
		this.statutadmin = statutadmin;
		this.datederniercontact = datederniercontact;
		this.avis = avis;
		this.souhaits = souhaits;
		this.notifications = notifications;
		this.favoris = favoris;
		this.reglages = reglages;
		this.activations = activations;
		this.actualites = actualites;
		this.listePropositions = listePropositions;
		this.statistiques = statistiques;
		this.inscriptions = inscriptions;
		this.disponibilites = disponibilites;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "IDPARTICIPANT", unique = true, nullable = false)
	public Integer getIdparticipant() {
		return this.idparticipant;
	}

	public void setIdparticipant(Integer idparticipant) {
		this.idparticipant = idparticipant;
	}

	@ManyToOne
	@JoinColumn(name = "IDDISPO")
	public Disponibilite getDisponibilite() {
		return this.disponibilite;
	}

	public void setDisponibilite(Disponibilite disponibilite) {
		this.disponibilite = disponibilite;
	}

	@ManyToOne
	@JoinColumn(name = "IDMESSAGERIE")
	public Messagerie getMessagerie() {
		return this.messagerie;
	}

	public void setMessagerie(Messagerie messagerie) {
		this.messagerie = messagerie;
	}

	@ManyToOne
	@JoinColumn(name = "IDREGLAGE")
	public Reglage getReglage() {
		return this.reglage;
	}

	public void setReglage(Reglage reglage) {
		this.reglage = reglage;
	}

	@ManyToOne
	@JoinColumn(name = "IDVILLE", nullable = false)
	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	@Column(name = "NOM", nullable = false, length = 100)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "PRENOM", nullable = false, length = 50)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATENAISSANCE", nullable = false, length = 10)
	public Date getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	@Column(name = "ADRESSE", nullable = false, length = 200)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "MAIL", nullable = false, length = 50)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "TELEPHONE", length = 10)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "SOLDE", nullable = false)
	public int getSolde() {
		return this.solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATERADIATION", length = 10)
	public Date getDateradiation() {
		return this.dateradiation;
	}

	public void setDateradiation(Date dateradiation) {
		this.dateradiation = dateradiation;
	}

	@Column(name = "COMMENTAIRERADIATION", length = 300)
	public String getCommentaireradiation() {
		return this.commentaireradiation;
	}

	public void setCommentaireradiation(String commentaireradiation) {
		this.commentaireradiation = commentaireradiation;
	}

	@Column(name = "PASSWORD", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "IMAGE", length = 150)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "STATUTADMIN", nullable = false, columnDefinition = "TINYINT(1)")
	public boolean isStatutadmin() {
		return this.statutadmin;
	}

	public void setStatutadmin(boolean statutadmin) {
		this.statutadmin = statutadmin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATEDERNIERCONTACT", length = 19)
	public Date getDatederniercontact() {
		return this.datederniercontact;
	}

	public void setDatederniercontact(Date datederniercontact) {
		this.datederniercontact = datederniercontact;
	}

	
	

	@OneToMany(mappedBy = "participant")
	public List<Souhait> getSouhaits() {
		return this.souhaits;
	}

	public void setSouhaits(List<Souhait> souhaits) {
		this.souhaits = souhaits;
	}

	@ManyToMany
	@JoinTable(name = "notifie", catalog = "greenwish", joinColumns = {
			@JoinColumn(name = "IDPARTICIPANT", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDNOTIFICATION", nullable = false, updatable = false) })
	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	
	

	@OneToMany(mappedBy = "participant")
	public List<Reglage> getReglages() {
		return this.reglages;
	}

	public void setReglages(List<Reglage> reglages) {
		this.reglages = reglages;
	}

	@OneToMany(mappedBy = "participant")
	public List<Activation> getActivations() {
		return this.activations;
	}

	public void setActivations(List<Activation> activations) {
		this.activations = activations;
	}

	@ManyToMany
	@JoinTable(name = "publie", catalog = "greenwish", joinColumns = {
			@JoinColumn(name = "IDPARTICIPANT", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDACTU", nullable = false, updatable = false) })
	public List<Actualite> getActualites() {
		return this.actualites;
	}

	public void setActualites(List<Actualite> actualites) {
		this.actualites = actualites;
	}

	@OneToMany(mappedBy = "participant")
	public List<ListeProposition> getListePropositions() {
		return this.listePropositions;
	}

	public void setListePropositions(List<ListeProposition> listePropositions) {
		this.listePropositions = listePropositions;
	}

	@ManyToMany(mappedBy = "participants")
	public List<Statistique> getStatistiques() {
		return this.statistiques;
	}

	public void setStatistiques(List<Statistique> statistiques) {
		this.statistiques = statistiques;
	}

	@OneToMany(mappedBy = "participant")
	public List<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@OneToMany(mappedBy = "participant")
	public List<Disponibilite> getDisponibilites() {
		return this.disponibilites;
	}

	public void setDisponibilites(List<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}

	@OneToMany(mappedBy = "participant")
	public List<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	@Column(name = "LONGITUDE", unique = true, nullable = true)
	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@Column(name = "LATITUDE", unique = true, nullable = true)
	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	
	@OneToMany(mappedBy = "participant")
	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	@ManyToMany
	@JoinTable(name = "appartient", catalog = "greenwish", joinColumns = {
			@JoinColumn(name = "IDPARTICIPANT", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "IDFAVORIS", nullable = false, updatable = false) })
	public List<Favoris> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<Favoris> favoris) {
		this.favoris = favoris;
	}
	
	

}
