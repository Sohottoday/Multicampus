package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SpringSchedulerTest {
   @Scheduled(cron="10 * * * * 5")//초,분,시,일,월,요일(1:일요일)
   //@Scheduled(fixedDelay=10000)//10초간격으로
	public void scheduleRun() {
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat(
				                                       "yyyy-MM-dd HH:mm:ss");
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			
		}
		System.out.println(new java.util.Date()+"스케줄 실행:"+dateFormat.format(calendar.getTime()));
		
	}
}
