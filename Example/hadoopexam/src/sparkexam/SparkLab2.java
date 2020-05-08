package sparkexam;

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkLab2 {

	public static void main(String[] args) {
		JavaSparkContext sc = SparkUtils.getSparkContext("lab1");
		
		sparkProduct(sc);
		
		sc.stop();

	}
	
	public static void sparkProduct(JavaSparkContext sc) {
		JavaRDD<String> rdd1 = sc.textFile("hdfs://192.168.111.120:9000/edudata/product_click.log");
		JavaRDD<String> rdd2 = rdd1.flatMap((String line) -> Arrays.asList(line.split(" ")[1]).iterator()); 
		JavaPairRDD<String, Integer> rdd3 = rdd2.mapToPair(word -> new Tuple2<String, Integer>(word, 1));
		JavaPairRDD<String, Integer> rdd4 = rdd3.reduceByKey((a, b) -> a + b);
		
		JavaPairRDD<Integer, String> rdd5 = rdd4.mapToPair(x -> x.swap());
		JavaPairRDD<Integer, String> rdd6 = rdd5.sortByKey(false);
		JavaPairRDD<String, Integer> rdd7 = rdd6.mapToPair(x -> x.swap());

		rdd7.foreach(tupledata -> System.out.println("("+tupledata._1+","+tupledata._2+")"));
		
	}
}
