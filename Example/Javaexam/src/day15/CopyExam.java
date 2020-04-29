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
			             //객체 while 안에 x
		           while (true) {
		               data = br.readLine();
		               if (data == null)
		            	 break;
		               wt.write(data); 
		           }
		       System.out.println("저장 완료되었습니다.");
		       wt.close();
				} catch (Exception exc) {
		           System.out.println("처리하는 동안 오류가 발생했습니다.");
		       }  
	}
}
