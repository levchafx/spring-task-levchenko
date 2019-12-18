package by.levchenko.SpringAppXmlConfig.bean;

public class RussianGreeting implements Greeting {
	private String message = "Здарова";

	public void greet() {
		System.out.println(message);
	}

}
