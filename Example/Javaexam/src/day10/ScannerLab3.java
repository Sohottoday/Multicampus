package day10;

import java.util.Scanner;

public class ScannerLab3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int wakeUp, getUp;
		int good=0;
		String callMe;
		int n=1;
		// ���ڿ� �����ڸ� �Է¹޾� ó���ϴ� ����� ����ڰ� ���Ҷ� ���� �ݺ��ϵ��� �ڵ� �߰�
		//��� ��� ����ڿ��� ��� �����ϰڴ����� ���� �޼����� ����ϰ�
		//1�� �Է��ϸ� ��� �����ϰ� �ٸ� ���ڸ� �Է��ϸ� ����
		while(n==1) {
			System.out.print("ù ��° ���ڸ� �Է��ϼ��� : ");
			wakeUp = sc.nextInt();
			sc.nextLine();

			System.out.print("�� ��° ���ڸ� �Է��ϼ��� : ");
			getUp = sc.nextInt();
			sc.nextLine();

			System.out.print("������ (+,-,*,/)�� �Է��ϼ��� : ");
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
				System.out.println("+,-,*,/�� �Է��ϼ�");
			}
			System.out.println(wakeUp + "�� " + getUp + "�� " + callMe + "���� ����� " + good + "�Դϴ�.");
			System.out.print("��� �����Ͻðڽ��ϱ�?(Y=1 | N = �� �� ����) : ");
			n = sc.nextInt();
		}
		sc.close();
		System.out.println("����� ����Ǿ����ϴ�.");
	}
}
