package fr.afcepf.ai100.g3;
// Generated 28 avr. 2017 11:29:33 by Hibernate Tools 4.3.1


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Valeur generated by hbm2java
 */
@Entity
@Table(name="valeur"
    ,catalog="greenwish"
)
public class Valeur  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idvaleur;
     private int valeur;
     private List<Objet> objets = new ArrayList<>();

    public Valeur() {
    }

	
    public Valeur(int valeur) {
        this.valeur = valeur;
    }
    public Valeur(int valeur, List<Objet> objets) {
       this.valeur = valeur;
       this.objets = objets;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDVALEUR", unique=true, nullable=false)
    public Integer getIdvaleur() {
        return this.idvaleur;
    }
    
    public void setIdvaleur(Integer idvaleur) {
        this.idvaleur = idvaleur;
    }

    
    @Column(name="VALEUR", nullable=false)
    public int getValeur() {
        return this.valeur;
    }
    
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="valeur")
    public List<Objet> getObjets() {
        return this.objets;
    }
    
    public void setObjets(List<Objet> objets) {
        this.objets = objets;
    }




}


