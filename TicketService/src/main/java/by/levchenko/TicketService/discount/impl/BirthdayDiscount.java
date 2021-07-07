package by.levchenko.TicketService.discount.impl;

import java.time.LocalDate;
import java.time.ZoneId;

import by.levchenko.TicketService.discount.DiscountStrategy;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.User;

public class BirthdayDiscount implements DiscountStrategy {
	private static final double DISCOUNT = 0.05;

	@Override
	public double getDiscount(User user, Event event) {
		if (null != user.getBirthday()) {
			LocalDate birthday = new java.sql.Date(user.getBirthday().getTime()).toLocalDate();
			LocalDate rangeFrom = event.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(6);
			LocalDate rangeTo = event.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(6);
			LocalDate birthdayInTheEventYear = LocalDate.of(rangeFrom.getYear(), birthday.getMonth(),
					birthday.getDayOfMonth());
			if ((birthdayInTheEventYear.isAfter(rangeFrom)) && (birthdayInTheEventYear.isBefore(rangeTo))) {
				return DISCOUNT;
			}
		}
		return 0;

	}
}
