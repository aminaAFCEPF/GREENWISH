package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the messagerie database table.
 * 
 */
@Entity
@NamedQuery(name="Messagerie.findAll", query="SELECT m FROM Messagerie m")
public class Messagerie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmessagerie;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="messagerie")
	private List<Message> messages;

	//bi-directional many-to-one association to Participant
	@ManyToOne
	@JoinColumn(name="IDPARTICIPANT")
	private Participant participant;

	//bi-directional many-to-one association to Participant
	@OneToMany(mappedBy="messagerie")
	private List<Participant> participants;

	public Messagerie() {
	}

	public int getIdmessagerie() {
		return this.idmessagerie;
	}

	public void setIdmessagerie(int idmessagerie) {
		this.idmessagerie = idmessagerie;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setMessagerie(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setMessagerie(null);

		return message;
	}

	public Participant getParticipant() {
		return this.participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Participant addParticipant(Participant participant) {
		getParticipants().add(participant);
		participant.setMessagerie(this);

		return participant;
	}

	public Participant removeParticipant(Participant participant) {
		getParticipants().remove(participant);
		participant.setMessagerie(null);

		return participant;
	}

}