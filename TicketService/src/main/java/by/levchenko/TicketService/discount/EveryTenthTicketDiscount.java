package by.levchenko.TicketService.discount;

import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.User;

public class EveryTenthTicketDiscount implements DiscountStrategy {
	private static final double DISCOUNT = 0.5;

	@Override
	public double getDiscount(User user, Event event) {
		double discount = 0;

		if ((user.getTickets().size() % 10) == 0) {

			discount = DISCOUNT;

		}

		return discount;

	}
}
