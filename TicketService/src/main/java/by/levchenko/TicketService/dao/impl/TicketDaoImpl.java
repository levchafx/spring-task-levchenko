package by.levchenko.TicketService.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import by.levchenko.TicketService.dao.TicketDao;
import by.levchenko.TicketService.domain.Ticket;

@Component
public class TicketDaoImpl implements TicketDao {
	private static List<Ticket> tickets = new ArrayList<>();

	@Override
	public Ticket getById(int id) {

		for (Ticket t : tickets) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}

	@Override
	public List<Ticket> getAll() {

		return tickets;
	}

	@Override
	public Ticket create(Ticket value) {
		tickets.add(value);
		return value;
	}

	@Override
	public Ticket update(Ticket value) {
		for (Ticket t : tickets) {
			if (t.getId() == value.getId()) {
				t = value;
			}
		}
		return value;
	}

	@Override
	public void delete(int id) {
		for (Ticket t : tickets) {
			if (t.getId() == id) {
				tickets.remove(t);
			}
		}

	}

}
