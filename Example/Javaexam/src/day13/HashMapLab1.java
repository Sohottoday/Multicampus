package day13;

import java.util.*;

public class HashMapLab1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cn;
		int pn;
		HashMap<String, Integer> contry = new HashMap<>();
		
		while(contry.size()<5) {
			System.out.print("나라이름을 입력하세요 : ");
			cn = sc.next();
			System.out.print("인구 수를 입력하세요 : ");
			pn = sc.nextInt();
			System.out.println();
			
			if(contry.containsKey(cn)) {
				System.out.println("나라명 "+cn+"는 이미 저장되었습니다.");
			}else {
				System.out.println("저장되었습니다.");
			}
			contry.put(cn, pn);
		}
		System.out.println("5개가 모두 입력되었습니다.");
		System.out.print("입력된 데이터 : ");
		
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
