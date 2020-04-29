package day3;

public class ForTest9 {

	public static void main(String[] args) {
		final char DECO = '@'; //상수 : 값이 고정된 변수
		//final double PI = 3.14;
		
		for(int rowNum=1 ; rowNum <= 10 ; rowNum++) {
			for(int colNum=1 ; colNum <= rowNum ; colNum++)
				System.out.print(DECO);
			System.out.println();
			
			
		
		}
	}

}
