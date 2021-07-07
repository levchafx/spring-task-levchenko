package by.levchenko.TicketService.config;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import by.levchenko.TicketService.domain.Role;
import by.levchenko.TicketService.domain.User;
import by.levchenko.TicketService.utils.StringUtil;

@Configuration
@ComponentScan("by.levchenko.TicketService")
@PropertySource("classpath:user.properties")
public class UserConfig {
	@Autowired
	private Environment env;

	@Bean
	User getUser() throws ParseException {
		return new User(1, env.getProperty("user.name"), env.getProperty("user.email"),
				StringUtil.convertStringToDate(env.getProperty("user.birthday")), env.getProperty("user.login"),
				env.getProperty("user.password"), Role.ADMIN, new ArrayList<>());
	}

}
