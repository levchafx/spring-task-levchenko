package by.levchenko.TicketService.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import by.levchenko.TicketService.dao.BookingDao;
import by.levchenko.TicketService.dao.EventDao;
import by.levchenko.TicketService.dao.TicketDao;
import by.levchenko.TicketService.dao.UserDao;
import by.levchenko.TicketService.domain.Ticket;
import by.levchenko.TicketService.domain.User;

public class BookingJpaDaoImpl implements BookingDao {
	@Autowired
	TicketDao ticketDao;
	@Autowired
	EventDao eventDao;
	@Autowired
	UserDao userDao;

	@Override
	public double getTicketPrice(Ticket t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void bookTicket(Ticket t, User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Ticket> getPurchasedTicketsForEvent(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

}
