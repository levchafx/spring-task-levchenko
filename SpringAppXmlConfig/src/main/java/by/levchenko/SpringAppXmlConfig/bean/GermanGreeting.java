package by.levchenko.SpringAppXmlConfig.bean;

public class GermanGreeting implements Greeting {
	private String message = "Gutten Tag";

	public void greet() {
		System.out.println(message);

	}

}
