package by.levchenko.TicketService.dao;

import by.levchenko.TicketService.domain.Counter;

public interface CounterDao extends CrudDao<Counter> {
	Counter accessEventByNameCounter(String name);

	Counter bookTicketsForEventCounter(String name);

	Counter queryForTicketsForEventCounter(String name);

	Counter discountForUserCounter(String discountName, int userId);
}
