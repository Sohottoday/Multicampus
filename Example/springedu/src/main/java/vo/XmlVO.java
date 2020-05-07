package vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement   //@XmlRootElement(name="unico") 태그가 unico로 변경됨 (루트 엘리먼트 지정)
public class XmlVO {
	private List<MyModel> list;
	public List<MyModel> getList() {
		return list;
	}
	public void setList(List<MyModel> list) {
		this.list = list;
	}	
}
