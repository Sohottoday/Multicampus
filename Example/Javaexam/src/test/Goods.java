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
		System.out.printf("��ǰ ID : %s, ��ǰ�� : %s, ���� : %,d��, AS���ɿ��� : ", prodId, prodName, price);
		if(asYn=='N') {
			System.out.print("�Ұ�");
		} else {
			System.out.print("����");
		}
		System.out.println();
	}
}
