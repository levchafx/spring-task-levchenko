package by.levchenko.TicketService.dao;

import java.util.List;

public interface CrudDao<T> {

	T getById(int id);

	List<T> getAll();

	T create(T value);

	T update(T value);

	void delete(int id);

}
