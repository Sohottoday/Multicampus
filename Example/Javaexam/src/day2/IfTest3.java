package day2;

public class IfTest3 {

	public static void main(String[] args) {
		int month=(int)(Math.random()*12)+1;
		if(month == 12|| month == 1 || month ==2)
			System.out.println(month + " : �ܿ�");
		if(month == 3|| month == 4 || month ==5)
			System.out.println(month + " : ��");
		if(month == 6|| month == 7 || month ==8)
			System.out.println(month + " : ����");
		if(month == 9|| month == 10 || month ==11)
			System.out.println(month + " : ����");
				
		int month1=(int)(Math.random()*12)+1;
		if(month1 == 12|| month1 == 1 || month1 ==2)
			System.out.println(month1 + " : �ܿ�");
		else if(month1 == 3|| month1 == 4 || month1 ==5)
			System.out.println(month + " : ��");
		else if(month1 == 6|| month1 == 7 || month1 ==8)
			System.out.println(month + " : ����");
		else
			System.out.println(month1 + " : ����");	
			
			
		
	}

}
