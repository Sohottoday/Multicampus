package day5;

public class TwoArrayLab1 {

	public static void main(String[] args) {
		
		int lab1 [][] = new int [4][4];
		
		int a,b = 0;
		int num = 10;
		for(a=0 ; a<lab1.length ; a++) {
			for(b=0 ; b<lab1[a].length ; b++) {
				lab1[a][b] = num;
				num +=2;
			}
		}
		System.out.println("1�� 1���� ������ : " + lab1[0][0]);
		System.out.println("3�� 4���� ������ :" + lab1[2][3]);
		System.out.println("���� ���� :" + a);
		System.out.println("���� ���� :" + b);
		
		System.out.print("3���� �����͵� :");
		int i = 0;
		int j = 0;
		for(i = 0 ; i<lab1[2].length ; i++) {
			System.out.print(lab1[2][i] + " ");
		}
		System.out.println();
		System.out.print("2���� �����͵� :");
		for(j = 0 ; j<lab1.length ; j++) {
			System.out.print(lab1[j][1] + " ");
		}	
		System.out.println();
		
		int v = 0;
		int w = 0;
		System.out.print("���� �밢�� �����͵� : ");
		for(v=0 ; v<lab1.length ; v++) {
			for(w=0 ; w<lab1.length ; w++) {
				if(v==w)
					System.out.print(lab1[v][w] + " ");
			}
		}
		System.out.println();
		
		int o = 0;
		int p = 0;
		System.out.print("������ �밢�� �����͵� :");
		for(o=0 ; o<lab1.length ; o++) {
			for(p=0 ; p<lab1.length ; p++) {
				if((o+p)==(a-1))          //0���� �����ΰ� ��� �����ϰ� �ٺ�ó�� 1�� 1�� �����̶�� ����� �Ѥ�
				System.out.print(lab1[o][p] + " ");	
			}
		}
		
		
		   
		

	}

}
