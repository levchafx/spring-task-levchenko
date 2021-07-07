package by.levchenko.TicketService.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private int id;
	private String name;
	private String email;
	private Date birthday;
	private String login;
	private String password;
	private Role role;
	private List<Integer> tickets = new ArrayList<>();

}
