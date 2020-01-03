package by.levchenko.SpringTask2;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository("UserRepository")
@Data
public class UserRepository {
	private String name;

	private List<User> users;

	public void init() {
		System.out.println("initializing user repository");
	}

	public void destroy() {
		System.out.println("destroying user repository");
	}
}
