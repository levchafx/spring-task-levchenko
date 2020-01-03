package by.levchenko.SpringTask2;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class User {
	private int id;
	private String name;
	private String email;
	private int age;
}
