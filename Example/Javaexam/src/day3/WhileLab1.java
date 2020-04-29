package day3;

public class WhileLab1 {

	public static void main(String[] args) {
		
	int wow = (int)(Math.random()*6)+5;
	int n = 0;
		System.out.println("[for 결과]");
	for( n = 1 ; n <= wow ; n++) {
			System.out.print(n + " -> " + n*n);
			System.out.println();
	}
	
	n = 1;
		System.out.println("[while 결과]");
	while(n <= wow) {
			System.out.print(n + " -> " + n*n);
			System.out.println();
			n += 1;
	}
	
	}

}
