package exercise2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();	
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {	
		System.out.print("reduce : "+key+"---");
		int sum = 0;
		for (IntWritable val : values) {
			int data = val.get();
			System.out.print(data+" ");
			sum += data;
			
		}
		
		result.set(sum);
		if(sum>=4) {
			context.write(key, result);
		}
	}
}