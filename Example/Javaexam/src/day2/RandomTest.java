package day2;

public class RandomTest {

	public static void main(String[] args) {
		int number = (int)Math.random();
		System.out.println(number);
		
		double rand1 = Math.random();
		System.out.println(rand1);
		double rand2 = rand1 * 100;
		System.out.println(rand2);
		int rand3 = (int)rand2;
		System.out.println(rand3);
		
		//rand1 을 가지고 1부터 6사이의 난수를 만드는 식을 구현하여
		//sinNum 변수에 담아서 출력하시오.
		//rand1을 가지고 1부터 45사이의 난수를 만드는 식을 구현하여
		//lottoNum 변수에 담아서 출력
		
		double band1 = Math.random();
		System.out.println(band1);
		double band2 = band1 * 6;
		System.out.println(band2);
		int band3 = (int)band2;
		int sixNum = band3 + 1;
		System.out.println(sixNum);
		
		int sinNum = (int)(rand1*6)+1;
		System.out.println(sinNum);
		
		int lottoNum = (int)(rand1*45)+1;
		System.out.println(lottoNum);
		
		//구현하려는 숫자를 곱한 뒤 +1을 해주면 됨.
		
		
		
		
		

	}

}
