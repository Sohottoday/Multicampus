package day4;

public class ArrayLab1 {

	public static void main(String[] args) {
		
		int ary[ ] = new int [10];
		
		for(int n = 0 ; n < ary.length ; n++)
			System.out.print(ary[n] + " ");
		System.out.println();
		
		for(int n = 0 ; n < ary.length; n++)
			ary[n] = n*10 + 10;
		
			for(int n = 0 ; n < ary.length ; n++)
				System.out.print(ary[n] + " ");
			System.out.println();
		
			for(int n = ary.length-1 ; n >= 0 ; n--)
				System.out.print(ary[n] + " ");
			System.out.println();
		
			for(int n = 1 ; n < ary.length ; n+=2)
				System.out.print(ary[n] + " ");
	}
}
