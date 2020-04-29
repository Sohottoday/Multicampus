package day2;

public class ConditionOperLab {

	public static void main(String[] args) {
		int wow = (int)(Math.random()*5)+1;
		int a = 300;
		int b = 50;
		int c;
		
		if (wow == 1) 
		c = a+b;
		
		else if (wow == 2)
		c = a-b;
		
		else if (wow == 3)
		c = a * b;
		
		else if (wow == 4)
		c =  a / b;
		
		else
		c = a % b;
		
		System.out.println(c);
					
		
	}

}
