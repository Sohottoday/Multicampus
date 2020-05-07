package day4;

public class ArrayLab4 {

	public static void main(String[] args) {
		int ran [ ] = new int [10];
		int n = 0;
		
		for(n = 0 ; n < ran.length ; n++) 
			ran[n] = (int)(Math.random()*26+1);
			
			for(n = 0 ; n < ran.length ; n++)
				if(n==ran.length-1)
					System.out.print(ran[n]);
				else
					System.out.print(ran[n]+",");
			System.out.println();
			
		char ten [ ] = new char [10];
		int i = 0;	
		
		for(i = 0 ; i < ten.length ; i++)
			ten[i] = (char)(ran[i]+64);  //인덱스가 벗어남ran[n]이 아니라 ran[i]를 써야함 n써서 계속고민함 개멍청
			
			for(i = 0 ; i < ten.length ; i++)
				if(i==ten.length-1)
					System.out.print((char)ten[i]);
				else
					System.out.print((char)ten[i]+",");
		
		

	}

}
