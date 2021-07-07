package by.levchenko.TicketService.dao;

import java.util.Date;
import java.util.List;

import by.levchenko.TicketService.domain.Auditorium;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.Rating;

public interface EventDao extends CrudDao<Event> {
	List<Event> getByRating(Rating rating);

	List<Event> getByDate(Date date);

	List<Event> getWithinRangeOfDates(Date dateFrom, Date dateTo);

	List<Event> getByAuditorium(Auditorium auditorium);

	List<Event> getUpcomingEvents(Date date);

	List<Event> getByName(String name);

	Event getEventWithAvailableSeats(int id);

	Event getEventWithTicketsSoldAndAvailableSeats(int id);
}
