package sparkexam;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDOperate6 {

	public static void main(String[] args) throws Exception {
		JavaSparkContext sc = SparkUtils.getSparkContext("test6");

		doFilter(sc);

		sc.stop();
	}

	public static void doFilter(JavaSparkContext sc) {
		List<String> data = Arrays.asList("가나다", "abc", "ABC", "p111", "1234", "$@!%$");
		JavaRDD<String> rdd1 = sc.parallelize(data);
		
		JavaRDD<String> rdd2 = rdd1.filter(w -> w.matches("p\\d{3}"));
		System.out.println(rdd2.collect());
		
		rdd2 = rdd1.filter(w -> w.matches("p\\d{4}"));
		System.out.println(rdd2.collect());
	
		rdd2 = rdd1.filter(w -> w.matches("\\d+"));
		System.out.println(rdd2.collect());
		
		rdd2 = rdd1.filter(w -> w.matches("\\p{Upper}+"));
		System.out.println(rdd2.collect());
		
		rdd2 = rdd1.filter(w -> w.matches("\\p{Punct}+"));
		System.out.println(rdd2.collect());
		
		rdd2 = rdd1.filter(w -> w.matches("\\p{Alpha}+"));
		System.out.println(rdd2.collect());
		
		rdd2 = rdd1.filter(w -> w.matches("[가-힣]+"));
		System.out.println(rdd2.collect());
	}	
}