package sparkexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDOperate5 {

	public static void main(String[] args) throws Exception {
		JavaSparkContext sc = SparkUtils.getSparkContext("test5");
		
		doMapAndFlatMap(sc);

		sc.stop();
	}

	public static void doMapAndFlatMap(JavaSparkContext sc) {
		List<String> data = new ArrayList<>();
		data.add("apple,orange");
		data.add("grape,apple,mango");
		data.add("blueberry,tomato,orange");
		JavaRDD<String> rdd1 = sc.parallelize(data);

		JavaRDD<String[]> rdd2 = rdd1.map((String t) -> t.split(","));	//split 해버려서 배열이 되버림.
		JavaRDD<String> rdd3 = rdd1.flatMap((String t) -> Arrays.asList(t.split(",")).iterator());	//iterator가 뭐였지...
		//flatmap 역시 map처럼 3번 호출됨... ?ㅇ?	//flatmap은 하나의 elemenet로 묶어버림. (
		
		System.out.println(rdd2.collect());
		System.out.println(rdd3.collect());
		
		JavaRDD<Integer> rdd4 = rdd1.map((String t) -> t.length());
		System.out.println(rdd4.collect());
		
	}
	
}