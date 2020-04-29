package day3;

public class ForTest8 {

	public static void main(String[] args) {
		 // 구구단 만들기 중첩for문으로 만들어보기.
		for(int dan=1 ; dan <= 9 ; dan++) {
			for(int num=1 ; num <= 9 ; num++)
				System.out.print(dan + "x" + num + "=" + dan*num + "\t");
			System.out.println();
		}
	}

}
