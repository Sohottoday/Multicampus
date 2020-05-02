package mrexam;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	//맵퍼가 내보내는 형식은 
	//Mapper<key타입 value타입 key타입 value타입>
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();	//계속 생성하면 비효율적이므로 한번 만들어서 계속 사용.

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		System.out.println("map : "+key+"---"+value);
		
		StringTokenizer itr = new StringTokenizer(value.toString());	//원하는 단위로 쪼갤 수 있는 api(StringTokenizer) //context객체 = 컨테이너 객체 = 하둡의 mapreduce 객체
		while (itr.hasMoreTokens()) {
			word.set(itr.nextToken());
			context.write(word, one);
		}	//행단위로 호출되므로 행의 갯수만큼 반복됨.
	}
}