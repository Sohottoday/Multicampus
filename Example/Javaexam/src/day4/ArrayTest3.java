package day4;

public class ArrayTest3 {

	public static void main(String[] args) {
		int a1[ ] = {3, 10, 2, 9, 5, 11, 12, 1};
		//a1 �迭 ������ �Ҵ�� �迭�� ��� �� �ִ밪
		int max;
		max = a1[0];
		for(int n = 1; n <a1.length; n++)
			if(a1[n] > max)
				max = a1[n];
		
		System.out.println("�ִ밪 : " + max);
		
		//a1 �迭 ������ �Ҵ�� �迭�� ��� �� �ּҰ�
		
		int min;
		min = a1[0];
		for(int i = 1; i <a1.length; i++)
			if(a1[i] < min)
				min = a1[i];
		
		System.out.println("�ּҰ� : " + min);
		
		
		
		
		
	}

}
