package threadexam;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ThreadLab2 {

	public static void main(String[] args) {
		Runnable g10s = new get10sec2();
		Runnable g5s = new get5sec2();
		Thread gorun1 = new Thread(g10s);
		Thread gorun2 = new Thread(g5s);
		gorun1.start();
		gorun2.start();
		for(int i=0 ; i<=9 ; i++) {
			System.out.println("number of milliseconds since January 1, 1970, 00:00:00 GMT");
			try { 
				Thread.sleep(3 * 1000);
			} catch(InterruptedException e) {}	
		}
	}
}

class get10sec2 implements Runnable {
	public void run() {
		GregorianCalendar gc = new GregorianCalendar();
		for(int i=0 ; i<=2 ; i++) {
			System.out.println("오늘은 "+(gc.get(Calendar.MONTH)+1)+"월 "+gc.get(Calendar.DAY_OF_MONTH)+"일입니다.");
			try { 
				Thread.sleep(10 * 1000);
			} catch(InterruptedException e) {}	
		}
	}
}

class get5sec2 implements Runnable {
	public void run() {
		Date rr = new Date();
		for(int i=0 ; i<=4 ; i++) {
			System.out.println(rr.getHours()+"시 "+rr.getMinutes()+"분 "+rr.getSeconds()+"초");
			try { 
				Thread.sleep(5 * 1000);
			} catch(InterruptedException e) {}	
		}
	}
}


