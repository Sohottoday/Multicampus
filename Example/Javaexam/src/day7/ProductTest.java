package day7;

class Product {
	String name;
	int balance;
	int price;

	Product() {
		this("듀크인형",5,10000);
	}
	Product(String name, int balance, int price) {
		this.name = name;
		this.balance=balance;
		this.price=price;
	}
	String getName() {
	//void getName() {
		return name;
		//System.out.print("상품이름 :"+name+" |");
	}
	int getBalance() {
	//void getBalance() {
		//System.out.print("재고량 :"+balance+" |");
		return balance;
	}
	int getPrice() {
	//void getPrice() {
		//System.out.printf("%s %,d %s","금액 :",price, "원");
		return price;
	}
}
	//문제에서 요구하는 부분을 더 확실하게 해야한다.
public class ProductTest {

	public static void main(String[] args) {
	
	Product[] p = new Product[5];
	p[0] = new Product("치킨마요",3,9000);
	p[1] = new Product("참치비빔",5,15000);
	p[2] = new Product("도련님",6,30000);
	p[3] = new Product("백합",7,49000);
	p[4] = new Product("몰라",16,16000);
	
	for(int i=0 ; i<p.length ; i++) {
		System.out.printf("%s %d %,d 원\n", p[i].getName(),p[i].getBalance(),p[i].getPrice());
	
	}
	for(Product data : p)
		System.out.printf("%s %d %,d 원\n", data.getName(),data.getBalance(),data.getPrice());
	
	}
}

