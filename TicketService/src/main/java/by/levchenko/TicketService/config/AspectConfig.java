package by.levchenko.TicketService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.CounterAspect;
import aspect.DiscountAspect;
import aspect.LuckyWinnerAspect;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
	@Bean
	public CounterAspect counterAspect() {
		return new CounterAspect();
	}

	@Bean
	public DiscountAspect discountAspect() {
		return new DiscountAspect();
	}

	@Bean
	public LuckyWinnerAspect luckyWinnerAspect() {
		return new LuckyWinnerAspect();
	}
}
