package by.levchenko.TicketService.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import by.levchenko.TicketService.annotations.DaoQualifier;
import by.levchenko.TicketService.dao.AbstractJpaDao;
import by.levchenko.TicketService.dao.TicketDao;
import by.levchenko.TicketService.domain.Ticket;

@DaoQualifier
public class TicketJpaDaoImpl extends AbstractJpaDao<Ticket> implements TicketDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Ticket> getPurchasedTicketsForEvent(int eventId) {

		return em.createQuery("from Ticket where event_id=:id", Ticket.class).setParameter("id", eventId)
				.getResultList();
	}

	@Override
	public List<Ticket> getTicketsForUser(int id) {

		return em.createQuery("from Ticket  where user_id=:id ", Ticket.class).setParameter("id", id).getResultList();
	}

	@Override
	public Class<Ticket> getTClass() {

		return Ticket.class;
	}

}
