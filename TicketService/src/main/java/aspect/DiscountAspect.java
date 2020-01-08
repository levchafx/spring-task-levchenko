package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import by.levchenko.TicketService.dao.CounterDao;
import by.levchenko.TicketService.domain.Counter;
import by.levchenko.TicketService.domain.User;

@Aspect
public class DiscountAspect {
	@Autowired
	CounterDao counterDao;

	@Pointcut("execution(* by.levchenko.TicketService.discount.*.getDiscount(..)))")
	private void discountGetDiscount() {

	}

	@AfterReturning(pointcut = "discountGetDiscount()", returning = "discount")
	public void discountServiceGetDiscountAfterCall(JoinPoint jp, double discount) {
		Class<?> clazz = jp.getTarget().getClass();
		User u = (User) jp.getArgs()[0];
		if (discount > 0) {
			Counter c = counterDao.discountForUserCounter(clazz.getSimpleName(), u.getId());
			if (c.getValue() == 0) {
				c.setName(clazz.getSimpleName());
				c.setAdditionalInfo(String.valueOf(u.getId()));
				c.setValue(1);
				counterDao.create(c);
			} else {
				c.setValue(1 + c.getValue());
				counterDao.update(c);
			}
		}

	}
}
