package day6;

public class MethodLab4 {

	public static void main(String[] args) {
		System.out.println("���� ū ���� "+maxNumArray(new int[ ] {10, 20, 30})+"�Դϴ�.");
		System.out.println("���� ū ���� "+maxNumArray(new int[ ] {100, 500, 300, 200, 400})+"�Դϴ�.");
		System.out.println("���� ū ���� "+maxNumArray(new int[ ] {1, 10, 3, 4, 5, 8, 7, 6, 9, 2})+"�Դϴ�.");
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
