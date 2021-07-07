package by.levchenko.TicketService.aspect;

import java.util.Random;

import org.apache.logging.log4j.core.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import by.levchenko.TicketService.dao.CounterDao;
import by.levchenko.TicketService.domain.Counter;
import by.levchenko.TicketService.domain.Event;
import by.levchenko.TicketService.domain.User;

@Aspect

public class LuckyWinnerAspect {
	@Autowired
	CounterDao counterDao;
	Object object;
	@Autowired
	Logger logger;

	@Pointcut("execution(* by.levchenko.TicketService.service.DiscountService.getDiscount(..))")
	public void getDiscountForTicket() {
	}

	@Around(value = "getDiscountForTicket() && args(user,event)", argNames = "joinPoint,user,event")
	public double checkLucky(ProceedingJoinPoint joinPoint, User user, Event event) throws Throwable {
		boolean isLucky = isLucky();

		if (isLucky) {

			logger.info("luckyWinnerDiscount is given to User " + user.getId());
			Counter c = counterDao.discountForUserCounter("luckyWinnerDiscount", user.getId());
			if (c.getValue() == 0) {
				c.setName("luckyWinnerDiscount");
				c.setAdditionalInfo(String.valueOf(user.getId()));
				c.setValue(1);
				counterDao.create(c);
			} else {
				c.setValue(1 + c.getValue());
				counterDao.update(c);
			}
			return 1.0;
		}
		return (double) joinPoint.proceed(joinPoint.getArgs());
	}

	private boolean isLucky() {

		Random rand = new Random();

		Random rand1 = new Random();
		return rand.nextInt(10) == rand1.nextInt(10);

	}
}
