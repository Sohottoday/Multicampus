package day7;

import java.util.Date;
//���� ��Ű���� �ƴ� �ٸ� ��Ű���� �ִ� �����͸� �����ϱ� ���� ���� ��� import
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		// Date Ŭ����
		Date d = new Date();
		System.out.println(d.toString());
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
		// 1�� �Ͽ��� 4�� �����Ƿ� ������ .DAY_OF_WEEK �� ������ �ҷ���
		gc = new GregorianCalendar(2019,11,25); //1���� 0���� �����ϹǷ� 11�� �����Ѵ�.
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
		gc = new GregorianCalendar(1991,10,14); 
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));
		
	}

}