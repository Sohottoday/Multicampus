package test;
public class GoodsTest {
	public static void main(String[] args) {

		Goods gs = new Goods("PRD-0001", "듀크컴퓨터", 10000,'N');
		Goods ys = new Goods("PRD-0002", "턱시컴퓨터", 20000);
		
		gs.getGoodsInfo();
		ys.getGoodsInfo();
	}
}
