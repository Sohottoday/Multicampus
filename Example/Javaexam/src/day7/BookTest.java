package day7;

class Book {
	String title;
	String author;
	int price;

	Book() {
		/*title ="자바의 정석";
		author = "남궁 성";
		price = 30000;*/
		this("자바의 정석", "남궁 성", 30000);
	}
	
	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	String getBookInfo() {
		//System.out.printf("%s %s %,d\n", title,author,price); 
		return "책 이름 : "+title+"책 저자 : "+author+"가격 : "+price;
	}
}

public class BookTest {

	public static void main(String[] args) {
		Book bn1 = new Book();
		bn1.getBookInfo();
		Book bn2 = new Book("너무어렵다", "누구지", 25000);
		bn2.getBookInfo();
		Book bn3 = new Book("오늘수요일", "피곤해", 22000);
		bn3.getBookInfo();
		Book bn4 = new Book("저녁뭐먹지", "배고파", 20000);
		bn4.getBookInfo();
		Book bn5 = new Book("이해해야지", "정신차", 32000);
		bn5.getBookInfo();
	}
}
