package day13;
import java.util.*;


public class LottoMachine2 {

	public static void main(String[] args) {

		HashSet<Integer> ltn = new HashSet<>();
		
		while(ltn.size()<6) {
			ltn.add(new Random().nextInt(45)+1);
		}
		
		
		Iterator<Integer> tt =ltn.iterator();
		System.out.printf("오늘의 로또 번호 : [ %d", tt.next());
		while(tt.hasNext()) {
			Integer tr = tt.next();
			System.out.printf(", %d", tr);
		}
		
		/*for(Integer data : ltn) {
			System.out.printf(data+" ");
		}*/
		System.out.print("]");
	}
}
