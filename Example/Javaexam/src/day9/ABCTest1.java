package day9;

class A {
	A() {
		System.out.println("A 클래스를 객체 생성합니다.");
	}
}
	class B  extends A{
		B(int num) {
			System.out.println("B 클래스를 객체 생성합니다.");
		}
	}	
	class C  extends B{
			C() {
				super(100);
			System.out.println("C 클래스를 객체 생성합니다.");
			}
	}	

		
public class ABCTest1 {

	public static void main(String[] args) {
		new C();

	}

}
