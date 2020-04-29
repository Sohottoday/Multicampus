package model.vo;

public class ProductVO {
	private int hanwoo1;
	private int hanwoo2;
	private int hanwoo3;
	
	public ProductVO() {
		this.hanwoo1=0;
		this.hanwoo2=0;
		this.hanwoo3=0;
	}
	public int getHanwoo1() {
		return hanwoo1;
	}
	public void setHanwoo1(int hanwoo1) {
		this.hanwoo1 += hanwoo1;
	}
	public int getHanwoo2() {
		return hanwoo2;
	}
	public void setHanwoo2(int hanwoo2) {
		this.hanwoo2 += hanwoo2;
	}
	public int getHanwoo3() {
		return hanwoo3;
	}
	public void setHanwoo3(int hanwoo3) {
		this.hanwoo3 += hanwoo3;
	}
	
	
}
