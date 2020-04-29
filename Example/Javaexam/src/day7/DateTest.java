package day7;

import java.util.Date;
//같은 패키지가 아닌 다른 패키지에 있는 데이터를 접근하기 위해 쓰는 용어 import
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		// Date 클래스
		Date d = new Date();
		System.out.println(d.toString());
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
		// 1은 일요일 4가 나오므로 수요일 .DAY_OF_WEEK 는 요일을 불러옴
		gc = new GregorianCalendar(2019,11,25); //1월이 0부터 시작하므로 11로 설정한다.
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
		gc = new GregorianCalendar(1991,10,14); 
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
		
	}

}