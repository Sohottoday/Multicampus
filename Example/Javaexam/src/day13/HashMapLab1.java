package day13;

import java.util.*;

public class HashMapLab1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cn;
		int pn;
		HashMap<String, Integer> contry = new HashMap<>();
		
		while(contry.size()<5) {
			System.out.print("�����̸��� �Է��ϼ��� : ");
			cn = sc.next();
			System.out.print("�α� ���� �Է��ϼ��� : ");
			pn = sc.nextInt();
			System.out.println();
			
			if(contry.containsKey(cn)) {
				System.out.println("����� "+cn+"�� �̹� ����Ǿ����ϴ�.");
			}else {
				System.out.println("����Ǿ����ϴ�.");
			}
			contry.put(cn, pn);
		}
		System.out.println("5���� ��� �ԷµǾ����ϴ�.");
		System.out.print("�Էµ� ������ : ");
		
		Iterator<String> tt = contry.keySet().iterator();
		while(tt.hasNext()) {
			String key = tt.next();
			int value = contry.get(key);
			System.out.printf("%s(%,d)", key, value);
			if(tt.hasNext()) {
				System.out.print(",");
			}else {
				break;
			}
		}
		sc.close();
	}
}
