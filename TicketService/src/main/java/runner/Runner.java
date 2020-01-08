package runner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import by.levchenko.TicketService.config.AspectConfig;
import by.levchenko.TicketService.config.DiscountConfig;
import by.levchenko.TicketService.config.HibernateJpaConfig;
import by.levchenko.TicketService.config.LoggerConfig;
import by.levchenko.TicketService.dao.AuditoriumDao;
import by.levchenko.TicketService.dao.CounterDao;
import by.levchenko.TicketService.dao.EventDao;
import by.levchenko.TicketService.dao.TicketDao;
import by.levchenko.TicketService.dao.UserDao;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.Rating;
import by.levchenko.TicketService.domain.Ticket;
import by.levchenko.TicketService.domain.User;
import by.levchenko.TicketService.service.BookingService;

@Configuration

@ComponentScan(basePackages = "by.levchenko.TicketService")
@Import({ DiscountConfig.class, HibernateJpaConfig.class, AspectConfig.class, LoggerConfig.class })
public class Runner {

	@Transactional
	public static void main(String[] args) throws ParseException {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Runner.class);
		UserDao userDao = ctx.getBean(UserDao.class);
		AuditoriumDao ad = ctx.getBean(AuditoriumDao.class);
		EventDao eventDao = ctx.getBean(EventDao.class);
		BookingService bs = ctx.getBean(BookingService.class);
		TicketDao ticketDao = ctx.getBean(TicketDao.class);
		CounterDao counterDao = ctx.getBean(CounterDao.class);

		Event e = new Event();

		e.setAuditorium(ad.getById(1));
		e.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2020"));
		e.getDate().setHours(19);
		Set<Integer> availableSeats = new HashSet<>();
		for (int i = 0; i < e.getAuditorium().getNumberOfSeats(); i++) {
			availableSeats.add(i + 1);

		}

		e.setAvailableSeats(availableSeats);

		e.setMsrp(20);
		e.setName("Rambo");
		e.setRating(Rating.HIGH);
		eventDao.create(e);
		e = eventDao.getById(1);
		Set<Ticket> tickets = new HashSet<>();

		User u = userDao.getById(1);
		for (int i = 0; i < 38; i++) {
			Ticket t = new Ticket();

			t.setEvent(e);
			t.setUser(u);
			t.setSeatNumber(i + 125);
			tickets.add(t);

		}

		for (Ticket ticket : tickets) {

			bs.bookTickets(ticket, ticket.getUser());

		}
		eventDao.getByName("Rambo").forEach(System.out::println);

		ticketDao.getTicketsForUser(1).forEach(System.out::println);
		System.out.println(counterDao.discountForUserCounter("luckyWinnerDiscount", 1));
		counterDao.getAll().forEach(System.out::println);
		ctx.close();
	}

}
