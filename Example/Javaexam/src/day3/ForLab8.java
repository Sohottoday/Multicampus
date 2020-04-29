package day3;

public class ForLab8 {

	public static void main(String[] args) {
		
		char ap = 'A';
		
		for(int n = 1 ; n<=5 ; n++) {
			for(int i = 1 ; i <=n ; i++)
				System.out.print(ap++);
			System.out.println();
		}

	}

}
