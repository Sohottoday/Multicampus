package day8;

import java.util.Scanner;

public class ScannerLab1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù ��° ���ڸ� �Է��ϼ��� : ");
		int wakeUp = sc.nextInt();
		sc.nextLine();
		
		System.out.print("�� ��° ���ڸ� �Է��ϼ��� : ");
		int getUp = sc.nextInt();
		sc.nextLine();
		
		System.out.print("������ (+,-,*,/)�� �Է��ϼ��� : ");
		String callMe = sc.next();
		
		int good=0;    // �ʱ�ȭ�� �����༭ ����� �ڲ� ������ �� -> �̰Ͷ����� �ٸ� �κ��� ����� �������� �ʰ� �����ϰԵ�
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
				System.out.println("+,-,*,/�� �Է��ϼ�");
				sc.close();
				return;		//���� �޼��� �ȿ��� ���Ϲ� ���� ���α׷��� �����ڴٴ� �ǹ�
		}	
		System.out.println(wakeUp+"�� "+getUp+"�� "+callMe+"���� ����� "+good+"�Դϴ�.");
		sc.close();
	}
}
