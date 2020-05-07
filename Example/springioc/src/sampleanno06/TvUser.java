package sampleanno06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser {
	public static void main(String[] args) {
		ApplicationContext factory
		        = new ClassPathXmlApplicationContext("sampleanno06/bean.xml");
	
		Tv asdf = factory.getBean("lg", LgTv.class);
		/*
		 * Tv tv=(Tv)factory.getBean(args[0]); //samsung or lg
		 */		asdf.powerOn();
		asdf.powerOff();
		asdf.volumeUp();
		asdf.volumeDown();
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
