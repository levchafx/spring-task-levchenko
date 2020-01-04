package by.levchenko.TicketService.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import by.levchenko.TicketService.dao.EventDao;
import by.levchenko.TicketService.domain.Auditorium;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.Rating;

@Component
public class EventDaoImpl implements EventDao {
	private static List<Event> events = new ArrayList<>();

	@Override
	public List<Event> getByRating(Rating rating) {
		List<Event> event = new ArrayList<>();
		for (Event e : events) {
			if (e.getRating().equals(rating)) {
				event.add(e);
			}
		}
		return event;
	}

	@Override
	public List<Event> getByDate(Date date) {
		List<Event> event = new ArrayList<>();
		for (Event e : events) {
			if (e.getDate().equals(date)) {
				event.add(e);
			}

		}
		return event;
	}

	@Override
	public List<Event> getWithinRangeOfDates(Date dateFrom, Date dateTo) {
		List<Event> event = new ArrayList<>();
		for (Event e : events) {

			if (e.getDate().after(dateFrom) && e.getDate().before(dateTo)) {
				event.add(e);
			}

		}
		return event;
	}

	@Override
	public List<Event> getByAuditorium(Auditorium auditorium) {
		List<Event> event = new ArrayList<>();
		for (Event e : events) {
			if (e.getAuditorium().equals(auditorium)) {
				event.add(e);
			}
		}
		return event;
	}

	@Override
	public List<Event> getUpcomingEvents(Date date) {
		List<Event> event = new ArrayList<>();

		for (Event e : events) {

			if (e.getDate().after(Calendar.getInstance().getTime()) && e.getDate().before(date)) {
				event.add(e);

			}
		}
		return event;
	}

	@Override
	public Event getById(int id) {

		for (Event event : events) {
			if (event.getId() == id) {
				return event;
			}
		}
		return null;
	}

	@Override
	public List<Event> getAll() {

		return events;
	}

	@Override
	public Event create(Event value) {
		events.add(value);
		return value;
	}

	@Override
	public Event update(Event value) {
		for (Event e : events) {
			if (e.getId() == value.getId()) {
				e = value;
			}
		}
		return value;
	}

	@Override
	public void delete(int id) {
		for (Event e : events) {
			if (e.getId() == id) {
				events.remove(e);
			}
		}

	}

}
