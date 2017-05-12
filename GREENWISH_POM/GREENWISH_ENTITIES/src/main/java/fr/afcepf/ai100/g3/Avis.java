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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Avis generated by hbm2java
 */
@Entity
@Table(name="avis"
    ,catalog="greenwish"
)
public class Avis  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idavis;
     private Participant participant;
     private String avis;
     private int note;
     private List<Echange> echanges = new ArrayList<>();

    public Avis() {
    }

	
    public Avis(String avis, int note) {
        this.avis = avis;
        this.note = note;
    }
    public Avis(Participant participant, String avis, int note, List<Echange> echanges) {
       this.participant = participant;
       this.avis = avis;
       this.note = note;
       this.echanges = echanges;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDAVIS", unique=true, nullable=false)
    public Integer getIdavis() {
        return this.idavis;
    }
    
    public void setIdavis(Integer idavis) {
        this.idavis = idavis;
    }

    @ManyToOne
    @JoinColumn(name="IDPARTICIPANT")
    public Participant getParticipant() {
        return this.participant;
    }
    
    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    
    @Column(name="AVIS", nullable=false, length=500)
    public String getAvis() {
        return this.avis;
    }
    
    public void setAvis(String avis) {
        this.avis = avis;
    }

    
    @Column(name="NOTE", nullable=false)
    public int getNote() {
        return this.note;
    }
    
    public void setNote(int note) {
        this.note = note;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="avis")
    public List<Echange> getEchanges() {
        return this.echanges;
    }
    
    public void setEchanges(List<Echange> echanges) {
        this.echanges = echanges;
    }




}


