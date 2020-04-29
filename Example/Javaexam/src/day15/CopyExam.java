package day15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyExam {

	public static void main(String[] args)  {
		 FileWriter wt = null;
	        String path = "C:/iotest";
	        File isDir = new File(path);
	        if (!isDir.exists()) {
	        	isDir.mkdirs();
	        }
	
		try (FileReader reader = new FileReader("c:/iotest/sample.txt");
		    	   BufferedReader br = new BufferedReader(reader);)  {        
		    	   String data;
		    	   wt = new FileWriter("C:/iotest/sample_yyyy_mm_dd.txt",true); 
			             //��ü while �ȿ� x
		           while (true) {
		               data = br.readLine();
		               if (data == null)
		            	 break;
		               wt.write(data); 
		           }
		       System.out.println("���� �Ϸ�Ǿ����ϴ�.");
		       wt.close();
				} catch (Exception exc) {
		           System.out.println("ó���ϴ� ���� ������ �߻��߽��ϴ�.");
		       }  
	}
}
