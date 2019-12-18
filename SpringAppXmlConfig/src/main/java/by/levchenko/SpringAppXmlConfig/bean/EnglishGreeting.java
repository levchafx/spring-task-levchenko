package by.levchenko.SpringAppXmlConfig.bean;

public class EnglishGreeting implements Greeting {
	private String message = "Hello";

	public void greet() {
		System.out.println(message);

	}

}
