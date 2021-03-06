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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Objet generated by hbm2java
 */
@Entity
@Table(name="objet"
    ,catalog="greenwish"
)
public class Objet  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idobjet;
     private Domaine domaine;
     private Categorie categorie;
     private Souscategorie souscategorie;
     private ListeProposition listeProposition;
     private TrancheAge trancheAge;
     private Valeur valeur;
     private String intitule;
     private String description;
     private Date dategarantie;
     private Boolean actif;
     private Date dateajout;
     private Date datesuppression;
     private List<Favoris> favoris = new ArrayList<>();
     private List<Image> images = new ArrayList<>();
     private List<Echange> echanges = new ArrayList<>();

    public Objet() {
    }

	
    public Objet(Domaine domaine, ListeProposition listeProposition, Valeur valeur, String intitule, Date dateajout) {
        this.domaine = domaine;
        this.listeProposition = listeProposition;
        this.valeur = valeur;
        this.intitule = intitule;
        this.dateajout = dateajout;
    }
    public Objet(Domaine domaine, ListeProposition listeProposition, TrancheAge trancheAge, 
    		Valeur valeur, String intitule, String description, Date dategarantie, Boolean actif, 
    		Date dateajout, Date datesuppression, List<Favoris> favoris, List<Image> images, List<Echange> echanges) {
       this.domaine = domaine;
       this.listeProposition = listeProposition;
       this.trancheAge = trancheAge;
       this.valeur = valeur;
       this.intitule = intitule;
       this.description = description;
       this.dategarantie = dategarantie;
       this.actif = actif;
       this.dateajout = dateajout;
       this.datesuppression = datesuppression;
       this.favoris = favoris;
       this.images = images;
       this.echanges = echanges;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDOBJET", unique=true, nullable=false)
    public Integer getIdobjet() {
        return this.idobjet;
    }
    
    public void setIdobjet(Integer idobjet) {
        this.idobjet = idobjet;
    }

@ManyToOne
    @JoinColumn(name="IDDOMAINE", nullable=false)
    public Domaine getDomaine() {
        return this.domaine;
    }
    
    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
    
    @ManyToOne
    @JoinColumn(name="IDCATEGORIE", nullable=false)
    public Categorie getCategorie() {
        return this.categorie;
    }
    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }  
    
    @ManyToOne
    @JoinColumn(name="IDSOUSCATEGORIE", nullable=false)
	public Souscategorie getSouscategorie() {
		return souscategorie;
	}


	public void setSouscategorie(Souscategorie souscategorie) {
		this.souscategorie = souscategorie;
	}
     

@ManyToOne
    @JoinColumn(name="IDLISTEOBJET", nullable=false)
    public ListeProposition getListeProposition() {
        return this.listeProposition;
    }
    
    public void setListeProposition(ListeProposition listeProposition) {
        this.listeProposition = listeProposition;
    }

@ManyToOne
    @JoinColumn(name="IDAGE")
    public TrancheAge getTrancheAge() {
        return this.trancheAge;
    }
    
    public void setTrancheAge(TrancheAge trancheAge) {
        this.trancheAge = trancheAge;
    }

@ManyToOne
    @JoinColumn(name="IDVALEUR", nullable=false)
    public Valeur getValeur() {
        return this.valeur;
    }
    
    public void setValeur(Valeur valeur) {
        this.valeur = valeur;
    }

    
    @Column(name="INTITULE", nullable=false, length=150)
    public String getIntitule() {
        return this.intitule;
    }
    
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    
    @Column(name="DESCRIPTION", length=300)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DATEGARANTIE", length=10)
    public Date getDategarantie() {
        return this.dategarantie;
    }
    
    public void setDategarantie(Date dategarantie) {
        this.dategarantie = dategarantie;
    }

    
    @Column(name="ACTIF", columnDefinition = "TINYINT(1)")
    public Boolean getActif() {
        return this.actif;
    }
    
    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATEAJOUT", nullable=false, length=19)
    public Date getDateajout() {
        return this.dateajout;
    }
    
    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATESUPPRESSION", length=19)
    public Date getDatesuppression() {
        return this.datesuppression;
    }
    
    public void setDatesuppression(Date datesuppression) {
        this.datesuppression = datesuppression;
    }


    @OneToMany(mappedBy="objet")
    public List<Image> getImages() {
        return this.images;
    }
    
    public void setImages(List<Image> images) {
        this.images = images;
    }

@OneToMany(mappedBy="objet")
    public List<Echange> getEchanges() {
        return this.echanges;
    }
    
    public void setEchanges(List<Echange> echanges) {
        this.echanges = echanges;
    }

    @OneToMany(mappedBy="objet")
	public List<Favoris> getFavoris() {
		return favoris;
	}


	public void setFavoris(List<Favoris> favoris) {
		this.favoris = favoris;
	}






}


