package by.levchenko.TicketService.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import by.levchenko.TicketService.dao.AbstractJpaDao;
import by.levchenko.TicketService.dao.AuditoriumDao;
import by.levchenko.TicketService.domain.Auditorium;

@Repository
@Primary
public class AuditoriumJpaDaoImpl extends AbstractJpaDao<Auditorium> implements AuditoriumDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Auditorium getByName(String name) {
		Auditorium a = em.createQuery("from Auditorium where name=:name", Auditorium.class).setParameter("name", name)
				.getSingleResult();
		return a;
	}

	@Override
	public Class<Auditorium> getTClass() {

		return Auditorium.class;
	}

}
