package sparkexam;

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkLab3 {

	public static void main(String[] args) {
		JavaSparkContext sc = SparkUtils.getSparkContext("lab3");
		
		sparkProduct(sc);
		
		sc.stop();

	}
	
	public static void sparkProduct(JavaSparkContext sc) {
		JavaRDD<String> rdd1 = sc.textFile("hdfs://192.168.111.120:9000/edudata/tomcat_access_log.txt");
		JavaRDD<String> rdd2 = rdd1.flatMap((String line) -> Arrays.asList(line.split(" - - ")[1]).iterator()); 
		JavaRDD<String> rdd3 = rdd2.flatMap((String rightline) -> Arrays.asList(rightline.substring(13, 15)).iterator());
		
		JavaPairRDD<String, Integer> rdd4 = rdd3.mapToPair(word -> new Tuple2<String, Integer>(word, 1));
		
		
		
		JavaPairRDD<String, Integer> rdd5 = rdd4.reduceByKey((a, b) -> a + b);
		
		JavaPairRDD<Integer, String> rdd6 = rdd5.mapToPair(x -> x.swap());
		JavaPairRDD<Integer, String> rdd7 = rdd6.sortByKey(false);
		JavaPairRDD<String, Integer> rdd8 = rdd7.mapToPair(x -> x.swap());

		rdd8.foreach(tupledata -> System.out.println(tupledata._1+"시 "+tupledata._2+"번 요청"));
		System.out.println("제일 많이 요청된 시간은 "+rdd8.first()._1+"시 입니다");
		
		
	}
}
