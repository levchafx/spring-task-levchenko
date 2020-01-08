package by.levchenko.TicketService.dao;

import java.util.List;

import by.levchenko.TicketService.domain.Ticket;

public interface TicketDao extends CrudDao<Ticket> {

	List<Ticket> getTicketsForUser(int id);

	List<Ticket> getPurchasedTicketsForEvent(int eventId);

}
