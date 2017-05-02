package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the participant database table.
 * 
 */
@Entity
@NamedQuery(name="Participant.findAll", query="SELECT p FROM Participant p")
public class Participant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idparticipant;

	private String adresse;

	private String commentaireradiation;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datederniercontact;

	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	@Temporal(TemporalType.DATE)
	private Date dateradiation;

	private String image;

	private String mail;

	private String nom;

	private String password;

	private String prenom;

	private int solde;

	private byte statutadmin;

	private String telephone;

	//bi-directional many-to-one association to Activation
	@OneToMany(mappedBy="participant")
	private List<Activation> activations;

	//bi-directional many-to-many association to Favori
	@ManyToMany(mappedBy="participants")
	private List<Favori> favoris;

	//bi-directional many-to-one association to Avi
	@OneToMany(mappedBy="participant")
	private List<Avi> avis;

	//bi-directional many-to-many association to Statistique
	@ManyToMany
	@JoinTable(
		name="defini"
		, joinColumns={
			@JoinColumn(name="IDPARTICIPANT")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDSTAT")
			}
		)
	private List<Statistique> statistiques;

	//bi-directional many-to-one association to Disponibilite
	@OneToMany(mappedBy="participant")
	private List<Disponibilite> disponibilites;

	//bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy="participant")
	private List<Inscription> inscriptions;

	//bi-directional many-to-one association to ListeProposition
	@OneToMany(mappedBy="participant")
	private List<ListeProposition> listePropositions;

	//bi-directional many-to-one association to Messagerie
	@OneToMany(mappedBy="participant")
	private List<Messagerie> messageries;

	//bi-directional many-to-many association to Notification
	@ManyToMany(mappedBy="participants")
	private List<Notification> notifications;

	//bi-directional many-to-one association to Disponibilite
	@ManyToOne
	@JoinColumn(name="IDDISPO")
	private Disponibilite disponibilite;

	//bi-directional many-to-one association to Ville
	@ManyToOne
	@JoinColumn(name="IDVILLE")
	private Ville ville;

	//bi-directional many-to-one association to Messagerie
	@ManyToOne
	@JoinColumn(name="IDMESSAGERIE")
	private Messagerie messagerie;

	//bi-directional many-to-one association to Reglage
	@ManyToOne
	@JoinColumn(name="IDREGLAGE")
	private Reglage reglage;

	//bi-directional many-to-many association to Actualite
	@ManyToMany(mappedBy="participants")
	private List<Actualite> actualites;

	//bi-directional many-to-one association to Reglage
	@OneToMany(mappedBy="participant")
	private List<Reglage> reglages;

	//bi-directional many-to-one association to Souhait
	@OneToMany(mappedBy="participant")
	private List<Souhait> souhaits;

	public Participant() {
	}
	
	

	public Participant(String adresse, Date datenaissance, String mail, String nom, String password, String prenom,
			String telephone, List<Inscription> inscriptions, Ville ville) {
		super();
		this.adresse = adresse;
		this.datenaissance = datenaissance;
		this.mail = mail;
		this.nom = nom;
		this.password = password;
		this.prenom = prenom;
		this.telephone = telephone;
		this.inscriptions = inscriptions;
		this.ville = ville;
	}



	public int getIdparticipant() {
		return this.idparticipant;
	}

	public void setIdparticipant(int idparticipant) {
		this.idparticipant = idparticipant;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCommentaireradiation() {
		return this.commentaireradiation;
	}

	public void setCommentaireradiation(String commentaireradiation) {
		this.commentaireradiation = commentaireradiation;
	}

	public Date getDatederniercontact() {
		return this.datederniercontact;
	}

	public void setDatederniercontact(Date datederniercontact) {
		this.datederniercontact = datederniercontact;
	}

	public Date getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public Date getDateradiation() {
		return this.dateradiation;
	}

	public void setDateradiation(Date dateradiation) {
		this.dateradiation = dateradiation;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getSolde() {
		return this.solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}

	public byte getStatutadmin() {
		return this.statutadmin;
	}

	public void setStatutadmin(byte statutadmin) {
		this.statutadmin = statutadmin;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Activation> getActivations() {
		return this.activations;
	}

	public void setActivations(List<Activation> activations) {
		this.activations = activations;
	}

	public Activation addActivation(Activation activation) {
		getActivations().add(activation);
		activation.setParticipant(this);

		return activation;
	}

	public Activation removeActivation(Activation activation) {
		getActivations().remove(activation);
		activation.setParticipant(null);

		return activation;
	}

	public List<Favori> getFavoris() {
		return this.favoris;
	}

	public void setFavoris(List<Favori> favoris) {
		this.favoris = favoris;
	}

	public List<Avi> getAvis() {
		return this.avis;
	}

	public void setAvis(List<Avi> avis) {
		this.avis = avis;
	}

	public Avi addAvi(Avi avi) {
		getAvis().add(avi);
		avi.setParticipant(this);

		return avi;
	}

	public Avi removeAvi(Avi avi) {
		getAvis().remove(avi);
		avi.setParticipant(null);

		return avi;
	}

	public List<Statistique> getStatistiques() {
		return this.statistiques;
	}

	public void setStatistiques(List<Statistique> statistiques) {
		this.statistiques = statistiques;
	}

	public List<Disponibilite> getDisponibilites() {
		return this.disponibilites;
	}

	public void setDisponibilites(List<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}

	public Disponibilite addDisponibilite(Disponibilite disponibilite) {
		getDisponibilites().add(disponibilite);
		disponibilite.setParticipant(this);

		return disponibilite;
	}

	public Disponibilite removeDisponibilite(Disponibilite disponibilite) {
		getDisponibilites().remove(disponibilite);
		disponibilite.setParticipant(null);

		return disponibilite;
	}

	public List<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Inscription addInscription(Inscription inscription) {
		getInscriptions().add(inscription);
		inscription.setParticipant(this);

		return inscription;
	}

	public Inscription removeInscription(Inscription inscription) {
		getInscriptions().remove(inscription);
		inscription.setParticipant(null);

		return inscription;
	}

	public List<ListeProposition> getListePropositions() {
		return this.listePropositions;
	}

	public void setListePropositions(List<ListeProposition> listePropositions) {
		this.listePropositions = listePropositions;
	}

	public ListeProposition addListeProposition(ListeProposition listeProposition) {
		getListePropositions().add(listeProposition);
		listeProposition.setParticipant(this);

		return listeProposition;
	}

	public ListeProposition removeListeProposition(ListeProposition listeProposition) {
		getListePropositions().remove(listeProposition);
		listeProposition.setParticipant(null);

		return listeProposition;
	}

	public List<Messagerie> getMessageries() {
		return this.messageries;
	}

	public void setMessageries(List<Messagerie> messageries) {
		this.messageries = messageries;
	}

	public Messagerie addMessagery(Messagerie messagery) {
		getMessageries().add(messagery);
		messagery.setParticipant(this);

		return messagery;
	}

	public Messagerie removeMessagery(Messagerie messagery) {
		getMessageries().remove(messagery);
		messagery.setParticipant(null);

		return messagery;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Disponibilite getDisponibilite() {
		return this.disponibilite;
	}

	public void setDisponibilite(Disponibilite disponibilite) {
		this.disponibilite = disponibilite;
	}

	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Messagerie getMessagerie() {
		return this.messagerie;
	}

	public void setMessagerie(Messagerie messagerie) {
		this.messagerie = messagerie;
	}

	public Reglage getReglage() {
		return this.reglage;
	}

	public void setReglage(Reglage reglage) {
		this.reglage = reglage;
	}

	public List<Actualite> getActualites() {
		return this.actualites;
	}

	public void setActualites(List<Actualite> actualites) {
		this.actualites = actualites;
	}

	public List<Reglage> getReglages() {
		return this.reglages;
	}

	public void setReglages(List<Reglage> reglages) {
		this.reglages = reglages;
	}

	public Reglage addReglage(Reglage reglage) {
		getReglages().add(reglage);
		reglage.setParticipant(this);

		return reglage;
	}

	public Reglage removeReglage(Reglage reglage) {
		getReglages().remove(reglage);
		reglage.setParticipant(null);

		return reglage;
	}

	public List<Souhait> getSouhaits() {
		return this.souhaits;
	}

	public void setSouhaits(List<Souhait> souhaits) {
		this.souhaits = souhaits;
	}

	public Souhait addSouhait(Souhait souhait) {
		getSouhaits().add(souhait);
		souhait.setParticipant(this);

		return souhait;
	}

	public Souhait removeSouhait(Souhait souhait) {
		getSouhaits().remove(souhait);
		souhait.setParticipant(null);

		return souhait;
	}

}