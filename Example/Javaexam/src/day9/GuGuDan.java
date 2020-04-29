package day9;
import day6.MethodLab3;

class Multiplication {
	private int dan;
	private int number;
	Multiplication() {}
	Multiplication(int dan) {
		this.dan = dan;
	}
	Multiplication(int dan, int number){
		this.dan = dan;
		this.number = number;
	}
	public void printPart() {
		if (number == 0) {	       
			for(int n=1; n <= 9; n++)
				System.out.print("\t"+dan + "*" + n+ "="+dan*n);
			System.out.println();
		} else {
			System.out.println(dan * number);
		}
	}
}

class GuGuDanExpr extends Multiplication {
	GuGuDanExpr(int dan) {
		super(dan);
	}
	GuGuDanExpr(int dan, int number) {
		super(dan,number);
	}
	static void printAll() {
		for(int i=1 ; i<=9 ; i++) {
			for(int j=1 ; j<=9 ; j++) {
			System.out.print(i+"*"+j+"="+(i*j)+"\t");
			}
			System.out.println();
		}
	}
}

public class GuGuDan {

	public static void main(String[] args) {
	
	int iDontKnow = MethodLab3.getRandom(20);
	int soHard=  MethodLab3.getRandom(20);
	
	if(iDontKnow<=9 && soHard<=9) {
		GuGuDanExpr tt = new GuGuDanExpr(iDontKnow,soHard);
		System.out.print(iDontKnow+" * "+soHard+" = ");
		tt.printPart();
	}else if (iDontKnow<=9 && soHard>=10) {
		GuGuDanExpr tt = new GuGuDanExpr(iDontKnow);
		System.out.print(iDontKnow+"´Ü :");
		tt.printPart();
	}else {
		GuGuDanExpr.printAll();
	}
	}
}
