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
			wt.write(String.format("������ %tY�� %tm�� %td���Դϴ�", td, td,td));
			//wt.write("������ 2019�� 12�� 20���Դϴ�.");
			wt.write("\n");
			wt.write("������ ");
			switch(to.get(GregorianCalendar.DAY_OF_WEEK)) {
			case 7 : wt.write("�����");
				break;
			case 1 : wt.write("�Ͽ���");
				break;
			case 2 : wt.write("������");
				break;
			case 3 : wt.write("ȭ����");
				break;
			case 4 : wt.write("������");
				break;
			case 5 : wt.write("�����");
				break;
			case 6 : wt.write("�ݿ���");
				break;
		}
			wt.write("�Դϴ�.");
			wt.write("\n");
			wt.write("���� �ָ��� ������ �ִ� �����̴� ");
			switch(br.get(GregorianCalendar.DAY_OF_WEEK)) {
				case 7 : wt.write("�����");
					break;
				case 1 : wt.write("�Ͽ���");
					break;
				case 2 : wt.write("������");
					break;
				case 3 : wt.write("ȭ����");
					break;
				case 4 : wt.write("������");
					break;
				case 5 : wt.write("�����");
					break;
				case 6 : wt.write("�ݿ���");
					break;
			}
			wt.write("�� �¾���ϴ�.");
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			wt.close();
		} catch (IOException ioe) {
            System.out.println("���Ͽ� �����ϴ� ���� ������ �߻��߽��ϴ�.");
		} 
	}
}

