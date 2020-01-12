package by.levchenko.TicketService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.levchenko.TicketService.dao.BookingDao;
import by.levchenko.TicketService.dao.EventDao;
import by.levchenko.TicketService.domain.Ticket;
import by.levchenko.TicketService.domain.User;

@Service
public class BookingService {
	@Autowired
	private DiscountService discountService;
	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private EventDao eventDao;

	public Double getTicketPrice(Ticket t, User user) {
		double finalPrice = bookingDao.getTicketPrice(t);
		double discount = discountService.getDiscount(user, eventDao.getById(t.getEvent().getId()));

		if (discount != 0) {

			finalPrice *= (1 - discount);

		}

		return finalPrice;
	}

	public void bookTickets(Ticket t, User u) {

		bookingDao.bookTicket(t, u);
		t.setPrice(getTicketPrice(t, u));

	}

	public List<Ticket> getPurchasedTicketsForEvent(int eventId) {
		return bookingDao.getPurchasedTicketsForEvent(eventId);
	}
}
