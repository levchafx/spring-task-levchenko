package by.levchenko.TicketService.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ticket {
	private int id;
	private int userId;
	private Event event;
	private int seatNumber;
	private double price;

}
