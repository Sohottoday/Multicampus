package test;

public class Goods {
	String prodId; 	
	String prodName; 
	int price; 
	char asYn;  
	
	Goods (String prodId, String prodName, int price) {
		this.prodId=prodId;
		this.prodName=prodName;
		this.price=price;
	}
	Goods (String prodId, String prodName, int price, char asYn) {
		this.prodId=prodId;
		this.prodName=prodName;
		this.price=price;
		this.asYn=asYn;
	}
	public void getGoodsInfo() {
		System.out.printf("상품 ID : %s, 상품명 : %s, 가격 : %,d원, AS가능여부 : ", prodId, prodName, price);
		if(asYn=='N') {
			System.out.print("불가");
		} else {
			System.out.print("가능");
		}
		System.out.println();
	}
}
