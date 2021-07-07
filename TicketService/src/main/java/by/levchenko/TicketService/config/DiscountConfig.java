package by.levchenko.TicketService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.levchenko.TicketService.discount.DiscountStrategy;
import by.levchenko.TicketService.discount.impl.BirthdayDiscount;
import by.levchenko.TicketService.discount.impl.EveryTenthTicketDiscount;

@Configuration
public class DiscountConfig {
	@Bean
	public DiscountStrategy birthdayDiscount() {
		return new BirthdayDiscount();
	}

	@Bean
	public DiscountStrategy everyTenthTicketDiscount() {
		return new EveryTenthTicketDiscount();
	}

}
