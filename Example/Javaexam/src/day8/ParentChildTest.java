package day8;

class Parent {	//java.lang.Object  <=따로 지정하지 않으면 java.lang.Object가 자동으로 부모로 설정된다
				//java에서 기본적으로 가져야 할 멤버를 구성해준다.
	int x = 1;
	int y = 2;
	public String toString() {
		return "Parent 클래스의 객체입니다";
	}
}
class Child extends Parent {
	int x = 10;
	void printInfo() {
		int x = 100;
		System.out.println(x);			// 100
		System.out.println(this.x);		// 10
		System.out.println(super.x);	// 1
		System.out.println(y);			// 2 (없으므로 부모한테 감)
		System.out.println(this.y);		// 2 (이것 역시 해당 클래스에 없으므로 부모한테 감)
		System.out.println(super.y);	// 2
		//System.out.println(z);
	}
	public String toString() {
		return "Child 클래스의 객체 입니당.";
	}
}



public class ParentChildTest {

	public static void main(String[] args) {
	
		Parent p = new Parent();
		System.out.println(p.toString()); //객체에 대한 정보를 하나의 문자열로 나타내는것
		System.out.println(p);	//쓰지 않아도 출력되는 이유는 부모 class의 멤버에 포함되어있기 때문이다.
		System.out.println("출력 1 "+p);
		Card c = new Card();
		System.out.println(c.toString());
		System.out.println("출력 2 "+p);
		java.util.Date d = new java.util.Date();		//
		System.out.println(d.toString());
		System.out.println("출력 3 "+d);
		Child ch = new Child();
		System.out.println("출력 4 "+ch);
		ch.printInfo(); //리턴값이 없는 애는 r-value용도로 사용할 수 없다.
	}

}
