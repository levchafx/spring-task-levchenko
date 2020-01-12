package by.levchenko.TicketService.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.levchenko.TicketService.dao.UserDao;
import by.levchenko.TicketService.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static List<User> users;

	@Autowired
	public UserDaoImpl(List<User> users) {
		UserDaoImpl.users = users;
	}

	@Override
	public User getByEmail(String email) {

		for (User user : users) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getByLogin(String login) {

		for (User user : users) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}

		return null;
	}

	@Override
	public User getById(int id) {

		for (User user : users) {
			if (user.getId() == (id)) {
				return user;
			}
		}

		return create(new User());
	}

	@Override
	public List<User> getAll() {

		return users;
	}

	@Override
	public User create(User value) {
		users.add(value);
		return value;
	}

	@Override
	public User update(User value) {
		for (User u : users) {
			if (u.getId() == value.getId()) {
				u = value;
			}
		}
		return value;
	}

	@Override
	public void delete(int id) {
		for (User u : users) {
			if (u.getId() == id) {
				users.remove(u);

			}
		}

	}

}
