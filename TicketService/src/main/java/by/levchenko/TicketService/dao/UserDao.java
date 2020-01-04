package by.levchenko.TicketService.dao;

import by.levchenko.TicketService.domain.User;

public interface UserDao extends CrudDao<User> {
	User getByEmail(String email);

	User getByLogin(String login);

}
