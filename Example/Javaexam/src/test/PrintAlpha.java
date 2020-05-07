package test;
public class PrintAlpha {
	public static void main(String[] args) {
		char tt = 'A';
		
		for(int n=1 ; n <=5 ; n++) {
			for(int i=1 ; i<=n ; i++) {
				System.out.print(tt);
				tt++;
			} 
			System.out.println();
		}
	}
}
