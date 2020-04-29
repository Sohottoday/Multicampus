package day8;

import java.util.Scanner;

public class ScannerLab1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자를 입력하세요 : ");
		int wakeUp = sc.nextInt();
		sc.nextLine();
		
		System.out.print("두 번째 숫자를 입력하세요 : ");
		int getUp = sc.nextInt();
		sc.nextLine();
		
		System.out.print("연산자 (+,-,*,/)를 입력하세요 : ");
		String callMe = sc.next();
		
		int good=0;    // 초기화를 안해줘서 결과가 자꾸 에러가 남 -> 이것때문에 다른 부분은 일찌기 끝냈으나 늦게 제출하게됨
		switch(callMe) {
			case "+" :  
				good=wakeUp+getUp;
				break;
			 case "-" :  
				good=wakeUp-getUp;
				break;
			 case "*" :  
				good=wakeUp*getUp;
				break;
			 case "/" :  
				good=wakeUp/getUp;
				break;
			 default :
				System.out.println("+,-,*,/를 입력하숑");
				sc.close();
				return;		//메인 메서드 안에서 리턴문 사용시 프로그램을 끝내겠다는 의미
		}	
		System.out.println(wakeUp+"와 "+getUp+"의 "+callMe+"연산 결과는 "+good+"입니다.");
		sc.close();
	}
}
