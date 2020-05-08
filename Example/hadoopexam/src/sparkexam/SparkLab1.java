package sparkexam;

import java.util.Arrays;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class SparkLab1 {

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
		JavaPairRDD<String, Integer> rdd5 = rdd4.sortByKey();
		//System.out.println(rdd5.collect());
		rdd5.foreach(tupledata -> System.out.println("("+tupledata._1+","+tupledata._2+")"));
		
	}
}
