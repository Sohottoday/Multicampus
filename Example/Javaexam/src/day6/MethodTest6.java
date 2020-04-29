package day6;

public class MethodTest6 {

	public static void main(String[] args) {
		System.out.println("main() 수행 시작");
		System.out.println(add(10, 100));
		System.out.println(add(10, 10, 30));
		System.out.println(add(new int[ ] {10, 20, 30, 40}));
		System.out.println(add(new int[ ] {1,2, 3, 4, 8, 5, 6, 9, 7}));
		System.out.println(add());
		System.out.println(add(10, 10, 30, 40, 50));
		System.out.println(add(11, 22, 33, 44, 55, 66, 77, 88, 99));
		System.out.println("main() 수행종료");
	}

	static int add(int p1, int p2) {
		return p1+p2;
	}
	static int add(int p1, int p2, int p3) {
		return p1+p2+p3;
	}
	/*static int add(int p[ ]) {
		int sum=0;
		for(int i=0 ; i< p.length ; i++)
				sum += p[i];
			return sum;
	}*/
	static int add(int ...p) {    //개수 상관없이 제한없이 모두 처리된다. //타입명 ...
		int sum=0;
		for(int i=0 ; i< p.length ; i++)
				sum += p[i];
			return sum;
	}
}
