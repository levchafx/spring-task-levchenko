package by.levchenko.TicketService.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import by.levchenko.TicketService.domain.Role;
import by.levchenko.TicketService.domain.User;

@Configuration
@ComponentScan("by.levchenko.TicketService")
@PropertySource("classpath:user.properties")
public class UserConfig {
	@Autowired
	private Environment env;

	@Bean
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		User u = new User();

		u.setName(env.getProperty("user.name"));
		try {
			u.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse(env.getProperty("user.birthday")));

		} catch (ParseException e) {

			e.printStackTrace();
		}
		u.setEmail(env.getProperty("user.email"));
		u.setLogin(env.getProperty("user.login"));
		u.setPassword(env.getProperty("user.password"));
		u.setRole(Role.valueOf(env.getProperty("user.role")));
		users.add(u);

		return users;
	}
}
