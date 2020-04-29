package day5;

public class LottoMachine1 {

	public static void main(String[] args) {
		int ln[ ] = new int [6];
		int n = 0;
		int i = 0;
		System.out.print("오늘의 로또 번호 - ");
		
		for(n=0 ; n<ln.length ; n++) {      //<--이번에도 이 중괄호를 안써서 인덱스 문제 발생함 멍청아 아오
			ln[n] = (int)(Math.random()*45)+1;
		
			for(i=0 ; i<n ; i++) {
				if(ln[n]==ln[i]) {
				n--;
				break;
				}
			}
		}
		for(n=0 ; n<ln.length ; n++) {
			if(n==ln.length-1)
			System.out.print(ln[n]);
			else
			System.out.print(ln[n] + ", ");
		}
		
		

	}

}
