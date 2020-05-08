package sparkexam;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDOperate4 {

	public static void main(String[] args) throws Exception {
		JavaSparkContext sc = SparkUtils.getSparkContext("test4");
		List<Integer> data = fillToN(100);
		JavaRDD<Integer> rdd = sc.parallelize(data);
		
		JavaRDD<Integer> rddSort = rdd.sortBy(f->f, false, 1);	//sortBy 함수 내용 확인하고 람다식을 이해할 것.
		System.out.println(rddSort.take(10));
		
		Integer result1 = rdd.first();
		System.out.println(result1);
		
		List<Integer> result2 = rdd.take(5);
		System.out.println(result2);	
		
		sc.stop();
	}

	public static ArrayList<Integer> fillToN(int n) {
		ArrayList<Integer> rst = new ArrayList<>();
		for (int i = 0; i < n; i++)
			rst.add(i);
		return rst;
	}
	
}