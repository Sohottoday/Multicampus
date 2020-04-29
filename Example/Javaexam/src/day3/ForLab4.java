package day3;

public class ForLab4 {

	public static void main(String[] args) {
		
		int x = (int)(Math.random()*8+3);
		int y = (int)(Math.random()*3+1);
		
			if(y==1)
				for(int n=0; n <= x ; n++)
				System.out.print("*");
			else if(y==2)
				for(int n=0; n <= x ; n++)
				System.out.print("$");
			else
				for(int n=0; n<=x ; n++)
				System.out.print("#");
					

	}

}
