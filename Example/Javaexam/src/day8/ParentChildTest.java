package day8;

class Parent {	//java.lang.Object  <=���� �������� ������ java.lang.Object�� �ڵ����� �θ�� �����ȴ�
				//java���� �⺻������ ������ �� ����� �������ش�.
	int x = 1;
	int y = 2;
	public String toString() {
		return "Parent Ŭ������ ��ü�Դϴ�";
	}
}
class Child extends Parent {
	int x = 10;
	void printInfo() {
		int x = 100;
		System.out.println(x);			// 100
		System.out.println(this.x);		// 10
		System.out.println(super.x);	// 1
		System.out.println(y);			// 2 (�����Ƿ� �θ����� ��)
		System.out.println(this.y);		// 2 (�̰� ���� �ش� Ŭ������ �����Ƿ� �θ����� ��)
		System.out.println(super.y);	// 2
		//System.out.println(z);
	}
	public String toString() {
		return "Child Ŭ������ ��ü �Դϴ�.";
	}
}



public class ParentChildTest {

	public static void main(String[] args) {
	
		Parent p = new Parent();
		System.out.println(p.toString()); //��ü�� ���� ������ �ϳ��� ���ڿ��� ��Ÿ���°�
		System.out.println(p);	//���� �ʾƵ� ��µǴ� ������ �θ� class�� ����� ���ԵǾ��ֱ� �����̴�.
		System.out.println("��� 1 "+p);
		Card c = new Card();
		System.out.println(c.toString());
		System.out.println("��� 2 "+p);
		java.util.Date d = new java.util.Date();		//
		System.out.println(d.toString());
		System.out.println("��� 3 "+d);
		Child ch = new Child();
		System.out.println("��� 4 "+ch);
		ch.printInfo(); //���ϰ��� ���� �ִ� r-value�뵵�� ����� �� ����.
	}

}
