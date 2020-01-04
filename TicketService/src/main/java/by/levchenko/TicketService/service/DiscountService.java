package by.levchenko.TicketService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.levchenko.TicketService.discount.DiscountStrategy;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.User;

@Service
public class DiscountService {
	@Autowired

	List<DiscountStrategy> discountStrategies;

	public double getDiscount(User user, Event event) {
		double totalDiscount = 0;
		for (DiscountStrategy ds : discountStrategies) {
			double discount = ds.getDiscount(user, event);

			if (totalDiscount < discount) {
				totalDiscount = discount;

			}
		}

		return totalDiscount;
	}

}
