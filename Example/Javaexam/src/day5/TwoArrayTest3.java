package day5;

public class TwoArrayTest3 {

	public static void main(String[] args) {
		
	int nums[][] = {
			{10, 20, 30, 40},
			{11, 21, 31, 41},
			{12, 22, 32, 42}
			};
	int sum = 0;
	int n = 0;
	int j = 0;
	for(n=0; n<nums.length ; n++) 
		for(j=0 ; j<nums[n].length; j++)
			sum += nums[n][j];
	System.out.println("��ü �������� �� : " + sum);
	
	int sumRow=0;
	//������ ���� �����͸� �ջ��Ͽ� sumRow�� ����
	for(int a = nums.length-1 ; a<nums.length ; a++)
		for(int b=0 ; b<nums[a].length ; b++)
			sumRow += nums[a][b];
	
	//�ش� - for(int col=0; col<nums[2].length; col++)
	//		sumRow += nums[2][col];
	System.out.println("������ �� �������� �� : " + sumRow);
	

	//�ι�° ���� �����͸� �ջ��Ͽ� sumCol�� ����
			
	//for(int row=0; row<nums.length; row++)
			//sumCol += nums[row][1];
			
			
	
	
	}
}


