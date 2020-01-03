package by.levchenko.SpringTask2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
public class AspectExample {
	@Pointcut("execution(* by.levchenko.SpringTask2.AopBean.*(..))")
	public void pointCutExample() {
	}

	@Before("pointCutExample()")
	public void aspectAdviceExample(JoinPoint jp) {
		System.out.println("hello from aspectAdvice()");
		System.out.println(jp.getSignature().getName());
	}
}
