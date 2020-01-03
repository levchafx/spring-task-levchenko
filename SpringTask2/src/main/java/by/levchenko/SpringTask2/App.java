package by.levchenko.SpringTask2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		AopBean aopBean = ctx.getBean(AopBean.class);
		aopBean.hello();

	}
}
