package fr.afcepf.ai100.g3;

import java.util.List;

public interface IDaoMessage {
	
	Message ajouterMessage(Message message, int idTransfert);
	List<Message>getAllMessage();
	List<Message> getMessageByIdTransfert(int idTransfert, int idParticipant);	
}
