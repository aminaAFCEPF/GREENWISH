package fr.afcepf.ai100.g3;
// Generated 28 avr. 2017 11:29:33 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Image generated by hbm2java
 */
@Entity
@Table(name="image"
    ,catalog="greenwish"
)
public class Image  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idimage;
     private Objet objet;
     private String image;

    public Image() {
    }

    public Image(Objet objet, String image) {
       this.objet = objet;
       this.image = image;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDIMAGE", unique=true, nullable=false)
    public Integer getIdimage() {
        return this.idimage;
    }
    
    public void setIdimage(Integer idimage) {
        this.idimage = idimage;
    }

@ManyToOne()
    @JoinColumn(name="IDOBJET", nullable=false)
    public Objet getObjet() {
        return this.objet;
    }
    
    public void setObjet(Objet objet) {
        this.objet = objet;
    }

    
    @Column(name="IMAGE", nullable=false, length=150)
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }




}


