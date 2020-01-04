package by.levchenko.TicketService.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.levchenko.TicketService.dao.BookingDao;
import by.levchenko.TicketService.dao.EventDao;
import by.levchenko.TicketService.dao.TicketDao;
import by.levchenko.TicketService.dao.UserDao;
import by.levchenko.TicketService.domain.Rating;
import by.levchenko.TicketService.domain.Ticket;
import by.levchenko.TicketService.domain.User;

@Component
public class BookingDaoImpl implements BookingDao {
	@Autowired
	TicketDao ticketDao;
	@Autowired
	EventDao eventDao;
	@Autowired
	UserDao userDao;

	@Override
	public double getTicketPrice(Ticket t) {
		double price = t.getEvent().getMsrp();
		if (t.getEvent().getAuditorium().getNumberOfVipSeats().contains(t.getSeatNumber())) {
			price *= 2;

		}
		if (t.getEvent().getRating() == Rating.HIGH) {
			price *= 1.2;
		}

		return price;
	}

	@Override
	public void bookTicket(Ticket t, User u) {

		ticketDao.create(t);
		t.getEvent().getAvailableSeats().remove((Integer) t.getSeatNumber());
		t.getEvent().getTicketsSold().add(t);
		u.getTickets().add(t.getId());

	}

	@Override
	public List<Ticket> getPurchasedTicketsForEvent(int eventId) {
		List<Ticket> tickets = new ArrayList<>();
		for (Ticket t : eventDao.getById(eventId).getTicketsSold()) {
			tickets.add(ticketDao.getById(t.getId()));
		}
		return tickets;
	}

}
