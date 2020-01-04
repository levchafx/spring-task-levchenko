package by.levchenko.TicketService.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import by.levchenko.TicketService.domain.Auditorium;

@Configuration
@ComponentScan("by.levchenko.TicketService")
@PropertySource("classpath:auditorium.properties")

public class AuditoriumConfig {
	@Autowired
	private Environment env;

	@Bean

	public List<Auditorium> getAuditoriums() {
		List<Auditorium> auditoriums = new ArrayList<>();
		List<Integer> vipSeats = new ArrayList<>();
		List<Integer> vipSeats1 = new ArrayList<>();
		List<Integer> vipSeats2 = new ArrayList<>();
		Auditorium a = new Auditorium();
		a.setId(1);
		a.setName(env.getProperty("name1"));
		a.setNumberOfSeats(Integer.parseInt(env.getProperty("numberOfSeats1")));
		String s = env.getProperty("vipSeats1");

		for (String str : Arrays.asList(s.split(","))) {
			vipSeats.add(Integer.parseInt(str));
		}
		a.setNumberOfVipSeats(vipSeats);

		auditoriums.add(a);

		Auditorium a1 = new Auditorium();
		a1.setId(2);
		a1.setName(env.getProperty("name2"));
		a1.setNumberOfSeats(Integer.parseInt(env.getProperty("numberOfSeats2")));
		String s1 = env.getProperty("vipSeats2");
		for (String str : Arrays.asList(s1.split(","))) {
			vipSeats1.add(Integer.parseInt(str));
		}
		a1.setNumberOfVipSeats(vipSeats1);

		auditoriums.add(a1);

		Auditorium a2 = new Auditorium();
		a2.setId(3);
		a2.setName(env.getProperty("name3"));
		a2.setNumberOfSeats(Integer.parseInt(env.getProperty("numberOfSeats3")));
		String s2 = env.getProperty("vipSeats3");
		for (String str : Arrays.asList(s2.split(","))) {
			vipSeats2.add(Integer.parseInt(str));
		}
		a2.setNumberOfVipSeats(vipSeats2);

		auditoriums.add(a2);
		return auditoriums;
	}
}
