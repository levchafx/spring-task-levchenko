package by.levchenko.TicketService.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.levchenko.TicketService.dao.EventDao;
import by.levchenko.TicketService.dao.TicketDao;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.Rating;
import by.levchenko.TicketService.domain.Ticket;
import by.levchenko.TicketService.domain.User;

@Component
@Transactional
public class BookingService {
	@Autowired
	private DiscountService discountService;

	@Autowired
	TicketDao ticketDao;
	@Autowired
	EventDao eventDao;
	@PersistenceContext
	EntityManager em;

	public Double getTicketPrice(Ticket t, User user) {
		double price = t.getEvent().getMsrp();
		if (t.getEvent().getAuditorium().getNumberOfVipSeats().contains(String.valueOf(t.getSeatNumber()))) {
			price *= 2;

		}
		if (t.getEvent().getRating() == Rating.HIGH) {
			price *= 1.2;
		}
		double discount = discountService.getDiscount(user, eventDao.getById(t.getEvent().getId()));

		if (discount != 0) {

			price *= (1 - discount);

		}

		return price;
	}

	public void bookTickets(Ticket t, User u) {

		t = ticketDao.create(t);
		Event e = eventDao.getEventWithTicketsSoldAndAvailableSeats(t.getEvent().getId());
		e.getAvailableSeats().remove(t.getSeatNumber());
		e.getTicketsSold().add(t);

		t.setPrice(getTicketPrice(t, u));

		ticketDao.update(t);

		eventDao.update(t.getEvent());

	}

	public List<Ticket> getPurchasedTicketsForEvent(int eventId) {
		return ticketDao.getPurchasedTicketsForEvent(eventId);
	}
}
