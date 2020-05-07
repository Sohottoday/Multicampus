package day10;

import java.util.Scanner;

public class ScannerLab3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wakeUp, getUp;
		int good=0;
		String callMe;
		int n=1;
		// 숫자와 연산자를 입력받아 처리하는 기능을 사용자가 원할때 까지 반복하도록 코드 추가
		//결과 출력 사용자에게 계속 수행하겠는지에 대한 메세지를 출력하고
		//1을 입력하면 계속 수행하고 다른 숫자를 입력하면 종료
		while(n==1) {
			System.out.print("첫 번째 숫자를 입력하세요 : ");
			wakeUp = sc.nextInt();
			sc.nextLine();

			System.out.print("두 번째 숫자를 입력하세요 : ");
			getUp = sc.nextInt();
			sc.nextLine();

			System.out.print("연산자 (+,-,*,/)를 입력하세요 : ");
			callMe = sc.next();

			switch (callMe) {
			case "+":
				good = wakeUp + getUp;
				break;
			case "-":
				good = wakeUp - getUp;
				break;
			case "*":
				good = wakeUp * getUp;
				break;
			case "/":
				good = wakeUp / getUp;
				break;
			default:
				System.out.println("+,-,*,/를 입력하숑");
			}
			System.out.println(wakeUp + "와 " + getUp + "의 " + callMe + "연산 결과는 " + good + "입니다.");
			System.out.print("계속 수행하시겠습니까?(Y=1 | N = 그 외 숫자) : ");
			n = sc.nextInt();
		}
		sc.close();
		System.out.println("사용이 종료되었습니다.");
	}
}
