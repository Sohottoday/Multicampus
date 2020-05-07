package day5;

public class TwoArrayLab2 {

	public static void main(String[] args) {
	
		char [][] apb = {
						{'B', 'C', 'A', 'A'},
						{'C', 'C', 'B', 'B'},
						{'D', 'A', 'A', 'D'}
		};
		
		int num[] = new int [4];
		int a,b = 0;
		for(a = 0 ; a<apb.length ; a++) {
			for(b=0 ; b<apb[a].length ; b++) {
			switch(apb[a][b]) {
			case 'A' :
				num[0]++;
				break;
			case 'B' :
				num[1]++;
				break;
			case 'C' :
				num[2]++;
				break;
			case 'D' :
				num[3]++;
			}
			}
		}
		char abpp = 'A';
		for(int n=0 ; n<num.length;n++) {
			System.out.println(abpp+"는 "+num[n]+"개 입니다.");
			abpp++;
		}
		
	}	

}
