package day3;

public class ForLab3 {

	public static void main(String[] args) {
		
		int x = (int)(Math.random()*10+1);
		int y = (int)(Math.random()*11+30);
		int z = 0;
					
		for( int n = x ; n <= y ; n++ ) 
			if(n % 2 ==0) 
				z += n;
			else
				z +=0;
		
		System.out.println(x + "부터 " + y + "까지의 짝수의 합 : " + z);
				
		
		
	}

}
