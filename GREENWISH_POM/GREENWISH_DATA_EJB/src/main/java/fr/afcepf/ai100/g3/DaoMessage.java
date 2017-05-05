package fr.afcepf.ai100.g3;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Remote(IDaoMessage.class)
@Singleton
public class DaoMessage implements IDaoMessage{

	@PersistenceContext(unitName="GREENWISH_DATA_EJB")
	@SuppressWarnings("unchecked")
	private EntityManager em;
	@Override
	public Message ajouterMessage(Message message, int idTransfert) {
		message.setIdTransfert(idTransfert);
		em.persist(message);
		return message;
	}

	@Override
	public List<Message> getAllMessage() {
		String req="SELECT * FROM message";
		Query query = em.createQuery(req);
		return query.getResultList();
	}

	@Override
	public List<Message> getMessageByIdTransfert(int idTransfert, int idParticipant) {
		String req="SELECT * FROM message m WHERE m.IDTRANSFERT =:pidTransfert AND m.IDPARTICIPANT =:pidParticipant";
		Query query= em.createQuery(req).setParameter("pidParticipant", idParticipant).setParameter("pidTransfert", idTransfert);
		return query.getResultList();
	}

}
