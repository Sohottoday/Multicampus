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
		
		//rand1 �� ������ 1���� 6������ ������ ����� ���� �����Ͽ�
		//sinNum ������ ��Ƽ� ����Ͻÿ�.
		//rand1�� ������ 1���� 45������ ������ ����� ���� �����Ͽ�
		//lottoNum ������ ��Ƽ� ���
		
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
		
		//�����Ϸ��� ���ڸ� ���� �� +1�� ���ָ� ��.
		
		
		
		
		

	}

}
