package by.levchenko.SpringAppXmlConfig.bean;

public class Service {
	private Writer writer;

	public Service(Writer writer) {
		this.writer = writer;
	}

	public void process() {
		writer.write();
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
}
