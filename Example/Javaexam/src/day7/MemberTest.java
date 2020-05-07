package day7;

public class MemberTest {

	public static void main(String[] args) {
	
		Member m1 = new Member();
		System.out.print("È¸¿ø 1 : ");
		m1.name="±è¸ÛÃ»";
		m1.account="Imstupid";
		m1.passwd="qwer1234";
		m1.birthyear=1991;
		System.out.println(m1.name+"("+m1.account+","+m1.passwd+","+m1.birthyear+")");
		
		Member m2 = new Member();
		System.out.print("È¸¿ø 2 : ");
		m2.name="¹Ú¸ô¶ó";
		m2.account="IDontKnow";
		m2.passwd="zxcv!@#$";
		m2.birthyear=1993;
		System.out.println(m2.name+"("+m2.account+","+m2.passwd+","+m2.birthyear+")");
		
		
		Member m3 = new Member();
		System.out.print("È¸¿ø 3 : ");
		m3.name="ÀÌ¾î·Æ";
		m3.account="SoHard";
		m3.passwd="qazwsxedc";
		m3.birthyear=1995;
		System.out.println(m3.name+"("+m3.account+","+m3.passwd+","+m3.birthyear+")");
	
	}
}
