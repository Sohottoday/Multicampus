package day9;

class Book {
	String title;
	String author;
	private int price;

	Book() {
		/*title ="�ڹ��� ����";
		author = "���� ��";
		price = 30000;*/
		this("�ڹ��� ����", "���� ��", 30000);
	}
	
	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		setPrice(price);
	}
	void setPrice(int price) {
		if(price<0)
			this.price = -price;
		else
		this.price = price;
	}
	
	String getBookInfo() {
		//System.out.printf("%s %s %,d\n", title,author,price); 
		return "å �̸� : "+title+"å ���� : "+author+"���� : "+price;
	}
}

public class BookTest {

	public static void main(String[] args) {
		Book bn1 = new Book("�ڹ��� ����","���ü�",-30000);
		bn1.setPrice(30000);
		System.out.println(bn1.getBookInfo());
	}
}
