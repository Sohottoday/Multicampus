package vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement	//클래스 이름에서 첫글자를 소문자로 바꾼 이름으로 루트 엘리먼트를 지정한다.
public class MyModel {
	private String flowerName;
	private int num;
	private String id;
	
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "MyModel [flowerName=" + flowerName + ", num=" + num + ", id=" + id + "]";
	}	
	
}
