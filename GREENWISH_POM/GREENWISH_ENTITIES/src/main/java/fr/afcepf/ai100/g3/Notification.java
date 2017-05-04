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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Notification generated by hbm2java
 */
@Entity
@Table(name="notification"
    ,catalog="greenwish"
)
public class Notification  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idnotification;
     private String notification;
     private List<Participant> participants = new ArrayList<>();
     private boolean lu;

    public Notification() {
    }

	
    public Notification(String notification) {
        this.notification = notification;
    }
    public Notification(String notification, List<Participant> participants) {
       this.notification = notification;
       this.participants = participants;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDNOTIFICATION", unique=true, nullable=false)
    public Integer getIdnotification() {
        return this.idnotification;
    }
    
    public void setIdnotification(Integer idnotification) {
        this.idnotification = idnotification;
    }

    
    @Column(name="NOTIFICATION", nullable=false, length=300)
    public String getNotification() {
        return this.notification;
    }
    
    public void setNotification(String notification) {
        this.notification = notification;
    }

@ManyToMany(fetch=FetchType.LAZY, mappedBy="notifications")
    public List<Participant> getParticipants() {
        return this.participants;
    }
    
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    @Column(name="LU", nullable=false, columnDefinition = "TINYINT(1)")
	public boolean isLu() {
		return lu;
	}

	
	public void setLu(boolean lu) {
		this.lu = lu;
	}




}


