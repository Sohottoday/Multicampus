package test;
public class GoodsTest {
	public static void main(String[] args) {

		Goods gs = new Goods("PRD-0001", "��ũ��ǻ��", 10000,'N');
		Goods ys = new Goods("PRD-0002", "�ν���ǻ��", 20000);
		
		gs.getGoodsInfo();
		ys.getGoodsInfo();
	}
}
