package day7;

class Book {
	String title;
	String author;
	int price;

	Book() {
		/*title ="�ڹ��� ����";
		author = "���� ��";
		price = 30000;*/
		this("�ڹ��� ����", "���� ��", 30000);
	}
	
	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	String getBookInfo() {
		//System.out.printf("%s %s %,d\n", title,author,price); 
		return "å �̸� : "+title+"å ���� : "+author+"���� : "+price;
	}
}

public class BookTest {

	public static void main(String[] args) {
		Book bn1 = new Book();
		bn1.getBookInfo();
		Book bn2 = new Book("�ʹ���ƴ�", "������", 25000);
		bn2.getBookInfo();
		Book bn3 = new Book("���ü�����", "�ǰ���", 22000);
		bn3.getBookInfo();
		Book bn4 = new Book("���ṹ����", "�����", 20000);
		bn4.getBookInfo();
		Book bn5 = new Book("�����ؾ���", "������", 32000);
		bn5.getBookInfo();
	}
}
