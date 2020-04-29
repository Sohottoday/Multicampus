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
	System.out.println("전체 데이터의 합 : " + sum);
	
	int sumRow=0;
	//마지막 행의 데이터만 합산하여 sumRow에 저장
	for(int a = nums.length-1 ; a<nums.length ; a++)
		for(int b=0 ; b<nums[a].length ; b++)
			sumRow += nums[a][b];
	
	//해답 - for(int col=0; col<nums[2].length; col++)
	//		sumRow += nums[2][col];
	System.out.println("마지막 행 데이터의 합 : " + sumRow);
	

	//두번째 열의 데이터만 합산하여 sumCol에 저장
			
	//for(int row=0; row<nums.length; row++)
			//sumCol += nums[row][1];
			
			
	
	
	}
}


