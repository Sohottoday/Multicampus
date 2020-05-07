package day9;

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
public class FriendTest {

	public static void main(String[] args) {
		
		Friend [ ] notFriend = new Friend[5];
		notFriend[0] = new Friend("±è¸ÛÃ»", "01044445555", "ImStupid@naver.com");
		notFriend[1] = new Friend("¹ÚÁ¹·Á", "01012345678", "VeryTired@naver.com");
		notFriend[2] = new Friend("ÀÌ¾î·Æ", "01015973548", "SoHard@naver.com");
		notFriend[3] = new Friend("±Ý¿äÀÏ", "01013131313", "TGIFriday@naver.com");
		notFriend[4] = new Friend("Á¤¹è°ö", "01098741234", "ImHungry@naver.com");
		
		for(Friend data : notFriend) {
			data.getInfo();
		System.out.println(data.getInfo());
		}
	}
}
