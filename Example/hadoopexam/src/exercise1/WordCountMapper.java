package exercise1;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();	

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		System.out.println("map : "+key+"---"+value);
		
		StringTokenizer itr = new StringTokenizer(value.toString());
		
			while (itr.hasMoreTokens()) {
				word.set(itr.nextToken());
				if(word.getLength()>=3 && word.getLength()<=5) {
				context.write(word, one);
				}
			}	
		
	}
}