package by.levchenko.TicketService.runner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.levchenko.TicketService.config.AppConfig;
import by.levchenko.TicketService.dao.AuditoriumDao;
import by.levchenko.TicketService.dao.EventDao;
import by.levchenko.TicketService.dao.UserDao;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.Rating;
import by.levchenko.TicketService.domain.Ticket;
import by.levchenko.TicketService.service.BookingService;
import by.levchenko.TicketService.utils.StringUtil;

public class Runner {

	public static void main(String[] args) throws ParseException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserDao userDao = ctx.getBean(UserDao.class);
		BookingService bs = ctx.getBean(BookingService.class);
		EventDao eventDao = ctx.getBean(EventDao.class);
		AuditoriumDao ad = ctx.getBean(AuditoriumDao.class);
		Event e = new Event();
		e.setId(1);
		e.setAuditorium(ad.getById(1));
		e.setDate(StringUtil.convertStringToDate("11/05/2020"));
		e.getDate().setHours(19);
		List<Integer> availableSeats = new ArrayList<>();
		for (int i = 0; i < e.getAuditorium().getNumberOfSeats(); i++) {
			availableSeats.add(i + 1);
		}
		e.setAvailableSeats(availableSeats);
		e.setMsrp(20);
		e.setName("Rambo");
		e.setRating(Rating.HIGH);
		eventDao.create(e);

		List<Ticket> tickets = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			Ticket t = new Ticket();
			t.setId(i + 1);
			t.setEvent(eventDao.getById(1));
			t.setUserId(1);
			t.setSeatNumber(i + 125);
			tickets.add(t);
		}

		for (Ticket ticket : tickets) {
			bs.bookTickets(ticket, userDao.getById(ticket.getUserId()));
		}
		ad.getAll().stream().forEach(System.out::println);
		userDao.getAll().stream().forEach(System.out::println);
		bs.getPurchasedTicketsForEvent(1).forEach(System.out::println);
		ctx.close();

	}
}
