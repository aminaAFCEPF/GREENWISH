package fr.afcepf.ai100.g3_2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the notification database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idnotification;

	private String notification;

	//bi-directional many-to-many association to Participant
	@ManyToMany
	@JoinTable(
		name="notifie"
		, joinColumns={
			@JoinColumn(name="IDNOTIFICATION")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDPARTICIPANT")
			}
		)
	private List<Participant> participants;

	public Notification() {
	}

	public int getIdnotification() {
		return this.idnotification;
	}

	public void setIdnotification(int idnotification) {
		this.idnotification = idnotification;
	}

	public String getNotification() {
		return this.notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

}