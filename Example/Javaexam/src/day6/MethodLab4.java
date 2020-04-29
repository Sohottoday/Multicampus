package day6;

public class MethodLab4 {

	public static void main(String[] args) {
		System.out.println("가장 큰 값은 "+maxNumArray(new int[ ] {10, 20, 30})+"입니다.");
		System.out.println("가장 큰 값은 "+maxNumArray(new int[ ] {100, 500, 300, 200, 400})+"입니다.");
		System.out.println("가장 큰 값은 "+maxNumArray(new int[ ] {1, 10, 3, 4, 5, 8, 7, 6, 9, 2})+"입니다.");
	}

	static int maxNumArray(int... p) {
		int i = 0;
		for(int n=0 ; n<p.length ; n++) {
			if(i<p[n])
				i = p[n];
		}
		return i;
	}
}
