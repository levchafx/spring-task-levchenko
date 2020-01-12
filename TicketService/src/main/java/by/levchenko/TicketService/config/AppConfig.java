package by.levchenko.TicketService.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "by.levchenko.TicketService")
@Import({ AuditoriumConfig.class, DiscountConfig.class, UserConfig.class })

public class AppConfig {

}
