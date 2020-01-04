package by.levchenko.TicketService.dao;

import java.util.List;

import by.levchenko.TicketService.domain.Auditorium;

public interface AuditoriumDao extends CrudDao<Auditorium> {
	Auditorium getByName(String name);

	List<Auditorium> getAll();
}
