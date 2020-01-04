package by.levchenko.TicketService.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class Event {
	private int id;
	private String name;
	private Auditorium auditorium;
	private double msrp;
	private Rating rating;
	private Date date;
	@ToString.Exclude
	private List<Integer> availableSeats;
	@ToString.Exclude
	private List<Ticket> ticketsSold = new ArrayList<>();

}
