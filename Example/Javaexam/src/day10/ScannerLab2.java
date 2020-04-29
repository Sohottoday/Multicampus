package day10;

import java.util.Scanner;

public class ScannerLab2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wakeUp, getUp;
		int good=0;
		// 숫자와 연산자를 입력받아 처리하는 기능을 3번 반복하도록 코드 추가
		for(int n=1; n<=3; n++) {
			System.out.print("첫 번째 숫자를 입력하세요 : ");
			wakeUp = sc.nextInt();
			sc.nextLine();

			System.out.print("두 번째 숫자를 입력하세요 : ");
			getUp = sc.nextInt();
			sc.nextLine();

			System.out.print("연산자 (+,-,*,/)를 입력하세요 : ");
			String callMe = sc.next();

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
		}
		sc.close();
		System.out.println("사용이 종료되었습니다.");
	}
}
