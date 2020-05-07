package day6;

public class MethodTest3 {

	public static void main(String[] args) {
		System.out.println("main() 수행 시작");
		printMyName(1,'#');
		System.out.println("------------------");
		printMyName(3,'*');
		System.out.println("------------------");
		printMyName(5,'@');
		System.out.println("------------------");
		// printMyName(1); ->오류 뜬다 = 문자도 추가된 정의인데 왜 숫자만 넣느냐(갯수 타입 일치해야함)
		System.out.println("main() 수행종료");
	}

	static void printMyName(int num, char deco) {
		for(int i = 1 ; i <=num ; i++)
			System.out.println(deco+"유니코"+deco);
	}
}
