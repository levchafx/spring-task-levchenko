package by.levchenko.TicketService.domain;

public enum Role {
	ADMIN("admin"), USER("user");
	private int id;
	private String name;

	Role(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

}
