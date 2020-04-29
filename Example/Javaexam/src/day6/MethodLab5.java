package day6;

public class MethodLab5 {

	public static void main(String[] args) {
			int r1[] = powerArray(2);
			int r2[] = powerArray(3);
			int r3[] = powerArray(4);
			
		for(int o=0 ; o<r1.length ; o++)
			if(o==r1.length-1)
				System.out.print(r1[o]);
			else
				System.out.print(r1[o]+", ");
		System.out.println();
		for(int v=0 ; v<r1.length ; v++)
			if(v==r1.length-1)
				System.out.print(r2[v]);
			else
				System.out.print(r2[v]+", ");
		System.out.println();
		for(int w=0 ; w<r1.length ; w++)
			if(w==r1.length-1)
				System.out.print(r3[w]);
			else
				System.out.print(r3[w]+", ");
	}
	
	static int[] powerArray(int dan) {	
		
		int wow [ ] = new int [10];
		int i = 0;
		for(i=0 ; i<wow.length ; i++)
			wow[i] = (i+1)*dan;
	
		return wow;
	}
}