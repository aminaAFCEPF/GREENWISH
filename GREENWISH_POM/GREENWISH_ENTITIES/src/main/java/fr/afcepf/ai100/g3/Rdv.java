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
 * Rdv generated by hbm2java
 */
@Entity
@Table(name="rdv"
    ,catalog="greenwish"
)
public class Rdv  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idrdv;
     private Echange echange;
     private Ville ville;
     private Date daterdv;
     private String adresse;
     private List<Echange> echanges = new ArrayList<>();

    public Rdv() {
    }

	
    public Rdv(Echange echange, Ville ville, Date daterdv, String adresse) {
        this.echange = echange;
        this.ville = ville;
        this.daterdv = daterdv;
        this.adresse = adresse;
    }
    public Rdv(Echange echange, Ville ville, Date daterdv, String adresse, List<Echange> echanges) {
       this.echange = echange;
       this.ville = ville;
       this.daterdv = daterdv;
       this.adresse = adresse;
       this.echanges = echanges;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDRDV", unique=true, nullable=false)
    public Integer getIdrdv() {
        return this.idrdv;
    }
    
    public void setIdrdv(Integer idrdv) {
        this.idrdv = idrdv;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDECHANGE", nullable=false)
    public Echange getEchange() {
        return this.echange;
    }
    
    public void setEchange(Echange echange) {
        this.echange = echange;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IDVILLE", nullable=false)
    public Ville getVille() {
        return this.ville;
    }
    
    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DATERDV", nullable=false, length=19)
    public Date getDaterdv() {
        return this.daterdv;
    }
    
    public void setDaterdv(Date daterdv) {
        this.daterdv = daterdv;
    }

    
    @Column(name="ADRESSE", nullable=false, length=200)
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rdv")
    public List<Echange> getEchanges() {
        return this.echanges;
    }
    
    public void setEchanges(List<Echange> echanges) {
        this.echanges = echanges;
    }




}


