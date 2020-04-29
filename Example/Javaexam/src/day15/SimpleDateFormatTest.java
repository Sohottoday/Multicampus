package day15;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

	public static String timeToStrDate(long time) {
		DateFormat formatter = 
				new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(time);
	}

	public static Date parseStrDate(String strDate) throws ParseException {
		DateFormat formatter = 
				new SimpleDateFormat("yyyy년 MM월 dd일");
		return formatter.parse(strDate);	// simpleDateFormat 데이터를 parse한다.
	}			//어떠한 문자열을 년월일로 인식하여 뽑아낸다.

	public static void main(String[] args) throws ParseException {
		System.out.println(timeToStrDate(new Date().getTime()));
		System.out.println(parseStrDate("2019년 12월 25일")); 		
	}
}



