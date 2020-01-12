package by.levchenko.TicketService.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import by.levchenko.TicketService.annotations.DaoQualifier;
import by.levchenko.TicketService.dao.AbstractJpaDao;
import by.levchenko.TicketService.dao.UserDao;
import by.levchenko.TicketService.domain.User;

@DaoQualifier
public class UserJpaDaoImpl extends AbstractJpaDao<User> implements UserDao {
	@Override
	public Class<User> getTClass() {

		return User.class;
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	public User getByEmail(String email) {

		return em.createQuery("from User  where email = :email", User.class).setParameter("email", email)
				.getSingleResult();
	}

	@Override
	public User getByLogin(String login) {

		return em.createQuery("from User  where login = :login", User.class).setParameter("login", login)
				.getSingleResult();
	}

}