package day10;

import java.util.Scanner;

public class ScannerLab2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wakeUp, getUp;
		int good=0;
		// ���ڿ� �����ڸ� �Է¹޾� ó���ϴ� ����� 3�� �ݺ��ϵ��� �ڵ� �߰�
		for(int n=1; n<=3; n++) {
			System.out.print("ù ��° ���ڸ� �Է��ϼ��� : ");
			wakeUp = sc.nextInt();
			sc.nextLine();

			System.out.print("�� ��° ���ڸ� �Է��ϼ��� : ");
			getUp = sc.nextInt();
			sc.nextLine();

			System.out.print("������ (+,-,*,/)�� �Է��ϼ��� : ");
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
				System.out.println("+,-,*,/�� �Է��ϼ�");
			}
			System.out.println(wakeUp + "�� " + getUp + "�� " + callMe + "���� ����� " + good + "�Դϴ�.");
		}
		sc.close();
		System.out.println("����� ����Ǿ����ϴ�.");
	}
}
