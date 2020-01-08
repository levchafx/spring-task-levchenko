package by.levchenko.TicketService.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import by.levchenko.TicketService.dao.AbstractJpaDao;
import by.levchenko.TicketService.dao.UserDao;
import by.levchenko.TicketService.domain.User;

@Repository
@Primary
public class UserJpaDaoImpl extends AbstractJpaDao<User> implements UserDao {
	@Override
	public Class<User> getTClass() {

		return User.class;
	}

	@PersistenceContext
	EntityManager em;

	@Override
	public User getByEmail(String email) {

		return em.createQuery("select u from User u where u.email = :email", User.class).setParameter("email", email)
				.getSingleResult();
	}

	@Override
	public User getByLogin(String login) {

		return em.createQuery("select u from User u where u.login = :login", User.class).setParameter("login", login)
				.getSingleResult();
	}

}
