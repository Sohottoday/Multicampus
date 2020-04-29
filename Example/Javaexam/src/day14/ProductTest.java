package day14;
import java.util.*;

	class Product {
		private String productID;
		private String productName;
		private String productPrice;
		
		Product(String productID, String productName, String productPrice) {
			this.productID=productID;
			this.productName=productName;
			this.productPrice=productPrice;
		}
		
		public String getProductID() {
			return productID;
		}
		public void setProductID(String productID) {
			this.productID = productID;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(String productPrice) {
			this.productPrice = productPrice;
		}

		public boolean equals(Object o) {
			boolean result = false;
			if(o != null && o instanceof Product) {
				Product pd=(Product)o;
				if(productID.equals(pd.productID)) {
					result=true;
				}
			}
			return result;
		}
		public int hashCode() {
			return productID.hashCode() ;
		}
		public String toString() {
			return productID + "\t" + productName + "\t" + productPrice + "\n";
		}	//String.format ������ �̻ڰ� ���ð���....����
	}

public class ProductTest {

	public static void main(String[] args) {
	
		HashSet<Product> wow = new HashSet<Product>();
		Product [] tt = new Product[4];	//��ü�迭 �ڲ� �����
		
		tt[0] = new Product("p100", "TV", "20000");
		tt[1] = new Product("p200", "Computer", "10000");
		tt[2] = new Product("p100", "MP3", "700");
		tt[3] = new Product("p300", "Audio", "1000");
		
		for(int n=0 ; n<=3 ; n++) {
			if(wow.add(tt[n]))
				System.out.println("���������� ����Ǿ����ϴ�.");
			else
				System.out.println("������ ID�� ��ǰ�� �̹� ����Ǿ� �ֽ��ϴ�.");
		}
		System.out.println();
		System.out.println("��ǰID" + "\t" + "��ǰ��" + "\t" + "����");
		System.out.println("-----------------------------------");
				
		for(Product data:wow)
			System.out.println(data);
		
		
		
		
		
		
		

	}

}
