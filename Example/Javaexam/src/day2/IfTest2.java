package day2;

public class IfTest2 {

	public static void main(String[] args) {
		System.out.println("문장1");
		System.out.println("문장2");
		
		if((int)(Math.random()*10) +1 > 5)
			System.out.println("문장3");
		else  {
			System.out.println("문장4");
			System.out.println("문장5");
		}
			System.out.println("문장6");
			
		int num=(int)(Math.random()*10)+1;
		if(num % 2 == 0)
			System.out.println(num + " : 짝수");
		else
			System.out.println(num + " : 홀수");
		

	}

}
