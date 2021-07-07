package by.levchenko.TicketService.dao.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import by.levchenko.TicketService.annotations.DaoQualifier;
import by.levchenko.TicketService.dao.AbstractJpaDao;
import by.levchenko.TicketService.dao.EventDao;
import by.levchenko.TicketService.domain.Auditorium;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.Rating;

@DaoQualifier
public class EventJpaDaoImpl extends AbstractJpaDao<Event> implements EventDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Event getEventWithAvailableSeats(int id) {

		return em.createQuery("from Event e join fetch e.availableSeats where id=:id", Event.class)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public Event getEventWithTicketsSoldAndAvailableSeats(int id) {
		Event e = getEventWithAvailableSeats(id);

		e.getTicketsSold();
		return e;
	}

	@Override
	public Class<Event> getTClass() {

		return Event.class;
	}

	@Override
	public List<Event> getByRating(Rating rating) {

		return em.createQuery("from Event where rating=:rating", Event.class)
				.setParameter("rating", String.valueOf(rating)).getResultList();
	}

	@Override
	public List<Event> getByDate(Date date) {

		return em.createQuery("from Event  where date = :date", Event.class).setParameter("date", date).getResultList();
	}

	@Override
	public List<Event> getWithinRangeOfDates(Date dateFrom, Date dateTo) {

		return em.createQuery("from Event  where date between :dateFrom and :dateTo", Event.class)
				.setParameter("dateFrom", dateFrom).setParameter("dateTo", dateTo).getResultList();
	}

	@Override
	public List<Event> getByAuditorium(Auditorium auditorium) {

		return em.createQuery("from Event  where auditorium_id=:id", Event.class).setParameter("id", auditorium.getId())
				.getResultList();
	}

	@Override
	public List<Event> getUpcomingEvents(Date date) {

		return em.createQuery("from Event  where date >=:date", Event.class).setParameter("date", LocalDate.now())
				.getResultList();
	}

	@Override
	public List<Event> getByName(String name) {

		return em.createQuery("from Event  where name=:name ", Event.class).setParameter("name", name).getResultList();
	}

}
