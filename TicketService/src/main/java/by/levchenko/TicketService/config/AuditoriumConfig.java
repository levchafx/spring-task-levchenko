package by.levchenko.TicketService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import by.levchenko.TicketService.domain.Auditorium;
import by.levchenko.TicketService.utils.StringUtil;

@Configuration
@ComponentScan("by.levchenko.TicketService")
@PropertySource("classpath:auditorium.properties")

public class AuditoriumConfig {
	@Autowired
	private Environment env;

	@Bean
	public Auditorium createAuditorium1() {
		return new Auditorium(1, env.getProperty("name1"), Integer.parseInt(env.getProperty("numberOfSeats1")),
				StringUtil.convertStringToList(env.getProperty("vipSeats1")));
	}

	@Bean
	public Auditorium createAuditorium2() {
		return new Auditorium(2, env.getProperty("name2"), Integer.parseInt(env.getProperty("numberOfSeats2")),
				StringUtil.convertStringToList(env.getProperty("vipSeats2")));
	}

	@Bean
	public Auditorium createAuditorium3() {
		return new Auditorium(3, env.getProperty("name3"), Integer.parseInt(env.getProperty("numberOfSeats3")),
				StringUtil.convertStringToList(env.getProperty("vipSeats3")));
	}

}
