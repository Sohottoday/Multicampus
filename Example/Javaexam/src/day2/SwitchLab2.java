package day2;

public class SwitchLab2 {

	public static void main(String[] args) {
		int wow = (int)(Math.random()*5)+1;
		int a = 300;
		int b = 50;
	
		switch(wow) {
		case 1 : System.out.println("결과값 : " + (a+b));
		break;
		case 2 : System.out.println("결과값 : " + (a-b));
		break;
		case 3 : System.out.println("결과값 : " + (a*b));
		break;
		case 4 : System.out.println("결과값 : " + (a/b));
		break;
		default : System.out.println("결과값 : " + (a%b));
		
				}
		
			}
}
