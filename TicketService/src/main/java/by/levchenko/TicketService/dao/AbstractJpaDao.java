package by.levchenko.TicketService.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public abstract class AbstractJpaDao<T extends Serializable> {

	@PersistenceContext
	private EntityManager em;

	public abstract Class<T> getTClass();

	public T create(T t) {

		em.persist(t);

		return t;
	}

	public List<T> getAll() {
		List<T> tees;

		tees = em.createQuery("from " + getTClass().getSimpleName(), getTClass()).getResultList();

		return tees;
	}

	public T update(T t) {

		em.merge(t);

		return t;
	}

	public void delete(int id) {

		T t = em.find(getTClass(), id);
		em.remove(t);

	}

	public T getById(int id) {

		T t = em.find(getTClass(), id);

		return t;
	}

}