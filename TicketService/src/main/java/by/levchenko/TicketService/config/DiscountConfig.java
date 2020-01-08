package by.levchenko.TicketService.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.levchenko.TicketService.discount.BirthdayDiscount;
import by.levchenko.TicketService.discount.DiscountStrategy;
import by.levchenko.TicketService.discount.EveryTenthTicketDiscount;

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

	@Bean

	public List<DiscountStrategy> discountStrategies() {
		return Arrays.asList(birthdayDiscount(), everyTenthTicketDiscount());
	}
}