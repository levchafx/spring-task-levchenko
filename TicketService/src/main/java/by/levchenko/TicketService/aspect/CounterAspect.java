package by.levchenko.TicketService.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import by.levchenko.TicketService.dao.CounterDao;
import by.levchenko.TicketService.domain.Counter;
import by.levchenko.TicketService.domain.Ticket;

@Aspect

public class CounterAspect {
	@Autowired
	CounterDao counterDao;

	@Pointcut("execution(* by.levchenko.TicketService.dao.impl.EventJpaDaoImpl.getByName(..))")
	private void eventGetByName() {
	}

	@Before("eventGetByName()")
	public void eventServiceGetByName(JoinPoint joinPoint) {
		String eventName = (String) joinPoint.getArgs()[0];
		Counter c = counterDao.accessEventByNameCounter(eventName);
		if (c.getValue() == 0) {
			c.setName("getByName");
			c.setAdditionalInfo(eventName);
			c.setValue(1);
			counterDao.create(c);
			return;
		} else {
			c.setValue(1 + c.getValue());
			counterDao.update(c);
		}
	}

	@Pointcut("execution(* by.levchenko.TicketService.service.BookingService.bookTickets(..))")
	private void eventBookTicket() {
	}

	@Before("eventBookTicket()")
	public void eventBookTicket(JoinPoint joinPoint) {
		Ticket ticket = (Ticket) joinPoint.getArgs()[0];
		String eventName = ticket.getEvent().getName();
		Counter c = counterDao.bookTicketsForEventCounter(eventName);
		if (c.getValue() == 0) {
			c.setName("bookTicket");
			c.setAdditionalInfo(eventName);
			c.setValue(1);
			counterDao.create(c);
			return;
		} else {
			c.setValue(1 + c.getValue());
			counterDao.update(c);
		}
	}

	@Pointcut("execution(* by.levchenko.TicketService.service.BookingService.getTicketPrice(..))")
	private void eventGetTicketPrice() {
	}

	@Before("eventGetTicketPrice()")
	public void eventGetTicketPrice(JoinPoint joinPoint) {
		Ticket ticket = (Ticket) joinPoint.getArgs()[0];
		String eventName = ticket.getEvent().getName();
		Counter c = counterDao.bookTicketsForEventCounter(eventName);
		if (c.getValue() == 0) {
			c.setName("getTicketPrice");
			c.setAdditionalInfo(eventName);
			c.setValue(1);
			counterDao.create(c);
			return;
		} else {
			c.setValue(1 + c.getValue());
			counterDao.update(c);
		}
	}
}
