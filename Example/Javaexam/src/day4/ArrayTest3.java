package day4;

public class ArrayTest3 {

	public static void main(String[] args) {
		int a1[ ] = {3, 10, 2, 9, 5, 11, 12, 1};
		//a1 배열 변수에 할당된 배열의 요소 중 최대값
		int max;
		max = a1[0];
		for(int n = 1; n <a1.length; n++)
			if(a1[n] > max)
				max = a1[n];
		
		System.out.println("최대값 : " + max);
		
		//a1 배열 변수에 할당된 배열의 요소 중 최소값
		
		int min;
		min = a1[0];
		for(int i = 1; i <a1.length; i++)
			if(a1[i] < min)
				min = a1[i];
		
		System.out.println("최소값 : " + min);
		
		
		
		
		
	}

}
