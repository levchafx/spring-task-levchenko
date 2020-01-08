package by.levchenko.TicketService.config;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.levchenko.TicketService")

public class LoggerConfig {
	@Bean
	public Logger getLogger() {
		Logger logger = (Logger) LogManager.getRootLogger();
		logger.setLevel(Level.ALL);
		return logger;
	}

}
