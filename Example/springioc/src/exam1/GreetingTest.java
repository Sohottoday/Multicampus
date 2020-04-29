package exam1;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("exam1/beans.xml");
		
		LocalDateTime ldt = factory.getBean("time",LocalDateTime.class);
		Greeting greet=null;
		if(ldt.getHour()>=6 && ldt.getHour()<12) {
			greet = (MorningGreetingImpl)factory.getBean("morning");
		} else if (ldt.getHour()>=12 && ldt.getHour()<17) {
			greet = (AfternoonGreetingImpl)factory.getBean("afternoon");
		} else if (ldt.getHour()>=17 && ldt.getHour()<22) {
			greet = (EveningGreetingImpl)factory.getBean("evening");
		} else {
			greet = (EveningGreetingImpl)factory.getBean("night");
		}
		greet.greet();
		((ClassPathXmlApplicationContext)factory).close();
	}

}
