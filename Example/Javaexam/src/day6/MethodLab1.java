package day6;

public class MethodLab1 {

	public static void main(String[] args) {
		sleep('@',3);
		sleep('%',4);
		sleep('A',5);
		sleep('°¡',3);
	}

	static void sleep(char father, int mother) {
		for(int n = 0; n<mother ; n++)
			System.out.print(father);
			System.out.println();
	}
}