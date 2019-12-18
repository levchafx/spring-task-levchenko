package by.levchenko.SpringAppXmlConfig.bean;

public class ConsoleWriter implements Writer {
	private static final String DEFAULT_MESSAGE = "hello world!";
	private String message = DEFAULT_MESSAGE;

	public void setMessage(String message) {
		this.message = message;
	}

	public void write() {
		System.out.println(message);
	}

}
