package day14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.GregorianCalendar;

public class FileOutExam {

	public static void main(String[] args) {
		 FileWriter wt = null;
		 GregorianCalendar td = new GregorianCalendar();
		 GregorianCalendar br = new GregorianCalendar();
		 GregorianCalendar to = new GregorianCalendar();
		 br = new GregorianCalendar(1991,10,14);
		 to = new GregorianCalendar(2019,11,20);
	        String path = "C:/iotest";
	        File mmm = new File(path);
	        if (!mmm.exists()) {
	        	mmm.mkdirs();
	        }
		try {
			wt = new FileWriter("C:/iotest/today.txt");
			wt.write(String.format("오늘은 %tY년 %tm월 %td일입니다", td, td,td));
			//wt.write("오늘은 2019년 12월 20일입니다.");
			wt.write("\n");
			wt.write("오늘은 ");
			switch(to.get(GregorianCalendar.DAY_OF_WEEK)) {
			case 7 : wt.write("토요일");
				break;
			case 1 : wt.write("일요일");
				break;
			case 2 : wt.write("월요일");
				break;
			case 3 : wt.write("화요일");
				break;
			case 4 : wt.write("수요일");
				break;
			case 5 : wt.write("목요일");
				break;
			case 6 : wt.write("금요일");
				break;
		}
			wt.write("입니다.");
			wt.write("\n");
			wt.write("뇌에 주름이 펴지고 있는 성연이는 ");
			switch(br.get(GregorianCalendar.DAY_OF_WEEK)) {
				case 7 : wt.write("토요일");
					break;
				case 1 : wt.write("일요일");
					break;
				case 2 : wt.write("월요일");
					break;
				case 3 : wt.write("화요일");
					break;
				case 4 : wt.write("수요일");
					break;
				case 5 : wt.write("목요일");
					break;
				case 6 : wt.write("금요일");
					break;
			}
			wt.write("에 태어났습니다.");
			System.out.println("저장이 완료되었습니다.");
			wt.close();
		} catch (IOException ioe) {
            System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		} 
	}
}

