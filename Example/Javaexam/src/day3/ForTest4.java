package day3;

public class ForTest4 {

	public static void main(String[] args) {
		//1부터 10까지의 합을 출력
		int sum=0;
		
		//for(int n=1 ; n<=10 ; n++)
		//	sum = sum + n;
		//System.out.println("sum = " + sum);
		
		
		//for 안에 프린트까지 포함시키면 매 과정을 모두 표현.
		for(int n=1 ; n<=10 ; n++) {
		sum = sum + n;
			System.out.println("sum = " + sum);
		}

	}

}
