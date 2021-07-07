package by.levchenko.TicketService.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Auditorium implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ToString.Exclude
	private int numberOfSeats;
	@ToString.Exclude

	private String numberOfVipSeats;

	/*
	 * public Set<Integer> getNumberOfVipSeats() { Set<Integer> vipSeats = new
	 * HashSet<>();
	 * 
	 * for (String str : Arrays.asList(numberOfVipSeats.split(","))) {
	 * vipSeats.add(Integer.parseInt(str)); } return vipSeats; }
	 */
}
