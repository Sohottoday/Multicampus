package day13;
import java.util.*;

	class CreateList {
		public ArrayList<Integer> convertList(int array[]) {
			ArrayList<Integer> ary = new ArrayList<>();
			int size=array.length;
			
			for(int i = size-1 ; i>=0 ; i--) {
				ary.add(array[i]);
			}
			return ary;
		}
	}


public class ListTest {

	public static void main(String[] args) {
		ArrayList<Integer> ary= new ArrayList<Integer>();
			CreateList tt = new CreateList();
			int array[] = {3, 4, 2, 5, 2, 3, 6, 7, 5, 7, 9};
			Iterator<Integer> nn=null;
			
			ary=tt.convertList(array);
			nn=ary.iterator();
			
			while(nn.hasNext())
			{
				System.out.println(nn.next());
			}
	}
}
