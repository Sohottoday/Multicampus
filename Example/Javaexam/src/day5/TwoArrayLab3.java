package day5;

public class TwoArrayLab3 {

	public static void main(String[] args) {
		
		int manyAry [][] = {
							{10, 20, 30, 40, 50},
							{5, 10, 15},
							{11,22, 33, 44},
							{9, 8, 7, 6, 5, 4, 3, 2, 1}
							};
		
		int a,b = 0;
		int sum = 0;
		for(a=0 ; a<manyAry.length ; a++) {
			sum = 0;
			for(b=0 ; b<manyAry[a].length ; b++) {
				if(a==0) {
					sum += manyAry[0][b];
				}else if(a==1) {
					sum += manyAry[1][b];
				}else if(a==2) {
					sum += manyAry[2][b];
				}else {
					sum += manyAry[3][b];
				}
			}
				System.out.print((a+1)+"행의 합은 "+ sum + "입니다.");	
				System.out.println();
		}

		
			

	}

}
