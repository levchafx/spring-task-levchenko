package by.levchenko.SpringTask2;

import org.springframework.stereotype.Component;

@Component
public class AopBean {
	public void hello() {
		System.out.println("Hello aspect!!");
	}
}
