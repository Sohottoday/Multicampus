package day5;

public class ArrayTest1_1 {
	public static void main(String[] args) {
		int a1[ ] = new int[10];
		System.out.println(a1.length);
		int a2[ ] = {10, 20, 30};
		System.out.println(a2.length);
		
		for(int n = 0; n < a1.length ; n++)
			System.out.print(a1[n] + " ");
		System.out.println();
		
		for(int data : a1)
			System.out.print(data + " ");
		System.out.println();
		
		
		for(int n = 0; n < a2.length ; n++)
			System.out.print(a2[n] + " ");
		System.out.println();
				
		for(int data2 : a2)
			System.out.print(data2 + " ");

		for(int n = 0; n < a1.length ; n++)
			a1[n] = (n+1)*100;
		System.out.println();
		for(int n = 0; n < a1.length ; n++)
			System.out.print(a1[n] + " ");
		
		// a2[3] = 100;   <--a2�� 3���̹Ƿ� 0,1,2 ������ ����, ���� 3�� �������� �ʾƼ� ����
		
		
		
		
		
		
		
		
	}

}
