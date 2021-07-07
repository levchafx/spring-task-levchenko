package by.levchenko.TicketService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.levchenko.TicketService.dao.AuditoriumDao;
import by.levchenko.TicketService.domain.Auditorium;

@Service
public class AuditoriumService {
	@Autowired
	private AuditoriumDao auditoriumDao;

	public Auditorium getById(int id) {

		return auditoriumDao.getById(id);
	}

	public Auditorium create(Auditorium value) {

		return auditoriumDao.create(value);
	}

	public Auditorium update(Auditorium value) {

		return auditoriumDao.update(value);
	}

	public void delete(int id) {
		auditoriumDao.delete(id);

	}

	public Auditorium getByName(String name) {

		return auditoriumDao.getByName(name);
	}

	public List<Auditorium> getAll() {

		return auditoriumDao.getAll();
	}

}
