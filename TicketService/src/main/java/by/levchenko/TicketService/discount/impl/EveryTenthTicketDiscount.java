package by.levchenko.TicketService.discount.impl;

import org.springframework.beans.factory.annotation.Autowired;

import by.levchenko.TicketService.dao.TicketDao;
import by.levchenko.TicketService.discount.DiscountStrategy;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.User;

public class EveryTenthTicketDiscount implements DiscountStrategy {
	private static final double DISCOUNT = 0.5;
	@Autowired
	TicketDao ticketDao;

	@Override
	public double getDiscount(User user, Event event) {
		double discount = 0;

		if ((ticketDao.getTicketsForUser(user.getId()).size() % 10) == 0) {

			discount = DISCOUNT;

		}

		return discount;

	}
}
