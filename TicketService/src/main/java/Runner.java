import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import by.levchenko.TicketService.config.AuditoriumConfig;
import by.levchenko.TicketService.config.DiscountConfig;
import by.levchenko.TicketService.config.UserConfig;
import by.levchenko.TicketService.dao.AuditoriumDao;
import by.levchenko.TicketService.dao.EventDao;
import by.levchenko.TicketService.dao.UserDao;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.Rating;
import by.levchenko.TicketService.domain.Ticket;
import by.levchenko.TicketService.service.BookingService;

@Configuration

@ComponentScan(basePackages = "by.levchenko.TicketService")
@Import({ AuditoriumConfig.class, DiscountConfig.class, UserConfig.class })
public class Runner {
	private static Event createEvent(int auditoriumId, Date date) throws ParseException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Runner.class);
		EventDao eventDao = ctx.getBean(EventDao.class);
		AuditoriumDao ad = ctx.getBean(AuditoriumDao.class);
		ctx.close();
		Event e = new Event();
		e.setId(1);
		e.setAuditorium(ad.getById(auditoriumId));
		e.setDate(date);
		e.getDate().setHours(19);
		List<Integer> availableSeats = new LinkedList<>();
		for (int i = 0; i < e.getAuditorium().getNumberOfSeats(); i++) {
			availableSeats.add(i + 1);
		}
		e.setAvailableSeats(availableSeats);
		e.setMsrp(20);
		e.setName("Rambo");
		e.setRating(Rating.HIGH);
		eventDao.create(e);

		return e;
	}

	private static List<Ticket> createTicketList(int eventId, int quantity, int userId) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Runner.class);
		EventDao eventDao = ctx.getBean(EventDao.class);
		UserDao userDao = ctx.getBean(UserDao.class);
		ctx.close();
		List<Ticket> tickets = new ArrayList<>();
		userId = userDao.getById(userId).getId();
		for (int i = 0; i < quantity; i++) {
			Ticket t = new Ticket();
			t.setId(i + 1);
			t.setEvent(eventDao.getById(eventId));
			t.setUserId(userId);
			t.setSeatNumber(i + 125);
			tickets.add(t);
		}

		return tickets;
	}

	public static void main(String[] args) throws ParseException {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Runner.class);
		UserDao userDao = ctx.getBean(UserDao.class);
		AuditoriumDao ad = ctx.getBean(AuditoriumDao.class);
		EventDao eventDao = ctx.getBean(EventDao.class);
		BookingService bs = ctx.getBean(BookingService.class);
		ctx.close();
		createEvent(1, new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2020"));

		List<Ticket> tickets = createTicketList(1, 38, 1);
		for (Ticket ticket : tickets) {
			bs.bookTickets(ticket, userDao.getById(ticket.getUserId()));
		}
		System.out.println(eventDao.getById(1).getAvailableSeats());
		ad.getAll().forEach(a -> System.out.println(a.getNumberOfVipSeats()));
		bs.getPurchasedTicketsForEvent(1).forEach(System.out::println);

	}

}
