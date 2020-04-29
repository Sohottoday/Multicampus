package day5;

public class TwoArrayTest1 {

	public static void main(String[] args) {
		
		int[] a1 = new int[10];
		char a2[] = {'가', '나', '다'};
		double a3[] = new double[5];
		
		System.out.println(a1.length+":"+a2.length+":"+a3.length);
		System.out.println(a1+"-"+a1[0]);   //[I@15db9742-0  <-범위가 지정되지 않아 이러한 값이 나옴
		System.out.println(a3+"-"+a3[0]);	//[D@6d06d69c-0.0	<-
		
		int [][] a4 = new int[5][12];
		
		System.out.println(a4);
		System.out.println(a4.length);
		System.out.println(a4[0].length);  
		System.out.println(a4[1].length);
		System.out.println(a4[2].length);
		System.out.println(a4[3].length);
		System.out.println(a4[4].length);
		System.out.println(a4.length);
	}
}


