package fr.afcepf.ai100.g3;
// Generated 28 avr. 2017 11:29:33 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.awt.SystemColor;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Message generated by hbm2java
 */
@Entity
@Table(name="message"
    ,catalog="greenwish"
)
public class Message  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idmessage;
     private Messagerie messagerie;
     private String message;
     private boolean lu;
     private Echange echange;
     private Date datePublication;
     
     
     

    public Message(Messagerie messagerie, String message, Echange echange, Date datePublication) {
		super();
		this.messagerie = messagerie;
		this.message = message;
		this.echange = echange;
		this.datePublication = datePublication;
	}

	public Message() {
    }

    public Message(Messagerie messagerie, String message, boolean lu) {
       this.messagerie = messagerie;
       this.message = message;
       this.lu = lu;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDMESSAGE", unique=true, nullable=false)
    public Integer getIdmessage() {
        return this.idmessage;
    }
    
    public void setIdmessage(Integer idmessage) {
        this.idmessage = idmessage;
    }

@ManyToOne
    @JoinColumn(name="IDMESSAGERIE", nullable=false)
    public Messagerie getMessagerie() {
        return this.messagerie;
    }
    
    public void setMessagerie(Messagerie messagerie) {
        this.messagerie = messagerie;
    }

    
    @Column(name="MESSAGE", nullable=false, length=250)
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    
    @Column(name="LU", nullable=false, columnDefinition = "TINYINT(1)")
    public boolean isLu() {
        return this.lu;
    }
    
    public void setLu(boolean lu) {
        this.lu = lu;
    }
    @ManyToOne
    @JoinColumn(name="IDECHANGE", nullable=false)
	public Echange getEchange() {
		return echange;
	}

	public void setEchange(Echange echange) {
		this.echange = echange;
	}
	@Column(name="DATE_PUBLICATION", nullable=false)
	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}




}


