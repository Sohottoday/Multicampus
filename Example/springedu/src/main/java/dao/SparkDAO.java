package dao;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.stereotype.Repository;

import scala.Tuple2;

@Repository
public class SparkDAO {
	public String sparkProc() {
		String result = "";
		SparkConf conf = new SparkConf().setAppName("aaa").setMaster("local").set("spark.driver.allowMultipleContexts", "true");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> rdd1 = sc.textFile("hdfs://192.168.111.120:9000/edudata/fruits.txt");

		JavaRDD<String> rdd2 = rdd1.flatMap((String line) -> Arrays.asList(line.split("[\\s]+")).iterator());

		JavaRDD<String> rdd3 = rdd2.filter(word -> word.length() > 4);

		JavaPairRDD<String, Integer> rdd4 = rdd3.mapToPair(word -> new Tuple2<String, Integer>(word, 1));

		JavaPairRDD<String, Integer> rdd5 = rdd4.reduceByKey((a, b) -> a + b);

		JavaPairRDD<String, Integer> rdd6 = rdd5.sortByKey();
		result = rdd6.collect().toString();

		sc.stop();
		sc.close();
		return result;
	
		
	}
}
