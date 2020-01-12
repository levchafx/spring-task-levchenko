package by.levchenko.TicketService.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("by.levchenko.TicketService")
@Import({ DiscountConfig.class, HibernateJpaConfig.class, AspectConfig.class, LoggerConfig.class })
public class AppConfig {

}
