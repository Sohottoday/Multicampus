package day4;

public class ArrayLab2 {

	public static void main(String[] args) {
		
		int ten [ ] = new int [10];
		int n = 0;
		for(n = 0 ; n < ten.length ; n++)
			ten[n] = (int)(Math.random()*17+4);
		System.out.print("모든 원소의 값 : ");
			for(n = 0 ; n < ten.length ; n++)
				if(n==ten.length-1)
					System.out.print(ten[n]);
				else
					System.out.print(ten[n] + ",");
		
		System.out.println();
		int sum = 0;
		System.out.print("모든 원소의 합 : ");
			for(n = 0 ; n < ten.length ; n++)
				sum += ten[n];
				System.out.print(sum);
				
		
		
	}

}
