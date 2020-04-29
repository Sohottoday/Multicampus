package day3;

public class ForLab6 {

	public static void main(String[] args) {
		
		final char WOW = '&';
		int ran = (int)(Math.random()*6+5);
		
		for(int n = 1 ; n<=ran ; n++) {
			for(int i = 1 ; i <= n ; i++)
				System.out.print(WOW);
			System.out.println();
		
		}
	}

}
