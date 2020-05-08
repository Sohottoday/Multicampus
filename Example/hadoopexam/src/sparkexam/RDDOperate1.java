package sparkexam;

import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDOperate1 {

	public static void main(String[] args) throws Exception {

		JavaSparkContext sc = SparkUtils.getSparkContext("test1");
		JavaRDD<String> rdd = sc.textFile("hdfs://192.168.111.120:9000/edudata/fruits.txt");
		
		System.out.println(rdd.first());	//첫번째 열만 읽음
		
		System.out.println(rdd.take(3));	//3개 행이 리스트 객체로 리턴
		
		System.out.println(rdd.collect());	//collect : 전체를 리스트 객체로 리턴 
		
		List<String> list = rdd.collect();
		for (String v : list) {
			System.out.println(v);
		}
		System.out.println(rdd.count());
		
		sc.stop();
	}
}