package by.levchenko.SpringAppXmlConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.levchenko.SpringAppXmlConfig.bean.Greeting;
import by.levchenko.SpringAppXmlConfig.bean.GreetingService;
import by.levchenko.SpringAppXmlConfig.bean.Service;

public class App {
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-config.xml")) {
			Service service = (Service) ctx.getBean("service");
			service.process();
			GreetingService gservice = (GreetingService) ctx.getBean("greetingService");
			for (Greeting g : gservice.getGreetings()) {
				g.greet();
			}
		}
	}
}
