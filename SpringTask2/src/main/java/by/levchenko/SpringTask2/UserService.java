package by.levchenko.SpringTask2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component("userService")

@Data
@NoArgsConstructor
public class UserService {

	private String name;
	@Autowired
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void init() {
		System.out.println("initializing user service");
	}

	public void destroy() {
		System.out.println("destroying userservice");
	}
}
