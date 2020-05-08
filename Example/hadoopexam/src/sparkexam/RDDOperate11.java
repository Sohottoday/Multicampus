package sparkexam;

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDOperate11 {

	public static void main(String[] args) throws Exception {
		JavaSparkContext sc = SparkUtils.getSparkContext("test11");

		doZip(sc);

		sc.stop();
	}

	public static void doZip(JavaSparkContext sc) {
		JavaRDD<String> rdd1 = sc.parallelize(Arrays.asList("a", "b", "c"));
		JavaRDD<Integer> rdd2 = sc.parallelize(Arrays.asList(1, 2, 3));
		JavaPairRDD<String, Integer> result = rdd1.zip(rdd2);
		System.out.println(result.collect());
		
		JavaRDD<String> rdd3 = sc.parallelize(Arrays.asList("a", "b", "c"));
		JavaRDD<String> rdd4 = sc.parallelize(Arrays.asList("a", "e", "f"));
		JavaRDD<String> result2 = rdd3.union(rdd4);	//여러개의 rdd를 결합하고 싶을때 사용
		System.out.println(result2.collect());
		
		JavaRDD<String> result3 = result2.distinct();	//중복되는 값 하나만 남기고 싶다고 한다면 distinct라는 메서드 사용.
		System.out.println(result3.collect());
	}

}