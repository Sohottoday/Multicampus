package day11;

	class TV {
		private String model;
		private int size;
		private int channel;
		
		public TV() {	}
		public TV(String model, int size, int channel) {
			this.model=model;
			this.size=size;
			this.channel=channel;
		}
		public void channelUp( ) {
			if(channel<=10)
				channel +=1;
			else
				channel = 1;
		}
		public void channelDown( ) {
			if(channel>1)
				channel -=1;
			else
				channel = 10;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int getChannel() {
			return channel;
		}
		public void setChannel(int channel) {
			this.channel = channel;
		}
	}
	class SaleTV extends TV {
		int price;
		
		public SaleTV() {	}
		public SaleTV(int price, String model, int size, int channel) {
			super(model,size,channel);
			this.price=price;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public void play() {
			System.out.println("판매 TV 채널 "+super.getChannel()+"번의 프로를 플레이 합니다.");
		}
		public void sale() {
			System.out.printf("%s 모델의 상품을 대여합니다. %,d을 지불해 주세요.\n", super.getModel(), this.getPrice());
			//System.out.println(super.getModel()+" 모델의 상품을 판매합니다. "+this.getPrice()+"을 지불해 주세요");
		}
		public String toString() {
			//return "판매상품정보 : 모델명("+super.getModel()+"), 가격("+this.getPrice()+"), 크기("+super.getSize()+")";
			return String.format("판매상품정보 : 모델명(%s), 가격(%,d), 크기(%d)", super.getModel(), this.getPrice(), super.getSize());
		}
	}
	class RentalTV extends TV implements Rentable {
		int price;
		
		RentalTV( ) {	}
		RentalTV(int price, String model, int size, int channel) {
			super(model,size,channel);
			this.price=price;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public void play() {
			System.out.println("대여 TV 채널 "+super.getChannel()+"번의 프로를 플레이 합니다.");
		}
		public void rent() {
			//System.out.println(super.getModel()+" 모델의 상품을 대여합니다. "+this.getPrice()+"을 지불해 주세요");
			System.out.printf("%s 모델의 상품을 대여합니다. %,d을 지불해 주세요.", super.getModel(), this.getPrice());
		}
		public String toString() {
			return String.format("판매상품정보 : 모델명(%s), 가격(%,d), 크기(%d)", super.getModel(), this.getPrice(), super.getSize());
		}
	}
	interface Rentable {
		public abstract void rent();
	}
public class TVtest {

	public static void main(String[] args) {
		SaleTV st= new SaleTV(300000, "SALETV-1", 40, 1);
		RentalTV rt = new RentalTV(100000, "RENTALTV-10", 42, 1);
		
		st.channelUp();
		st.channelUp();
		rt.channelDown();
		rt.channelDown();
		rt.channelDown();
		printAllTV(st);
		printAllTV(rt);
		printRentalTV(rt);
	}	
	static void printAllTV(TV tv) {
		System.out.println(tv.toString());
		if(tv instanceof SaleTV) {
			((SaleTV)tv).play();
			((SaleTV)tv).sale();
		} else {
			((RentalTV)tv).play();
		}
	}
	static void printRentalTV(Rentable tv) {
		((RentalTV)tv).rent();
	}
}
