package by.levchenko.TicketService.domain;

public enum Rating {
	HIGH("high"), MEDIUM("medium"), LOW("low");
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	Rating(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
