package by.levchenko.TicketService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.levchenko.TicketService.dao.UserDao;
import by.levchenko.TicketService.domain.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public User getById(int id) {

		return userDao.getById(id);
	}

	public List<User> getAll() {

		return userDao.getAll();
	}

	public User create(User value) {

		return userDao.create(value);
	}

	public User update(User value) {

		return userDao.update(value);
	}

	public void delete(int id) {
		userDao.delete(id);

	}

	public User getByEmail(String email) {

		return userDao.getByEmail(email);
	}

	public User getByLogin(String login) {

		return userDao.getByLogin(login);
	}

}
