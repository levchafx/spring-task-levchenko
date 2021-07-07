package by.levchenko.TicketService.dao;

import java.util.List;

import by.levchenko.TicketService.domain.Ticket;
import by.levchenko.TicketService.domain.User;

public interface BookingDao {
	double getTicketPrice(Ticket t);

	void bookTicket(Ticket t, User u);

	List<Ticket> getPurchasedTicketsForEvent(int eventId);
}
