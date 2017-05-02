package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmessage;

	private byte lu;

	private String message;

	//bi-directional many-to-one association to Messagerie
	@ManyToOne
	@JoinColumn(name="IDMESSAGERIE")
	private Messagerie messagerie;

	public Message() {
	}

	public int getIdmessage() {
		return this.idmessage;
	}

	public void setIdmessage(int idmessage) {
		this.idmessage = idmessage;
	}

	public byte getLu() {
		return this.lu;
	}

	public void setLu(byte lu) {
		this.lu = lu;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Messagerie getMessagerie() {
		return this.messagerie;
	}

	public void setMessagerie(Messagerie messagerie) {
		this.messagerie = messagerie;
	}

}