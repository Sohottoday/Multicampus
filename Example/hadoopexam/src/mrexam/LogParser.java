package mrexam;

import org.apache.hadoop.io.Text;

public class LogParser {
	private String product;
	
	public LogParser(Text text){
		try{
			String[] columns=text.toString().split(" ");
			product=columns[1];
			
		}catch(Exception e){
			System.out.println("!!"+e.getMessage());
		}
	}

	public String getProduct() {
		return product;
	}
	
}
