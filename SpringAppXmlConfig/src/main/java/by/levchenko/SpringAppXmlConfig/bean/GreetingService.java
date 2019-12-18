package by.levchenko.SpringAppXmlConfig.bean;

import java.util.List;

public class GreetingService {
	private List<Greeting> greetings;

	public List<Greeting> getGreetings() {
		return greetings;
	}

	public void setGreetings(List<Greeting> greetings) {
		this.greetings = greetings;
	}

}
