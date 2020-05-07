package day13;

import java.util.LinkedList;

class Person {
	private String name;
	Person(String name) {
		this.name = name;
	}
	public String getInfo() {
		return name;
	}
}
class Friend extends Person {
	String phoneNum;
	String email;
	
	Friend(String name, String phoneNum, String email) {
		super(name);
		this.phoneNum=phoneNum;
		this.email=email;
	}
	public String getInfo() {
		return super.getInfo()+" " + phoneNum+" " + email;
	}
}
public class FriendTestLinkedList {

	public static void main(String[] args) {
		
		LinkedList<Friend> list=new LinkedList<>();
		
		list.add(new Friend("±è¸ÛÃ»", "01044445555", "ImStupid@naver.com"));
		list.add(new Friend("¹ÚÁ¹·Á", "01012345678", "VeryTired@naver.com"));
		list.add(new Friend("ÀÌ¾î·Æ", "01015973548", "SoHard@naver.com"));
		list.add(new Friend("±Ý¿äÀÏ", "01013131313", "TGIFriday@naver.com"));
		list.add(new Friend("Á¤¹è°ö", "01098741234", "ImHungry@naver.com"));
		
		for(Friend data : list) {
			System.out.println(data.getInfo());
		}
	}
}
