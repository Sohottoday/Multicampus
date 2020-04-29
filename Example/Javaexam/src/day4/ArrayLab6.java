package day4;

public class ArrayLab6 {

	public static void main(String[] args) {
		char vava [] = {'J', 'a', 'v', 'a'};
		
		for(int n = 0 ; n < vava.length ; n++)
			if(vava[n] <= 96) {
				System.out.print((char)(vava[n]+32));
			} else {
				System.out.print("," + (char)(vava[n]-32));
			}
			

	}

}
