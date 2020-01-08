package by.levchenko.TicketService.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import by.levchenko.TicketService.dao.AbstractJpaDao;
import by.levchenko.TicketService.dao.CounterDao;
import by.levchenko.TicketService.domain.Counter;

@Component
@Transactional
public class CounterJpaDaoImpl extends AbstractJpaDao<Counter> implements CounterDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Counter accessEventByNameCounter(String name) {

		return em.createQuery("from Counter  where name ='getByName' and additionalInfo =:name", Counter.class)
				.setParameter("name", name).getResultList().stream().findFirst().orElse(new Counter());
	}

	@Override
	public Counter bookTicketsForEventCounter(String name) {

		return em.createQuery("from Counter  where name ='bookTicket' and additionalInfo =:name", Counter.class)
				.setParameter("name", name).getResultList().stream().findFirst().orElse(new Counter());
	}

	@Override
	public Counter queryForTicketsForEventCounter(String name) {

		return em.createQuery("from Counter  where name ='getTicketPrice' and additionalInfo =:name", Counter.class)
				.setParameter("name", name).getResultList().stream().findFirst().orElse(new Counter());
	}

	@Override
	public Counter discountForUserCounter(String discountName, int userId) {

		return em.createQuery("from Counter where name =:discountName and additionalInfo =:name", Counter.class)
				.setParameter("name", String.valueOf(userId)).setParameter("discountName", discountName).getResultList()
				.stream().findFirst().orElse(new Counter());
	}

	@Override
	public Class<Counter> getTClass() {

		return Counter.class;
	}

}
