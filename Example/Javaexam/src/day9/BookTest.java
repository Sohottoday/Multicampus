package day9;

class Book {
	String title;
	String author;
	private int price;

	Book() {
		/*title ="자바의 정석";
		author = "남궁 성";
		price = 30000;*/
		this("자바의 정석", "남궁 성", 30000);
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
		return "책 이름 : "+title+"책 저자 : "+author+"가격 : "+price;
	}
}

public class BookTest {

	public static void main(String[] args) {
		Book bn1 = new Book("자바의 정석","남궁성",-30000);
		bn1.setPrice(30000);
		System.out.println(bn1.getBookInfo());
	}
}
