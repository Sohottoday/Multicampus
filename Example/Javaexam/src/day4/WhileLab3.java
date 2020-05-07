package day4;

public class WhileLab3 {

	public static void main(String[] args) {
		int a = 0;
		char b = 0;
		int cnt = 0;
		
		while(true) {
			a = (int)(Math.random()*31);
			b = (char)(a + 64);
			
			if(a ==0 || a>=27) {
				break;
			} else {
				System.out.println(b+"("+a+")");
			cnt++;
			}
		}
			System.out.println("수행횟수는 " + cnt + "번입니다.");
		
	}

}


