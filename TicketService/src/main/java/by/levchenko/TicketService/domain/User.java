package by.levchenko.TicketService.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data

public class User {
	private static volatile int counter = 0;
	private int id;
	private String name;
	private String email;
	private Date birthday;
	private String login;
	private String password;
	private Role role;
	private List<Integer> tickets = new ArrayList<>();

	public void getIdWithCounter() {
		counter++;
		this.id = counter;
	}

	public User() {
		getIdWithCounter();
	}
}
