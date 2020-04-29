package day6;

public class MethodLab2 {

	public static void main(String[] args) {
		int potato = 0;
		int bulgogi = 0;
		for(int i = 1 ; i<=5 ; i++) {
		potato = (int)(Math.random()*30)+1;
		bulgogi = (int)(Math.random()*30)+1;
		pizza(potato,bulgogi);
		}

	}
	static int pizza(int pineapple, int pepperoni) {
		int n = 0;
		if(pineapple>pepperoni) {
			n = (pineapple-pepperoni);
		} else if(pepperoni>pineapple) {
			n = (pepperoni - pineapple);
		} else {
			n = 0;
		} System.out.println(pineapple+"와 "+pepperoni+"의 차는 "+n+"입니다.");
	return n;
	}
}