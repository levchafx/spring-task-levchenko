package by.levchenko.TicketService.discount;

import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.User;

public interface DiscountStrategy {
	double getDiscount(User user, Event event);
}
