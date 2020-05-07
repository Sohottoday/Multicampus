package day11;
import java.util.Random;

	class DuplicateException extends Exception {
		DuplicateException() {
			super("중복된 로또 번호가 발생했습니다.");
		}
	}

	class LottoMachine {
		private int[] nums;
		public LottoMachine() {
			nums = new int[6];
		}
		public void createLottoNums() {
			for(int i=0 ; i<=5 ; i++)
				nums[i]= new Random().nextInt(20)+1;
		}
		public void checkLottoNums() throws DuplicateException {
			for(int i=0 ; i<=5 ; i++)
				for(int v=i ; v<5 ; v++) {
					if(nums[i]==nums[v+1]) {
						throw new DuplicateException();
						
					} 
				}
		}
		public int[] getNums() {
			return nums;
			
		}
	}

public class LottoGame {

	public static void main(String[] args)throws DuplicateException {
		LottoMachine lmc = new LottoMachine();
		
		try {
		lmc.createLottoNums();
		lmc.checkLottoNums();
		int[] nums = lmc.getNums();
		for(int i=0; i<nums.length ; i++) {
			if(i==nums.length-1) {
				System.out.print(nums[i]);
			} else {
				System.out.print(nums[i]+", ");
			}
		} 
		} catch (DuplicateException e) {
			System.out.println(e.getMessage());
			return;
		} finally {
		
		}
		
	}
}
