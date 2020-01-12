package by.levchenko.TicketService.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auditorium {
	private int id;
	private String name;
	@ToString.Exclude
	private int numberOfSeats;
	@ToString.Exclude
	private List<Integer> numberOfVipSeats;
}
