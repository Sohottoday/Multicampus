package sparkexam;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;

public class RDDOperate3 {

	public static void main(String[] args) throws Exception {
		JavaSparkContext sc = SparkUtils.getSparkContext("test3");

		doForeach(sc);

		sc.stop();
	}

	public static void doForeach(JavaSparkContext sc) {
		List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		JavaRDD<Integer> rdd = sc.parallelize(data);
		// Java7
		rdd.foreach(new VoidFunction<Integer>() {	//foreach => void 즉, return값이 없으므로 action이다.
			@Override
			public void call(Integer t) throws Exception {	//각각의 RDD마다 리턴값 없이 수행하고 싶을때 사용하는 것이 foreach
				System.out.println("data : " + t);
			}
		});
		// Java8
		rdd.foreach((Integer t) -> System.out.println("data : " + t));
	}	

	
}