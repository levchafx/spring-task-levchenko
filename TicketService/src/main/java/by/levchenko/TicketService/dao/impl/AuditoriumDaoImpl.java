package by.levchenko.TicketService.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.levchenko.TicketService.dao.AuditoriumDao;
import by.levchenko.TicketService.domain.Auditorium;

@Component

public class AuditoriumDaoImpl implements AuditoriumDao {

	private static List<Auditorium> auditoriums;

	@Autowired
	public AuditoriumDaoImpl(List<Auditorium> auditoriums) {
		AuditoriumDaoImpl.auditoriums = auditoriums;
	}

	@Override
	public Auditorium getByName(String name) {

		for (Auditorium aud : auditoriums) {
			if (aud.getName().equals(name)) {
				return aud;
			}
		}
		return null;
	}

	@Override
	public Auditorium getById(int id) {

		for (Auditorium a : auditoriums) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}

	@Override
	public List<Auditorium> getAll() {

		return auditoriums;
	}

	@Override
	public Auditorium create(Auditorium value) {
		auditoriums.add(value);
		return value;
	}

	@Override
	public Auditorium update(Auditorium value) {
		for (Auditorium a : auditoriums) {
			if (a.getId() == value.getId()) {
				a = value;
			}
		}
		return value;
	}

	@Override
	public void delete(int id) {
		for (Auditorium a : auditoriums) {
			if (a.getId() == id) {
				auditoriums.remove(a);
			}
		}

	}

}
