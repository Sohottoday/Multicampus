package day5;

public class ArrayTest2_1 {

	public static void main(String[] args) {
		int a1[ ] = new int[5];
		a1[0] = 33;
		a1[1] = 20;
		a1[2] = 15;
		a1[3] = 40;
		a1[4] = 7;
		System.out.println(a1[0]);
		System.out.println(a1[a1.length-1]);
		
		for(int n = a1.length-1 ; n >=0 ; n--)
			System.out.print(a1[n] + " ");           //a1의 배열 역순으로 나열
		System.out.println();
		
		for(int i = 0; i < a1.length ; i +=2)
			System.out.print(a1[i] + " ");            //a1의 1 3 5번째 표현
		System.out.println();
		
		//for each문으로 바꿀것이 없다 . 앞의 프린트는 역순이고 뒤의 프린트는 건너뛰는 방식이다.
		
		
		
		
		
		
		
		
	}

}
