package day7;

class Product {
	String name;
	int balance;
	int price;

	Product() {
		this("��ũ����",5,10000);
	}
	Product(String name, int balance, int price) {
		this.name = name;
		this.balance=balance;
		this.price=price;
	}
	String getName() {
	//void getName() {
		return name;
		//System.out.print("��ǰ�̸� :"+name+" |");
	}
	int getBalance() {
	//void getBalance() {
		//System.out.print("��� :"+balance+" |");
		return balance;
	}
	int getPrice() {
	//void getPrice() {
		//System.out.printf("%s %,d %s","�ݾ� :",price, "��");
		return price;
	}
}
	//�������� �䱸�ϴ� �κ��� �� Ȯ���ϰ� �ؾ��Ѵ�.
public class ProductTest {

	public static void main(String[] args) {
	
	Product[] p = new Product[5];
	p[0] = new Product("ġŲ����",3,9000);
	p[1] = new Product("��ġ���",5,15000);
	p[2] = new Product("���ô�",6,30000);
	p[3] = new Product("����",7,49000);
	p[4] = new Product("����",16,16000);
	
	for(int i=0 ; i<p.length ; i++) {
		System.out.printf("%s %d %,d ��\n", p[i].getName(),p[i].getBalance(),p[i].getPrice());
	
	}
	for(Product data : p)
		System.out.printf("%s %d %,d ��\n", data.getName(),data.getBalance(),data.getPrice());
	
	}
}

