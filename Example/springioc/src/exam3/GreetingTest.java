package exam3;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam3/beans_anno.xml");
		
		LocalDateTime ldt = factory.getBean("time",LocalDateTime.class);
		Greeting grt=null;
		if(ldt.getHour()>=6 && ldt.getHour()<12) {
			grt = factory.getBean("morning", MorningGreetingImpl.class);
		} else if (ldt.getHour()>=12 && ldt.getHour()<17) {
			grt = factory.getBean("afternoon", AfternoonGreetingImpl.class);
		} else if (ldt.getHour()>=17 && ldt.getHour()<22) {
			grt = factory.getBean("evening", EveningGreetingImpl.class);
		} else {
			grt = factory.getBean("night", NightGreetingImpl.class);
		}
		grt.greet();
		((ClassPathXmlApplicationContext)factory).close();
	}

}
