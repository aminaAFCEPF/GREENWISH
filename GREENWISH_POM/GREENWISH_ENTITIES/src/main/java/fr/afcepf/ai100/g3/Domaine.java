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
 * Domaine generated by hbm2java
 */
@Entity
@Table(name="domaine"
    ,catalog="greenwish"
)
public class Domaine  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer iddomaine;
     private String domaine;
     private List<Objet> objets = new ArrayList<>();
     private List<Souhait> souhaits = new ArrayList<>();
     private List<Categorie> categories = new ArrayList<>();

    public Domaine() {
    }

	
    public Domaine(String domaine) {
        this.domaine = domaine;
    }
    public Domaine(String domaine, List<Objet> objets, List<Souhait> souhaits, List<Categorie> categories) {
       this.domaine = domaine;
       this.objets = objets;
       this.souhaits = souhaits;
       this.categories = categories;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDDOMAINE", unique=true, nullable=false)
    public Integer getIddomaine() {
        return this.iddomaine;
    }
    
    public void setIddomaine(Integer iddomaine) {
        this.iddomaine = iddomaine;
    }

    
    @Column(name="DOMAINE", nullable=false, length=150)
    public String getDomaine() {
        return this.domaine;
    }
    
    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

@OneToMany( mappedBy="domaine")
    public List<Objet> getObjets() {
        return this.objets;
    }
    
    public void setObjets(List<Objet> objets) {
        this.objets = objets;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="domaine")
    public List<Souhait> getSouhaits() {
        return this.souhaits;
    }
    
    public void setSouhaits(List<Souhait> souhaits) {
        this.souhaits = souhaits;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="domaine")
    public List<Categorie> getCategories() {
        return this.categories;
    }
    
    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }




}


